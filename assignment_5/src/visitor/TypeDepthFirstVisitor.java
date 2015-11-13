package visitor;

import syntaxtree.*;

public class TypeDepthFirstVisitor implements TypeVisitor {

    // MainClass mainClass;
    // ClassDeclList classDeclList;
    public Type visit(Program n) {
        n.mainClass.accept(this);
        for (int i = 0; i < n.classDeclList.size(); i++) {
            n.classDeclList.elementAt(i).accept(this);
        }
        return null;
    }

    // Identifier identifier,identifierTwo;
    // Statement string;
    public Type visit(MainClass n) {
        n.identifier.accept(this);
        n.identifierTwo.accept(this);
        n.statement.accept(this);
        return null;
    }

    // Identifier identifier;
    // VarDeclList varDeclList;
    // MethodDeclList methodDeclList;
    public Type visit(ClassDeclSimple n) {
        n.identifier.accept(this);
        for (int i = 0; i < n.varDeclList.size(); i++) {
            n.varDeclList.elementAt(i).accept(this);
        }
        for (int i = 0; i < n.methodDeclList.size(); i++) {
            n.methodDeclList.elementAt(i).accept(this);
        }
        return null;
    }

    // Identifier identifier;
    // Identifier identifierTwo;
    // VarDeclList varDeclList;
    // MethodDeclList methodDeclList;
    public Type visit(ClassDeclExtends n) {
        n.identifier.accept(this);
        n.identifierTwo.accept(this);
        for (int i = 0; i < n.varDeclList.size(); i++) {
            n.varDeclList.elementAt(i).accept(this);
        }
        for (int i = 0; i < n.methodDeclList.size(); i++) {
            n.methodDeclList.elementAt(i).accept(this);
        }
        return null;
    }

    // Type type;
    // Identifier identifier;
    public Type visit(VarDecl n) {
        n.type.accept(this);
        n.identifier.accept(this);
        return null;
    }

    // Type type;
    // Identifier identifier;
    // FormalList formalList;
    // VarDeclList varDeclList;
    // StatementList statementList;
    // Exp lhs;
    public Type visit(MethodDecl n) {
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
        return null;
    }

    // Type type;
    // Identifier identifier;
    public Type visit(Formal n) {
        n.type.accept(this);
        n.identifier.accept(this);
        return null;
    }

    public Type visit(IntArrayType n) {
        return null;
    }

    public Type visit(BooleanType n) {
        return null;
    }

    public Type visit(IntegerType n) {
        return null;
    }

    // String string;
    public Type visit(IdentifierType n) {
        return null;
    }

    // StatementList statementList;
    public Type visit(Block n) {
        for (int i = 0; i < n.statementList.size(); i++) {
            n.statementList.elementAt(i).accept(this);
        }

        return null;
    }

    // Exp lhs;
    // Statement statement,statementTwo;
    public Type visit(If n) {
        n.exp.accept(this);
        n.statement.accept(this);
        n.statementTwo.accept(this);

        return null;
    }

    // Exp lhs;
    // Statement string;
    public Type visit(While n) {
        n.exp.accept(this);
        n.statement.accept(this);

        return null;
    }

    // Exp lhs;
    public Type visit(Print n) {
        for (int i = 0; i < n.expList.size(); i++) {
            n.expList.elementAt(i).accept(this);
        }

        return null;
    }

    @Override
    public Type visit(Println n) {
        return null;
    }

    // Identifier identifier;
    // Exp lhs;
    public Type visit(Assign n) {
        n.identifier.accept(this);
        n.exp.accept(this);

        return null;
    }

    // Identifier identifier;
    // Exp lhs,rhs;
    public Type visit(ArrayAssign n) {
        n.identifier.accept(this);
        n.lhs.accept(this);
        n.rhs.accept(this);

        return null;
    }

    // Exp lhs,rhs;
    public Type visit(And n) {
        n.lhs.accept(this);
        n.rhs.accept(this);

        return null;
    }

    @Override
    public Type visit(Or n) {
        return null;
    }

    // Exp lhs,rhs;
    public Type visit(LessThan n) {
        n.lhs.accept(this);
        n.rhs.accept(this);

        return null;
    }

    @Override
    public Type visit(Equals n) {
        return null;
    }

    // Exp lhs,rhs;
    public Type visit(Plus n) {
        n.lhs.accept(this);
        n.rhs.accept(this);

        return null;
    }

    @Override
    public Type visit(PlusEquals n) {
        return null;
    }

    // Exp lhs,rhs;
    public Type visit(Minus n) {
        n.lhs.accept(this);
        n.rhs.accept(this);

        return null;
    }

    // Exp lhs,rhs;
    public Type visit(Times n) {
        n.lhs.accept(this);
        n.rhs.accept(this);

        return null;
    }

    // Exp lhs,rhs;
    public Type visit(ArrayLookup n) {
        n.lhs.accept(this);
        n.rhs.accept(this);

        return null;
    }

    // Exp lhs;
    public Type visit(ArrayLength n) {
        n.exp.accept(this);

        return null;
    }

    // Exp lhs;
    // Identifier identifier;
    // ExpList expList;
    public Type visit(Call n) {
        n.exp.accept(this);
        n.identifier.accept(this);

        for (int i = 0; i < n.expList.size(); i++) {
            n.expList.elementAt(i).accept(this);
        }

        return null;
    }

    // int identifier;
    public Type visit(IntegerLiteral n) {
        return null;
    }

    public Type visit(True n) {
        return null;
    }

    public Type visit(False n) {
        return null;
    }

    // String string;
    public Type visit(IdentifierExp n) {
        return null;
    }

    public Type visit(This n) {
        return null;
    }

    // Exp lhs;
    public Type visit(NewArray n) {
        n.exp.accept(this);

        return null;
    }

    // Identifier identifier;
    public Type visit(NewObject n) {
        return null;
    }

    // Exp lhs;
    public Type visit(Not n) {
        n.exp.accept(this);

        return null;
    }

    // String string;
    public Type visit(Identifier n) {
        return null;
    }

}
