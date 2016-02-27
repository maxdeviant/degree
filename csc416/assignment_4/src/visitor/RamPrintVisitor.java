package visitor;

import syntaxtree.*;

/**
 * @author Marshall Bowers
 */
public class RamPrintVisitor implements Visitor {

    /**
     * The current indentation level.
     */
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
        System.out.print("class ");

        n.identifier.accept(this);

        System.out.println(" {");

        indent();

        printIndent();

        System.out.print("public static void main (String[] ");

        n.identifierTwo.accept(this);

        System.out.println(") {");

        printIndent();

        n.statement.accept(this);

        System.out.println("}");

        unindent();

        System.out.print("}");
    }

    @Override
    public void visit(ClassDeclSimple n) {

    }

    @Override
    public void visit(ClassDeclExtends n) {

    }

    @Override
    public void visit(VarDecl n) {
        n.type.accept(this);

        System.out.print(" ");

        n.identifier.accept(this);

        System.out.print(";");
    }

    @Override
    public void visit(MethodDecl n) {

    }

    @Override
    public void visit(Formal n) {
        n.type.accept(this);

        System.out.print(" ");

        n.identifier.accept(this);
    }

    @Override
    public void visit(IntArrayType n) {
        System.out.print("int[]");
    }

    @Override
    public void visit(BooleanType n) {
        System.out.print("bool");
    }

    @Override
    public void visit(IntegerType n) {
        System.out.print("int");
    }

    @Override
    public void visit(IdentifierType n) {
        System.out.print(n.string);
    }

    @Override
    public void visit(Block n) {
        System.out.println("{");

        for (int i = 0; i < n.statementList.size(); i++) {

            printIndent();

            n.statementList.elementAt(i).accept(this);

            System.out.println();
        }

        printIndent();

        System.out.println("}");
    }

    @Override
    public void visit(If n) {
        System.out.print("if (");

        n.exp.accept(this);

        System.out.println(") {");

        indent();

        printIndent();

        n.statement.accept(this);

        System.out.println();

        printIndent();

        System.out.println("} else {");

        n.statementTwo.accept(this);

        System.out.println("}");
    }

    @Override
    public void visit(While n) {

    }

    @Override
    public void visit(Print n) {
        System.out.print("System.out.print(");

        for (int i = 0; i < n.expList.size(); i++) {
            n.expList.elementAt(i).accept(this);

            if (i != n.expList.size() - 1) {
                System.out.print("+\" \"+");
            }
        }

        System.out.print(")");
    }

    @Override
    public void visit(Println n) {

    }

    @Override
    public void visit(Assign n) {
        n.identifier.accept(this);

        System.out.print(" = ");

        n.exp.accept(this);
    }

    @Override
    public void visit(ArrayAssign n) {

    }

    @Override
    public void visit(And n) {

    }

    @Override
    public void visit(Or n) {

    }

    @Override
    public void visit(LessThan n) {

    }

    @Override
    public void visit(Equals n) {

    }

    @Override
    public void visit(Plus n) {

    }

    @Override
    public void visit(PlusEquals n) {

    }

    @Override
    public void visit(Minus n) {

    }

    @Override
    public void visit(MinusEquals n) {

    }

    @Override
    public void visit(Times n) {

    }

    @Override
    public void visit(ArrayLookup n) {

    }

    @Override
    public void visit(ArrayLength n) {

    }

    @Override
    public void visit(Call n) {

    }

    @Override
    public void visit(IntegerLiteral n) {

    }

    @Override
    public void visit(True n) {
        System.out.print("true");
    }

    @Override
    public void visit(False n) {
        System.out.print("false");
    }

    @Override
    public void visit(IdentifierExp n) {

    }

    @Override
    public void visit(Slice n) {

    }

    @Override
    public void visit(This n) {
        System.out.print("this");
    }

    @Override
    public void visit(NewArray n) {
        System.out.print("new int[");

        n.exp.accept(this);

        System.out.print("]");
    }

    @Override
    public void visit(NewObject n) {
        System.out.print("new ");

        System.out.print(n.identifier.string);

        System.out.print("()");
    }

    @Override
    public void visit(Not n) {
        System.out.print("!");

        n.exp.accept(this);
    }

    @Override
    public void visit(Identifier n) {
        System.out.print(n.string);
    }

    /**
     * Indents the source code by the given number of levels.
     *
     * @param levels The number of levels to indent by.
     */
    private void printIndent(int levels) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < levels; i++) {
            builder.append("    ");
        }

        System.out.print(builder.toString());
    }

    /**
     * Indents the source code using the current indent level.
     */
    private void printIndent() {
        printIndent(indentLevel);
    }

    /**
     * Increase the current indentation level by one.
     */
    private void indent() {
        indentLevel++;
    }

    /**
     * Decrease the current indentation level by one.
     */
    private void unindent() {
        indentLevel--;
    }

}
