package visitor;

import syntaxtree.*;

/**
 * @author Marshall Bowers
 */
public class PythonPrintVisitor implements Visitor {

    private int indentLevel = 0;

    @Override
    public void visit(Program n) {
        for (int i = 0; i < n.classDeclList.size(); i++) {
            n.classDeclList.elementAt(i).accept(this);

            System.out.println();
        }

        n.mainClass.accept(this);
    }

    @Override
    public void visit(MainClass n) {
        System.out.println("if __name__ == '__main__':");

        indent();

        printIndent();

        n.statement.accept(this);
    }

    @Override
    public void visit(ClassDeclSimple n) {
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

        indent();

        for (int i = 0; i < n.methodDeclList.size(); i++) {
            System.out.println();

            printIndent();

            n.methodDeclList.elementAt(i).accept(this);

            System.out.println();
        }

        System.out.println();

        unindent();
    }

    @Override
    public void visit(ClassDeclExtends n) {
    }

    @Override
    public void visit(VarDecl n) {
//        n.identifier.accept(this);
    }

    @Override
    public void visit(MethodDecl n) {
        System.out.print("def ");

        n.identifier.accept(this);

        System.out.print("(");

        System.out.print("self");

        if (n.formalList.size() > 0) {
            System.out.print(", ");
        }

        for (int i = 0; i < n.formalList.size(); i++) {
            n.formalList.elementAt(i).accept(this);

            if (i + 1 < n.formalList.size()) {
                System.out.print(", ");
            }
        }

        System.out.print(")");

        System.out.println(":");

        indent();

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
        n.identifier.accept(this);
    }

    @Override
    public void visit(IntArrayType n) {
    }

    @Override
    public void visit(BooleanType n) {
    }

    @Override
    public void visit(IntegerType n) {
    }

    @Override
    public void visit(IdentifierType n) {
    }

    @Override
    public void visit(Block n) {
        for (int i = 0; i < n.statementList.size(); i++) {

            n.statementList.elementAt(i).accept(this);

            System.out.println();

            if (i + 1 < n.statementList.size()) {
                printIndent();
            }
        }
    }

    @Override
    public void visit(If n) {
        System.out.print("if ");

        n.exp.accept(this);

        System.out.println(":");

        indent();

        printIndent();

        n.statement.accept(this);

        System.out.println();

        unindent();

        printIndent();

        System.out.println("else:");

        indent();

        printIndent();

        n.statementTwo.accept(this);

        System.out.println();

        unindent();
    }

    @Override
    public void visit(While n) {
        System.out.print("while ");

        n.exp.accept(this);

        System.out.println(":");

        indent();

        printIndent();

        n.statement.accept(this);

        unindent();
    }

    @Override
    public void visit(Print n) {
        System.out.print("print ");

        for (int i = 0; i < n.expList.size(); i++) {
            n.expList.elementAt(i).accept(this);

            if (i != n.expList.size() - 1) {
                System.out.print("+\" \"+");
            }
        }
    }

    @Override
    public void visit(Println n) {
        System.out.print("print ");

        for (int i = 0; i < n.expList.size(); i++) {
            n.expList.elementAt(i).accept(this);

            if (i != n.expList.size() - 1) {
                System.out.print("+\" \"+");
            }
        }
    }

    @Override
    public void visit(Assign n) {
        n.identifier.accept(this);

        System.out.print(" = ");

        n.exp.accept(this);
    }

    @Override
    public void visit(ArrayAssign n) {
        n.identifier.accept(this);

        System.out.print("[");

        n.lhs.accept(this);

        System.out.print("]");

        System.out.print(" = ");

        n.rhs.accept(this);
    }

    @Override
    public void visit(And n) {
        n.lhs.accept(this);

        System.out.print(" and ");

        n.rhs.accept(this);
    }

    @Override
    public void visit(Or n) {
        n.lhs.accept(this);

        System.out.print(" or ");

        n.rhs.accept(this);
    }

    @Override
    public void visit(LessThan n) {
        n.lhs.accept(this);

        System.out.print(" < ");

        n.rhs.accept(this);
    }

    @Override
    public void visit(Equals n) {
        n.lhs.accept(this);

        System.out.print(" == ");

        n.rhs.accept(this);
    }

    @Override
    public void visit(Plus n) {
        n.lhs.accept(this);

        System.out.print(" + ");

        n.rhs.accept(this);
    }

    @Override
    public void visit(PlusEquals n) {
        n.identifier.accept(this);

        System.out.print(" += ");

        n.exp.accept(this);
    }

    @Override
    public void visit(Minus n) {
        n.lhs.accept(this);

        System.out.print(" - ");

        n.rhs.accept(this);
    }

    @Override
    public void visit(Times n) {
        n.lhs.accept(this);

        System.out.print(" * ");

        n.rhs.accept(this);
    }

    @Override
    public void visit(ArrayLookup n) {

        n.lhs.accept(this);

        System.out.print("[");

        n.rhs.accept(this);

        System.out.print("]");
    }

    @Override
    public void visit(ArrayLength n) {
        System.out.print("len(");

        n.exp.accept(this);

        System.out.print(")");
    }

    @Override
    public void visit(Call n) {
        n.exp.accept(this);

        System.out.print(".");

        n.identifier.accept(this);

        System.out.print("(");

        for (int i = 0; i < n.expList.size(); i++) {
            n.expList.elementAt(i).accept(this);

            if (i + 1 < n.expList.size()) {
                System.out.print(", ");
            }
        }

        System.out.print(")");
    }

    @Override
    public void visit(IntegerLiteral n) {
        System.out.print(n.integer);
    }

    @Override
    public void visit(True n) {
        System.out.print("True");
    }

    @Override
    public void visit(False n) {
        System.out.print("False");
    }

    @Override
    public void visit(IdentifierExp n) {
        System.out.print(n.string);
    }

    @Override
    public void visit(This n) {
        System.out.print("self");
    }

    @Override
    public void visit(NewArray n) {
        System.out.print("[]");
    }

    @Override
    public void visit(NewObject n) {
        System.out.print(n.identifier.string);

        System.out.print("()");
    }

    @Override
    public void visit(Not n) {
        System.out.print("not ");

        n.exp.accept(this);
    }

    @Override
    public void visit(Identifier n) {
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
//            builder.append("····");
            builder.append("    ");
        }

        System.out.print(builder.toString());
    }

    private void indent() {
        indentLevel++;
    }

    private void unindent() {
        indentLevel--;
    }

}
