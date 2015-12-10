package visitor;

import symboltable.RamClass;
import symboltable.RamMethod;
import symboltable.RamVariable;
import symboltable.Table;
import syntaxtree.*;

import java.io.PrintStream;

public class CodeGenerator extends DepthFirstVisitor {

    public static final int FRAME_MIN = 16;
    private static int labelId = 0;
    private PrintStream out;
    private Table symTable;
    private StringBuilder dataString;

    private RamClass currentClass;
    private RamMethod currentMethod;

    public CodeGenerator(java.io.PrintStream out, Table symTable) {
        this.out = out;
        this.symTable = symTable;
        initDataString();
    }

    private int nextLabel() {
        return labelId++;
    }

    private void initDataString() {
        dataString = new StringBuilder();
        dataString.append("newline: .asciiz \"\\n\"\n");
        dataString.append("space: .asciiz \" \"\n");
    }

    private void emit(String s) {
        out.println("\t" + s);
    }

    private void emit(String s, String comment) {
        out.printf("\t%-40s%s\n", s, "# " + comment);
    }

    private void emitLabel(String l) {
        out.println(l + ":");
    }

    private void emitComment(String s) {
        out.println("\t# " + s);
    }

    @Override
    public void visit(Program n) {
        emit(".text");
        emit(".globl main");

        n.mainClass.accept(this);
        for (int i = 0; i < n.classDeclList.size(); i++) {
            n.classDeclList.elementAt(i).accept(this);
        }

        emit("");
        emit(".data");

        out.println(dataString.toString());
    }

    @Override
    public void visit(MainClass n) {
        currentClass = symTable.getClass(n.identifier.string);
        currentMethod = currentClass.getMethod("main");

        emitLabel("main");

        emitComment("begin prologue -- main");
        emit("subu $sp, $sp, 24    # stack frame is at least 24 bytes");
        emit("sw $fp, 4($sp)       # save caller's frame pointer");
        emit("sw $ra, 0($sp)       # save return address");

        emit("addi $fp, $sp, 20    # set up main's frame pointer");
        emitComment("end prologue -- main");

        n.statement.accept(this);

        emitComment("begin epilogue -- main");
        emit("lw $ra, 0($sp)       # restore return address");
        emit("lw $fp, 4($sp)       # restore caller's frame pointer");
        emit("addi $sp, $sp, 24    # pop the stack");
        emitComment("end epilogue -- main");


        emit("li $v0, 10");
        emit("syscall");

        currentClass = null;
    }

    @Override
    public void visit(IntegerLiteral n) {
        emit("li $v0, " + n.integer);
    }

    @Override
    public void visit(Print n) {
        emitComment("begin Print");

        for (int i = 0; i < n.expList.size(); i++) {
            n.expList.elementAt(i).accept(this);

            emit("move $a0, $v0");
            emit("li $v0, 1");
            emit("syscall");

            if (i < n.expList.size() - 1) {
                emit("la $a0, space");
                emit("li $v0, 4");
                emit("syscall");
            }
        }

        emitComment("end Print");
    }

    @Override
    public void visit(Println n) {
        emitComment("begin Println");

        for (int i = 0; i < n.expList.size(); i++) {
            n.expList.elementAt(i).accept(this);

            emit("move $a0, $v0");
            emit("li $v0, 1");
            emit("syscall");

            if (i < n.expList.size() - 1) {
                emit("la $a0, space");
                emit("li $v0, 4");
                emit("syscall");
            }
        }

        emit("la $a0, newline");
        emit("li $v0, 4");
        emit("syscall");

        emitComment("end Println");
    }

    @Override
    public void visit(Plus n) {
        emitComment("begin Plus");

        n.lhs.accept(this);

        emit("subu $sp, $sp, 4");
        emit("sw $v0, ($sp)");

        n.rhs.accept(this);

        emit("lw $t1, ($sp)");
        emit("addu $sp, $sp, 4");

        emit("add $v0, $t1, $v0");

        emitComment("end Plus");
    }

    @Override
    public void visit(Minus n) {
        emitComment("begin Minus");

        n.lhs.accept(this);

        emit("subu $sp, $sp, 4");
        emit("sw $v0, ($sp)");

        n.rhs.accept(this);

        emit("lw $t1, ($sp)");
        emit("addu $sp, $sp, 4");

        emit("sub $v0, $t1, $v0");

        emitComment("end Minus");
    }

    @Override
    public void visit(Times n) {
        emitComment("begin Times");

        n.lhs.accept(this);

        emit("subu $sp, $sp, 4");
        emit("sw $v0, ($sp)");

        n.rhs.accept(this);

        emit("lw $t1, ($sp)");
        emit("addu $sp, $sp, 4");

        emit("mul $v0, $t1, $v0");

        emitComment("end Times");
    }

