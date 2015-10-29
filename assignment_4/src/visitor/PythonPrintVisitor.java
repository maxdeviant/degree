package visitor;

import syntaxtree.*;

/**
 * @author Marshall Bowers
 */
public class PythonPrintVisitor implements Visitor {

    private int indentLevel = 0;

    @Override
    public void visit(Program n) {
        sendVisitAlert(n);

        n.mainClass.accept(this);

        for (int i = 0; i < n.classDeclList.size(); i++) {
            System.out.println();

            n.classDeclList.elementAt(i).accept(this);
        }
    }

    @Override
    public void visit(MainClass n) {
        sendVisitAlert(n);

        System.out.print("class ");

        n.identifier.accept(this);

        System.out.print("(");

        n.identifierTwo.accept(this);

        System.out.print(")");

        System.out.println(":");

        n.statement.accept(this);
    }

    @Override
    public void visit(ClassDeclSimple n) {
        sendVisitAlert(n);

        System.out.print("class ");

        n.identifier.accept(this);

        System.out.print("(");

        for (int i = 0; i < n.varDeclList.size(); i++) {
            n.varDeclList.elementAt(i).accept(this);

            if (i + 1 < n.varDeclList.size()) {
                System.out.println();
            }
        }

        System.out.print(")");

        System.out.print(":");

//        indent();

        for (int i = 0; i < n.methodDeclList.size(); i++) {
            System.out.println();

            printIndent();

            n.methodDeclList.elementAt(i).accept(this);
        }
    }

    @Override
    public void visit(ClassDeclExtends n) {
        sendVisitAlert(n);
    }

    @Override
    public void visit(VarDecl n) {
        sendVisitAlert(n);

//        n.identifier.accept(this);
    }

    @Override
    public void visit(MethodDecl n) {
        sendVisitAlert(n);

        System.out.print("def ");

        n.identifier.accept(this);

        System.out.print("(");

        for (int i = 0; i < n.formalList.size(); i++) {
            n.formalList.elementAt(i).accept(this);

            if (i + 1 < n.formalList.size()) {
                System.out.print(", ");
            }
        }

        System.out.print(")");

        System.out.println(":");

        indent();

        for (int i = 0; i < n.varDeclList.size(); i++) {
            printIndent();

            n.varDeclList.elementAt(i).accept(this);
        }

        for (int i = 0; i < n.statementList.size(); i++) {
            printIndent();

            n.statementList.elementAt(i).accept(this);

            if (i < n.statementList.size()) {
                System.out.println();
            }
        }

        printIndent();

        System.out.print("return ");

        n.exp.accept(this);

        unindent();
    }

    @Override
    public void visit(Formal n) {
        sendVisitAlert(n);
    }

    @Override
    public void visit(IntArrayType n) {
        sendVisitAlert(n);
    }

    @Override
    public void visit(BooleanType n) {
        sendVisitAlert(n);
    }

    @Override
    public void visit(IntegerType n) {
        sendVisitAlert(n);
    }

    @Override
    public void visit(IdentifierType n) {
        sendVisitAlert(n);
    }

    @Override
    public void visit(Block n) {
        sendVisitAlert(n);
    }

    @Override
    public void visit(If n) {
        sendVisitAlert(n);
    }

    @Override
    public void visit(While n) {
        sendVisitAlert(n);
    }

    @Override
    public void visit(Print n) {
        sendVisitAlert(n);
    }

    @Override
    public void visit(Println n) {
        sendVisitAlert(n);
    }

    @Override
    public void visit(Assign n) {
        sendVisitAlert(n);

        n.identifier.accept(this);

        System.out.print(" = ");

        n.exp.accept(this);
    }

    @Override
    public void visit(ArrayAssign n) {
        sendVisitAlert(n);

        n.identifier.accept(this);

        System.out.print(" = ");

        n.lhs.accept(this);

        n.rhs.accept(this);
    }

    @Override
    public void visit(And n) {
        sendVisitAlert(n);
    }

    @Override
    public void visit(Or n) {
        sendVisitAlert(n);
    }

    @Override
    public void visit(LessThan n) {
        sendVisitAlert(n);
    }

    @Override
    public void visit(Equals n) {
        sendVisitAlert(n);
    }

    @Override
    public void visit(Plus n) {
        sendVisitAlert(n);
    }

    @Override
    public void visit(PlusEquals n) {
        sendVisitAlert(n);
    }

    @Override
    public void visit(Minus n) {
        sendVisitAlert(n);

        n.lhs.accept(this);

        System.out.print(" - ");

        n.rhs.accept(this);
    }

    @Override
    public void visit(Times n) {
        sendVisitAlert(n);
    }

    @Override
    public void visit(ArrayLookup n) {
        sendVisitAlert(n);
    }

    @Override
    public void visit(ArrayLength n) {
        sendVisitAlert(n);
    }

    @Override
    public void visit(Call n) {
        sendVisitAlert(n);
    }

    @Override
    public void visit(IntegerLiteral n) {
        sendVisitAlert(n);

        System.out.print(n.integer);
    }

    @Override
    public void visit(True n) {
        sendVisitAlert(n);

        System.out.print("True");
    }

    @Override
    public void visit(False n) {
        sendVisitAlert(n);

        System.out.print("False");
    }

    @Override
    public void visit(IdentifierExp n) {
        sendVisitAlert(n);

        System.out.print(n.string);
    }

    @Override
    public void visit(This n) {
        sendVisitAlert(n);

        System.out.print("self");
    }

    @Override
    public void visit(NewArray n) {
        sendVisitAlert(n);

        System.out.print("[]");
    }

    @Override
    public void visit(NewObject n) {
        sendVisitAlert(n);

        System.out.print("new ");

        System.out.print(n.identifier.string);

        System.out.print("()");
    }

    @Override
    public void visit(Not n) {
        sendVisitAlert(n);

        System.out.print(" not ");

        n.exp.accept(this);
    }

    @Override
    public void visit(Identifier n) {
        sendVisitAlert(n);

        System.out.print(n.string);
    }

    /**
     * Indents the source code.
     */
    private void printIndent() {
        printIndent(indentLevel);
    }

    /**
     * Indents the source code by the given number of levels.
     *
     * @param levels The number of levels to printIndent by.
     */
    private void printIndent(int levels) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < levels; i++) {
            builder.append("····");
        }

        System.out.print(builder.toString());
    }

    private void indent() {
        indentLevel++;
    }

    private void unindent() {
        indentLevel--;
    }

    private void sendVisitAlert(Object o) {
//        System.out.println("[VISITING] " + o.getClass().getSimpleName());
    }
}
