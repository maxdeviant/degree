package visitor;

import syntaxtree.*;

public class ASTPrintVisitor implements Visitor {

    // MainClass mainClass;
    // ClassDeclList classDeclList;
    public void visit(Program n) {
        System.out.println("Program(");
        n.mainClass.accept(this);
        System.out.println("ClassDeclList(");
        for (int i = 0; i < n.classDeclList.size(); i++) {
            if (i > 0) System.out.println(", ");
            n.classDeclList.elementAt(i).accept(this);
        }
        System.out.println("))");
    }

    // Identifier identifier,identifierTwo;
    // Statement statement;
    public void visit(MainClass n) {
        System.out.print("MainClass(");
        n.identifier.accept(this);
        System.out.print(", ");
        n.identifierTwo.accept(this);
        System.out.print(", ");
        n.statement.accept(this);
        System.out.println(")");
    }

    // Identifier identifier;
    // VarDeclList varDeclList;
    // MethodDeclList methodDeclList;
    public void visit(ClassDeclSimple n) {
        System.out.print("ClassDeclSimple(");
        n.identifier.accept(this);
        System.out.print(", (");
        for (int i = 0; i < n.varDeclList.size(); i++) {
            n.varDeclList.elementAt(i).accept(this);
            if (i + 1 < n.varDeclList.size())
                System.out.print(", ");
        }
        System.out.println("),");
        System.out.println("(");
        for (int i = 0; i < n.methodDeclList.size(); i++) {
            n.methodDeclList.elementAt(i).accept(this);
            if (i + 1 < n.methodDeclList.size())
                System.out.println(", ");
        }
        System.out.println("))");
    }

    // Identifier identifier;
    // Identifier identifierTwo;
    // VarDeclList varDeclList;
    // MethodDeclList methodDeclList;
    public void visit(ClassDeclExtends n) {
        System.out.print("ClassDeclExtends(");
        n.identifier.accept(this);
        System.out.print(", ");
        n.identifierTwo.accept(this);
        System.out.print(", (");
        for (int i = 0; i < n.varDeclList.size(); i++) {
            n.varDeclList.elementAt(i).accept(this);
            if (i + 1 < n.varDeclList.size())
                System.out.print(", ");
        }
        for (int i = 0; i < n.methodDeclList.size(); i++) {
            System.out.println();
            if (i + 1 < n.methodDeclList.size())
                System.out.println(", ");
        }
        System.out.println();
        System.out.println("))");
    }

    // Type type;
    // Identifier identifier;
    public void visit(VarDecl n) {
        System.out.print("VarDecl(");
        n.type.accept(this);
        System.out.print(", ");
        n.identifier.accept(this);
        System.out.print(")");
    }

    // Type type;
    // Identifier identifier;
    // FormalList formalList;
    // VarDeclList varDeclList;
    // StatementList statementList;
    // Exp lhs;
    public void visit(MethodDecl n) {
        System.out.print("MethodDecl(");
        n.type.accept(this);
        System.out.print(", ");
        n.identifier.accept(this);
        System.out.print(", (");
        for (int i = 0; i < n.formalList.size(); i++) {
            n.formalList.elementAt(i).accept(this);
            if (i + 1 < n.formalList.size())
                System.out.print(", ");
        }
        System.out.println("), (");
        for (int i = 0; i < n.varDeclList.size(); i++) {
            n.varDeclList.elementAt(i).accept(this);
            if (i + 1 < n.varDeclList.size())
                System.out.print(", ");
        }
        System.out.println("), (");
        for (int i = 0; i < n.statementList.size(); i++) {
            n.statementList.elementAt(i).accept(this);
            if (i + 1 < n.statementList.size())
                System.out.println(", ");
        }
        System.out.println("), ");
        n.exp.accept(this);
        System.out.println(")");
    }

    // Type type;
    // Identifier identifier;
    public void visit(Formal n) {
        System.out.print("Formal(");
        n.type.accept(this);
        System.out.print(", ");
        n.identifier.accept(this);
        System.out.print(")");
    }

    public void visit(IntArrayType n) {
        System.out.print("IntArrayType()");
    }

    public void visit(BooleanType n) {
        System.out.print("BooleanType()");
    }

    public void visit(IntegerType n) {
        System.out.print("IntegerType()");
    }

    // String statement;
    public void visit(IdentifierType n) {
        System.out.print("IdentifierType(" + n.string + ")");
    }

    // StatementList statementList;
    public void visit(Block n) {
        System.out.println("Block((");
        for (int i = 0; i < n.statementList.size(); i++) {
            n.statementList.elementAt(i).accept(this);
            if (i + 1 < n.statementList.size())
                System.out.println(",");
        }
        System.out.print("))");
    }

    // Exp lhs;
    // Statement statement,statementTwo;
    public void visit(If n) {
        System.out.print("If(");
        n.exp.accept(this);
        System.out.println(",");
        n.statement.accept(this);
        System.out.println(",");
        n.statementTwo.accept(this);
        System.out.print(")");
    }