    @Override
    public void visit(True n) {
        emit("li $v0, 1");
    }

    @Override
    public void visit(False n) {
        emit("li $v0, 0");
    }

    @Override
    public void visit(If n) {
        int label = nextLabel();

        n.exp.accept(this);

        emit(String.format("beqz $v0, ifFalse%d", label));

        n.statement.accept(this);

        emit("j isDone" + label);
        emitLabel("ifFalse" + label);

        n.statementTwo.accept(this);

        emitLabel("isDone" + label);
    }

    @Override
    public void visit(And n) {
        emitComment("start And");

        n.lhs.accept(this);

        emit("subu $sp, $sp, 4");
        emit("sw $v0, ($sp)");

        n.rhs.accept(this);

        emit("lw $t1, ($sp)");
        emit("addu $sp, $sp, 4");

        emit("and $v0, $t1, $v0");

        emitComment("end And");
    }

    @Override
    public void visit(Or n) {
        emitComment("start Or");

        n.lhs.accept(this);

        emit("subu $sp, $sp, 4");
        emit("sw $v0, ($sp)");

        n.rhs.accept(this);

        emit("lw $t1, ($sp)");
        emit("addu $sp, $sp, 4");

        emit("or $v0, $t1, $v0");

        emitComment("end Or");
    }

    @Override
    public void visit(LessThan n) {
        emitComment("start LessThan");

        n.lhs.accept(this);

        emit("subu $sp, $sp, 4");
        emit("sw $v0, ($sp)");

        n.rhs.accept(this);

        emit("lw $t1, ($sp)");
        emit("addu $sp, $sp, 4");

        emit("slt $v0, $t1, $v0");

        emitComment("end LessThan");
    }

    @Override
    public void visit(Equals n) {
        emitComment("start Equals");

        n.lhs.accept(this);

        emit("subu $sp, $sp, 4");
        emit("sw $v0, ($sp)");

        n.rhs.accept(this);

        emit("lw $t1, ($sp)");
        emit("addu $sp, $sp, 4");

        emit("seq $v0, $t1, $v0");

        emitComment("end Equals");
    }

    @Override
    public void visit(Not n) {
        emitComment("start Not");

        n.exp.accept(this);

        emit("xori $v0, $v0, 1");

        emitComment("end Not");
    }

    @Override
    public void visit(Call n) {
        emitComment("start Call");

        for (int i = n.expList.size() - 1; i >= 0; i--) {
            n.expList.elementAt(i).accept(this);

            emit("subu $sp, $sp, 4");
            emit("sw $v0, ($sp)");
        }

        emit("jal " + n.identifier.string);
        emit("addi $sp, $sp, 4");

        emitComment("end Call");
    }

    @Override
    public void visit(MethodDecl n) {
        currentMethod = currentClass.getMethod(n.identifier.string);

        emitLabel(n.identifier.string);

        emit("subu $sp, $sp, 16");
        emit("sw $fp, 8($sp)");
        emit("sw $ra, 0($sp)");
        emit("addu $fp, $sp, 12");

        super.visit(n);

        emit("lw $ra, -12($fp)");
        emit("lw $fp, -4($fp)");
        emit("addi $sp, $sp, 16");
        emit("jr $ra");

        currentMethod = null;
    }

    @Override
    public void visit(ClassDeclSimple n) {
        currentClass = symTable.getClass(n.identifier.string);
        currentMethod = null;

        super.visit(n);

        currentClass = null;
    }

    @Override
    public void visit(Identifier n) {
        RamVariable variable;

        if (currentMethod == null) {
            variable = currentClass.getVar(n.string);
        } else {
            variable = currentMethod.getVar(n.string);

            if (variable == null) {
                variable = currentMethod.getParam(n.string);
            }
        }

        if (variable != null) {
            emit("addi $v0, $fp, " + variable.offset());
        }
    }

    @Override
    public void visit(IdentifierExp n) {
        RamVariable variable;

        if (currentMethod == null) {
            variable = currentClass.getVar(n.string);
        } else {
            variable = currentMethod.getVar(n.string);

            if (variable == null) {
                variable = currentMethod.getParam(n.string);
            }
        }

        if (variable != null) {
            emit("addi $v0, $fp, " + variable.offset());
            emit("lw $v0, ($v0)");
        }
    }

    @Override
    public void visit(Assign n) {
        n.exp.accept(this);

        emit("subu $sp, $sp, 4");
        emit("sw $v0, ($sp)");

        n.identifier.accept(this);

        emit("lw $t1, ($sp)");
        emit("addu $sp, $sp, 4");

        emit("sw $t1, ($v0)");
    }

}
