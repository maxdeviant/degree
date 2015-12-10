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
        emit("subu $sp, $sp, 16", "stack frame is at least 16 bytes");
        emit("sw $fp, 8($sp)", "save caller's frame pointer");
        emit("sw $ra, 0($sp)", "save return address");
        emit("addu $fp, $sp, 12", "set main's frame pointer");
        emitComment("end prologue -- main");

        n.statement.accept(this);

        emitComment("begin epilogue -- main");
        emit("lw $ra, -4($fp)", "restore return address");
        emit("lw $fp, -12($fp)", "restore caller's frame pointer");
        emit("addi $sp, $sp, 16", "pop the stack");
        emitComment("end epilogue -- main");

        emit("li $v0, 10", "set syscall to exit");
        emit("syscall", "exit");

        currentClass = null;
    }

    @Override
    public void visit(IntegerLiteral n) {
        emit("li $v0, " + n.integer, "move int val to $v0");
    }

    @Override
    public void visit(Print n) {
        emitComment("begin print");

        for (int i = 0; i < n.expList.size(); i++) {
            n.expList.elementAt(i).accept(this);

            emit("move $a0, $v0", "move int to syscall arg");
            emit("li $v0, 1", "set syscall to print int");
            emit("syscall", "print int");

            if (i < n.expList.size() - 1) {
                emit("la $a0, space", "move space to syscall arg");
                emit("li $v0, 4", "set syscall to print string");
                emit("syscall", "print space");
            }
        }

        emitComment("end print");
    }

    @Override
    public void visit(Println n) {
        emitComment("begin println");

        for (int i = 0; i < n.expList.size(); i++) {
            n.expList.elementAt(i).accept(this);

            emit("move $a0, $v0", "move int to syscall arg");
            emit("li $v0, 1", "set syscall to print int");
            emit("syscall", "print int");

            if (i < n.expList.size() - 1) {
                emit("la $a0, space", "move space to syscall arg");
                emit("li $v0, 4", "set syscall to print string");
                emit("syscall", "print space");
            }
        }

        emit("la $a0, newline", "move newline to syscall arg");
        emit("li $v0, 4", "set syscall to print string");
        emit("syscall", "print newline");

        emitComment("end println");
    }

    @Override
    public void visit(Plus n) {
        emitComment("begin plus");

        n.lhs.accept(this);

        emit("subu $sp, $sp, 4", "increase stack by one word");
        emit("sw $v0, ($sp)", "save addend to stack");

        n.rhs.accept(this);

        emit("lw $t1, ($sp)", "load addend from stack");
        emit("addu $sp, $sp, 4", "pop addend from stack");

        emit("add $v0, $t1, $v0", "calculate sum");
        emitComment("end plus");
    }

    @Override
    public void visit(Minus n) {
        emitComment("begin minus");

        n.lhs.accept(this);

        emit("subu $sp, $sp, 4", "increase stack by one word");
        emit("sw $v0, ($sp)", "save minuend to stack");

        n.rhs.accept(this);

        emit("lw $t1, ($sp)", "load minuend from stack");
        emit("addu $sp, $sp, 4", "pop minuend from stack");

        emit("sub $v0, $t1, $v0", "calculate difference");
        emitComment("end minus");
    }

    @Override
    public void visit(Times n) {
        emitComment("begin times");

        n.lhs.accept(this);

        emit("subu $sp, $sp, 4", "increase stack by one word");
        emit("sw $v0, ($sp)", "save multiplicand to stack");

        n.rhs.accept(this);

        emit("lw $t1, ($sp)", "load multiplicand from stack");
        emit("addu $sp, $sp, 4", "pop multiplicand from stack");

        emit("mul $v0, $t1, $v0", "calculate product");
        emitComment("end times");
    }

    @Override
    public void visit(True n) {
        emit("li $v0, 1", "move true val to $v0");
    }

    @Override
    public void visit(False n) {
        emit("li $v0, 0", "move false val to $v0");
    }

    @Override
    public void visit(If n) {
        int label = nextLabel();

        n.exp.accept(this);

        emit("beqz $v0, ifFalse" + label, "if false, goto branch 'ifFalse" + label + "'");

        n.statement.accept(this);

        emit("j isDone" + label);
        emitLabel("ifFalse" + label);

        n.statementTwo.accept(this);

        emitLabel("isDone" + label);
    }

    @Override
    public void visit(And n) {
        emitComment("start and");

        n.lhs.accept(this);

        emit("subu $sp, $sp, 4", "increase stack by one word");
        emit("sw $v0, ($sp)", "save bool to stack");

        n.rhs.accept(this);

        emit("lw $t1, ($sp)", "load bool from stack");
        emit("addu $sp, $sp, 4", "pop bool from stack");

        emit("and $v0, $t1, $v0", "calculate and");
        emitComment("end and");
    }

    @Override
    public void visit(Or n) {
        emitComment("start Or");

        n.lhs.accept(this);

        emit("subu $sp, $sp, 4", "increase stack by one word");
        emit("sw $v0, ($sp)", "save bool to stack");

        n.rhs.accept(this);

        emit("lw $t1, ($sp)", "load bool from stack");
        emit("addu $sp, $sp, 4", "pop bool from stack");

        emit("or $v0, $t1, $v0", "calculate or");
        emitComment("end Or");
    }

    @Override
    public void visit(LessThan n) {
        emitComment("start LessThan");

        n.lhs.accept(this);

        emit("subu $sp, $sp, 4", "increase stack by one word");
        emit("sw $v0, ($sp)", "save int to stack");

        n.rhs.accept(this);

        emit("lw $t1, ($sp)", "load int from stack");
        emit("addu $sp, $sp, 4", "pop int from stack");

        emit("slt $v0, $t1, $v0", "calculate lessThan");
        emitComment("end LessThan");
    }

    @Override
    public void visit(Equals n) {
        emitComment("start equals");
        n.lhs.accept(this); // resulting bool saved in $v0
        emit("subu $sp, $sp, 4", "increase stack by one word");
        emit("sw $v0, ($sp)", "save bool to stack");

        n.rhs.accept(this); // resulting int saved in $v0
        emit("lw $t1, ($sp)", "load bool from stack");
        emit("addu $sp, $sp, 4", "pop bool from stack");

        emit("seq $v0, $t1, $v0", "calculate equals");
        emitComment("end equals");
    }

    @Override
    public void visit(Not n) {
        emitComment("start not");

        n.exp.accept(this);

        emit("xori $v0, $v0, 1", "calculate not");

        emitComment("end not");
    }

    @Override
    public void visit(Call n) {
        emitComment("start call");

        for (int i = n.expList.size() - 1; i >= 0; i--) {
            n.expList.elementAt(i).accept(this);

            emit("subu $sp, $sp, 4", "increase stack by one word");
            emit("sw $v0, ($sp)", "save arg to stack");
        }
        emit("jal " + n.identifier.string, "jump to " + n.identifier.string);
        emit("addi $sp, $sp, 4", "pop the stack");
    }

    @Override
    public void visit(MethodDecl n) {
        currentMethod = currentClass.getMethod(n.identifier.string);

        emitLabel(n.identifier.string);

        emit("subu $sp, $sp, 16", "stack frame is at least 16 bytes");
        emit("sw $fp, 8($sp)", "save caller's frame pointer");
        emit("sw $ra, 0($sp)", "save return address");
        emit("addu $fp, $sp, 12", "set " + n.identifier.string + "'s frame pointer");

        super.visit(n);

        emit("lw $ra, -12($fp)", "restore return address");
        emit("lw $fp, -4($fp)", "restore caller's frame pointer");
        emit("addi $sp, $sp, 16", "pop the stack");
        emit("jr $ra", "jump to previous call");

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
            emit("addi $v0, $fp, " + variable.offset(), "save identifier memory reference in $v0");
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
            emit("addi $v0, $fp, " + variable.offset(), "save identifier memory reference in $v0");
            emit("lw $v0, ($v0)", "load identifier from stack");
        }
    }

    @Override
    public void visit(Assign n) {
        n.exp.accept(this);

        emit("subu $sp, $sp, 4", "increase stack by one word");
        emit("sw $v0, ($sp)", "save exp result to stack");

        n.identifier.accept(this);

        emit("lw $t1, ($sp)", "load exp result from stack");
        emit("addu $sp, $sp, 4", "pop exp result from stack");

        emit("sw $t1, ($v0)", "assign value to memory address of identifier");
    }

}