    // Exp lhs;
    // Statement statement;
    public void visit(While n) {
        System.out.print("While(");
        n.exp.accept(this);
        System.out.println(",");
        n.statement.accept(this);
        System.out.print(")");
    }

    // ExpList expList;
    public void visit(Print n) {
        System.out.print("Print(");
        for (int i = 0; i < n.expList.size(); i++)
            n.expList.elementAt(i).accept(this);
        System.out.print(")");
    }

    // ExpList expList;
    public void visit(Println n) {
        System.out.print("Println(");
        for (int i = 0; i < n.expList.size(); i++)
            n.expList.elementAt(i).accept(this);
        System.out.print(")");
    }

    // Identifier identifier;
    // Exp lhs;
    public void visit(Assign n) {
        System.out.print("Assign(");
        n.identifier.accept(this);
        System.out.print(", ");
        n.exp.accept(this);
        System.out.print(")");
    }

    // Identifier identifier;
    // Exp lhs,rhs;
    public void visit(ArrayAssign n) {
        System.out.print("ArrayAssign(");
        n.identifier.accept(this);
        System.out.print(", ");
        n.lhs.accept(this);
        System.out.print(", ");
        n.rhs.accept(this);
        System.out.print(")");
    }

    // Exp lhs,rhs;
    public void visit(And n) {
        System.out.print("And(");
        n.lhs.accept(this);
        System.out.print(", ");
        n.rhs.accept(this);
        System.out.print(")");
    }

    // Exp lhs,rhs;
    public void visit(Or n) {
        System.out.print("Or(");
        n.lhs.accept(this);
        System.out.print(", ");
        n.rhs.accept(this);
        System.out.print(")");
    }

    // Exp lhs,rhs;
    public void visit(LessThan n) {
        System.out.print("LessThan(");
        n.lhs.accept(this);
        System.out.print(", ");
        n.rhs.accept(this);
        System.out.print(")");
    }

    // Exp lhs,rhs;
    public void visit(Equals n) {
        System.out.print("Equals(");
        n.lhs.accept(this);
        System.out.print(", ");
        n.rhs.accept(this);
        System.out.print(")");
    }

    // Exp lhs,rhs;
    public void visit(Plus n) {
        System.out.print("Plus(");
        n.lhs.accept(this);
        System.out.print(", ");
        n.rhs.accept(this);
        System.out.print(")");
    }

    // Identifier identifier;
    // Exp lhs;
    public void visit(PlusEquals n) {
        System.out.print("PlusEquals(");
        n.identifier.accept(this);
        System.out.print(", ");
        n.exp.accept(this);
        System.out.print(")");
    }

    // Exp lhs,rhs;
    public void visit(Minus n) {
        System.out.print("Minus(");
        n.lhs.accept(this);
        System.out.print(", ");
        n.rhs.accept(this);
        System.out.print(")");
    }

    // Exp lhs,rhs;
    public void visit(Times n) {
        System.out.print("Times(");
        n.lhs.accept(this);
        System.out.print(", ");
        n.rhs.accept(this);
        System.out.print(")");
    }

    // Exp lhs,rhs;
    public void visit(ArrayLookup n) {
        System.out.print("ArrayLookup(");
        n.lhs.accept(this);
        System.out.print(", ");
        n.rhs.accept(this);
        System.out.print(")");
    }

    // Exp lhs;
    public void visit(ArrayLength n) {
        System.out.print("ArrayLength(");
        n.exp.accept(this);
        System.out.print(")");
    }

    // Exp lhs;
    // Identifier identifier;
    // ExpList expList;
    public void visit(Call n) {
        System.out.print("Call(");
        n.exp.accept(this);
        System.out.print(", ");
        n.identifier.accept(this);
        System.out.print(", (");
        for (int i = 0; i < n.expList.size(); i++) {
            n.expList.elementAt(i).accept(this);
            if (i + 1 < n.expList.size()) {
                System.out.print(", ");
            }
        }
        System.out.print("))");
    }

    // int identifier;
    public void visit(IntegerLiteral n) {
        System.out.print("IntegerLiteral(" + n.integer + ")");
    }

    public void visit(True n) {
        System.out.print("True()");
    }

    public void visit(False n) {
        System.out.print("False()");
    }

    // String statement;
    public void visit(IdentifierExp n) {
        System.out.print("IdentifierExp(" + n.string + ")");
    }

    public void visit(This n) {
        System.out.print("This()");
    }

    // Exp lhs;
    public void visit(NewArray n) {
        System.out.print("NewArray(");
        n.exp.accept(this);
        System.out.print(")");
    }

    // Identifier identifier;
    public void visit(NewObject n) {
        System.out.print("NewObject(");
        System.out.print(n.identifier.string);
        System.out.print(")");
    }

    // Exp lhs;
    public void visit(Not n) {
        System.out.print("Not(");
        n.exp.accept(this);
        System.out.print(")");
    }

    // String statement;
    public void visit(Identifier n) {
        System.out.print("Identifier(" + n.string + ")");
    }
}
