package visitor;

import syntaxtree.*;

public class DepthFirstVisitor implements Visitor {

    // MainClass mainClass;
    // ClassDeclList classDeclList;
    public void visit(Program n) {
        n.mainClass.accept(this);
        for (int i = 0; i < n.classDeclList.size(); i++) {
            n.classDeclList.elementAt(i).accept(this);
        }
    }

    // Identifier identifier,identifierTwo;
    // Statement string;
    public void visit(MainClass n) {
        n.identifier.accept(this);
        n.identifierTwo.accept(this);
        n.statement.accept(this);
    }

    // Identifier identifier;
    // VarDeclList varDeclList;
    // MethodDeclList methodDeclList;
    public void visit(ClassDeclSimple n) {
        n.identifier.accept(this);

        for (int i = 0; i < n.varDeclList.size(); i++) {
            n.varDeclList.elementAt(i).accept(this);
        }

        for (int i = 0; i < n.methodDeclList.size(); i++) {
            n.methodDeclList.elementAt(i).accept(this);
        }
    }

    // Identifier identifier;
    // Identifier identifierTwo;
    // VarDeclList varDeclList;
    // MethodDeclList methodDeclList;
    public void visit(ClassDeclExtends n) {
        n.identifier.accept(this);
        n.identifierTwo.accept(this);
        for (int i = 0; i < n.varDeclList.size(); i++) {
            n.varDeclList.elementAt(i).accept(this);
        }
        for (int i = 0; i < n.methodDeclList.size(); i++) {
            n.methodDeclList.elementAt(i).accept(this);
        }
    }

    // Type type;
    // Identifier identifier;
    public void visit(VarDecl n) {
        n.type.accept(this);
        n.identifier.accept(this);
    }

    // Type type;
    // Identifier identifier;
    // FormalList formalList;
    // VarDeclList varDeclList;
    // StatementList statementList;
    // Exp lhs;
    public void visit(MethodDecl n) {
        n.type.accept(this);
        n.identifier.accept(this);

        for (int i = 0; i < n.formalList.size(); i++) {
            n.formalList.elementAt(i).accept(this);
        }

        for (int i = 0; i < n.varDeclList.size(); i++) {
            n.varDeclList.elementAt(i).accept(this);
        }

        for (int i = 0; i < n.statementList.size(); i++) {
            n.statementList.elementAt(i).accept(this);
        }

        n.exp.accept(this);
    }

    // Type type;
    // Identifier identifier;
    public void visit(Formal n) {
        n.type.accept(this);
        n.identifier.accept(this);
    }

    public void visit(IntArrayType n) {
    }

    public void visit(BooleanType n) {
    }

    public void visit(IntegerType n) {
    }

    // String string;
    public void visit(IdentifierType n) {
    }

    // StatementList statementList;
    public void visit(Block n) {
        for (int i = 0; i < n.statementList.size(); i++) {
            n.statementList.elementAt(i).accept(this);
        }
    }

    // Exp lhs;
    // Statement statement,statementTwo;
    public void visit(If n) {
        n.exp.accept(this);
        n.statement.accept(this);
        n.statementTwo.accept(this);
    }

    // Exp lhs;
    // Statement string;
    public void visit(While n) {
        n.exp.accept(this);
        n.statement.accept(this);
    }

    // Exp lhs;
    public void visit(Print n) {
        n.e.accept(this);
    }

    @Override
    public void visit(Println n) {

    }

    // Identifier identifier;
    // Exp lhs;
    public void visit(Assign n) {
        n.identifier.accept(this);
        n.exp.accept(this);
    }

    // Identifier identifier;
    // Exp lhs,rhs;
    public void visit(ArrayAssign n) {
        n.identifier.accept(this);
        n.lhs.accept(this);
        n.rhs.accept(this);
    }

    // Exp lhs,rhs;
    public void visit(And n) {
        n.lhs.accept(this);
        n.rhs.accept(this);
    }

    @Override
    public void visit(Or n) {

    }

    // Exp lhs,rhs;
    public void visit(LessThan n) {
        n.lhs.accept(this);
        n.rhs.accept(this);
    }

    @Override
    public void visit(Equals n) {

    }

    // Exp lhs,rhs;
    public void visit(Plus n) {
        n.lhs.accept(this);
        n.rhs.accept(this);
    }

    @Override
    public void visit(PlusEquals n) {

    }

    // Exp lhs,rhs;
    public void visit(Minus n) {
        n.lhs.accept(this);
        n.rhs.accept(this);
    }

    // Exp lhs,rhs;
    public void visit(Times n) {
        n.lhs.accept(this);
        n.rhs.accept(this);
    }

    // Exp lhs,rhs;
    public void visit(ArrayLookup n) {
        n.lhs.accept(this);
        n.rhs.accept(this);
    }

    // Exp lhs;
    public void visit(ArrayLength n) {
        n.exp.accept(this);
    }

    // Exp lhs;
    // Identifier identifier;
    // ExpList expList;
    public void visit(Call n) {
        n.exp.accept(this);
        n.identifier.accept(this);
        for (int i = 0; i < n.expList.size(); i++) {
            n.expList.elementAt(i).accept(this);
        }
    }

    // int identifier;
    public void visit(IntegerLiteral n) {
    }

    public void visit(True n) {
    }

    public void visit(False n) {
    }

    // String string;
    public void visit(IdentifierExp n) {
    }

    public void visit(This n) {
    }

    // Exp lhs;
    public void visit(NewArray n) {
        n.exp.accept(this);
    }

    // Identifier identifier;
    public void visit(NewObject n) {
    }

    // Exp lhs;
    public void visit(Not n) {
        n.exp.accept(this);
    }

    // String string;
    public void visit(Identifier n) {
    }
}
