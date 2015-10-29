package visitor;

import syntaxtree.*;

public class JavaPrintVisitor implements Visitor {

    // MainClass mainClass;
    // ClassDeclList classDeclList;
    public void visit(Program n) {
        n.mainClass.accept(this);
        for (int i = 0; i < n.classDeclList.size(); i++) {
            System.out.println();
            n.classDeclList.elementAt(i).accept(this);
        }
    }

    // Identifier identifier,identifierTwo;
    // Statement statement;
    public void visit(MainClass n) {
        System.out.print("class ");
        n.identifier.accept(this);
        System.out.println(" {");
        System.out.print("  public static void main (String [] ");
        n.identifierTwo.accept(this);
        System.out.println(") {");
        System.out.print("    ");
        n.statement.accept(this);
        System.out.println("\n  }");
        System.out.println("}");
    }

    // Identifier identifier;
    // VarDeclList varDeclList;
    // MethodDeclList methodDeclList;
    public void visit(ClassDeclSimple n) {
        System.out.print("class ");
        n.identifier.accept(this);
        System.out.println(" { ");
        for (int i = 0; i < n.varDeclList.size(); i++) {
            System.out.print("  ");
            n.varDeclList.elementAt(i).accept(this);
            if (i + 1 < n.varDeclList.size()) {
                System.out.println();
            }
        }
        for (int i = 0; i < n.methodDeclList.size(); i++) {
            System.out.println();
            n.methodDeclList.elementAt(i).accept(this);
        }
        System.out.println();
        System.out.println("}");
    }

    // Identifier identifier;
    // Identifier identifierTwo;
    // VarDeclList varDeclList;
    // MethodDeclList methodDeclList;
    public void visit(ClassDeclExtends n) {
        System.out.print("class ");
        n.identifier.accept(this);
        System.out.println(" extends ");
        n.identifierTwo.accept(this);
        System.out.println(" { ");
        for (int i = 0; i < n.varDeclList.size(); i++) {
            System.out.print("  ");
            n.varDeclList.elementAt(i).accept(this);
            if (i + 1 < n.varDeclList.size()) {
                System.out.println();
            }
        }
        for (int i = 0; i < n.methodDeclList.size(); i++) {
            System.out.println();
            n.methodDeclList.elementAt(i).accept(this);
        }
        System.out.println();
        System.out.println("}");
    }

    // Type type;
    // Identifier identifier;
    public void visit(VarDecl n) {
        n.type.accept(this);
        System.out.print(" ");
        n.identifier.accept(this);
        System.out.print(";");
    }

    // Type type;
    // Identifier identifier;
    // FormalList formalList;
    // VarDeclList varDeclList;
    // StatementList statementList;
    // Exp lhs;
    public void visit(MethodDecl n) {
        System.out.print("  public ");
        n.type.accept(this);
        System.out.print(" ");
        n.identifier.accept(this);
        System.out.print(" (");
        for (int i = 0; i < n.formalList.size(); i++) {
            n.formalList.elementAt(i).accept(this);
            if (i + 1 < n.formalList.size()) {
                System.out.print(", ");
            }
        }
        System.out.println(") { ");
        for (int i = 0; i < n.varDeclList.size(); i++) {
            System.out.print("    ");
            n.varDeclList.elementAt(i).accept(this);
            System.out.println("");
        }
        for (int i = 0; i < n.statementList.size(); i++) {
            System.out.print("    ");
            n.statementList.elementAt(i).accept(this);
            if (i < n.statementList.size()) {
                System.out.println("");
            }
        }
        System.out.print("    return ");
        n.exp.accept(this);
        System.out.println(";");
        System.out.print("  }");
    }

    // Type type;
    // Identifier identifier;
    public void visit(Formal n) {
        n.type.accept(this);
        System.out.print(" ");
        n.identifier.accept(this);
    }

    public void visit(IntArrayType n) {
        System.out.print("int []");
    }

    public void visit(BooleanType n) {
        System.out.print("boolean");
    }

    public void visit(IntegerType n) {
        System.out.print("int");
    }

    // String statement;
    public void visit(IdentifierType n) {
        System.out.print(n.string);
    }

    // StatementList statementList;
    public void visit(Block n) {
        System.out.println("{ ");
        for (int i = 0; i < n.statementList.size(); i++) {
            System.out.print("      ");
            n.statementList.elementAt(i).accept(this);
            System.out.println();
        }
        System.out.print("    } ");
    }

    // Exp lhs;
    // Statement statement,statementTwo;
    public void visit(If n) {
        System.out.print("if (");
        n.exp.accept(this);
        System.out.println(") ");
        System.out.print("    ");
        n.statement.accept(this);
        System.out.println();
        System.out.print("    else ");
        n.statementTwo.accept(this);
    }

    // Exp lhs;
    // Statement statement;
    public void visit(While n) {
        System.out.print("while (");
        n.exp.accept(this);
        System.out.print(") ");
        n.statement.accept(this);
    }


    // Exp lhs;
    public void visit(Print n) {
        System.out.print("System.out.print(");
        for (int i = 0; i < n.expList.size(); i++) {
            n.expList.elementAt(i).accept(this);
            if (i != n.expList.size() - 1)
                System.out.print("+\" \"+");
        }
        System.out.print(")");
    }

    // Exp lhs;
    public void visit(Println n) {
        System.out.print("System.out.println(");
        for (int i = 0; i < n.expList.size(); i++) {
            n.expList.elementAt(i).accept(this);
            if (i != n.expList.size() - 1)
                System.out.print("+\" \"+");
        }
        System.out.print(")");
    }

    // Identifier identifier;
    // Exp lhs;
    public void visit(Assign n) {
        n.identifier.accept(this);
        System.out.print(" = ");
        n.exp.accept(this);
        System.out.print(";");
    }

    // Identifier identifier;
    // Exp lhs,rhs;
    public void visit(ArrayAssign n) {
        n.identifier.accept(this);
        System.out.print("[");
        n.lhs.accept(this);
        System.out.print("] = ");
        n.rhs.accept(this);
        System.out.print(";");
    }

    // Exp lhs,rhs;
    public void visit(And n) {
        System.out.print("(");
        n.lhs.accept(this);
        System.out.print(" && ");
        n.rhs.accept(this);
        System.out.print(")");
    }

    // Exp lhs,rhs;
    public void visit(Or n) {
        System.out.print("(");
        n.lhs.accept(this);
        System.out.print(" || ");
        n.rhs.accept(this);
        System.out.print(")");
    }

    // Exp lhs,rhs;
    public void visit(LessThan n) {
        System.out.print("(");
        n.lhs.accept(this);
        System.out.print(" < ");
        n.rhs.accept(this);
        System.out.print(")");
    }

    // Exp lhs,rhs;
    public void visit(Equals n) {
        System.out.print("(");
        n.lhs.accept(this);
        System.out.print(" == ");
        n.rhs.accept(this);
        System.out.print(")");
    }

    // Exp lhs,rhs;
    public void visit(Plus n) {
        System.out.print("(");
        n.lhs.accept(this);
        System.out.print(" + ");
        n.rhs.accept(this);
        System.out.print(")");
    }

    // Identifier identifier;
    // Exp lhs;
    public void visit(PlusEquals n) {
        n.identifier.accept(this);
        System.out.print(" += ");
        n.exp.accept(this);
    }

    // Exp lhs,rhs;
    public void visit(Minus n) {
        System.out.print("(");
        n.lhs.accept(this);
        System.out.print(" - ");
        n.rhs.accept(this);
        System.out.print(")");
    }

    // Exp lhs,rhs;
    public void visit(Times n) {
        System.out.print("(");
        n.lhs.accept(this);
        System.out.print(" * ");
        n.rhs.accept(this);
        System.out.print(")");
    }

    // Exp lhs,rhs;
    public void visit(ArrayLookup n) {
        n.lhs.accept(this);
        System.out.print("[");
        n.rhs.accept(this);
        System.out.print("]");
    }

    // Exp lhs;
    public void visit(ArrayLength n) {
        n.exp.accept(this);
        System.out.print(".length");
    }

    // Exp lhs;
    // Identifier identifier;
    // ExpList expList;
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

    // int identifier;
    public void visit(IntegerLiteral n) {
        System.out.print(n.integer);
    }

    public void visit(True n) {
        System.out.print("true");
    }

    public void visit(False n) {
        System.out.print("false");
    }

    // String statement;
    public void visit(IdentifierExp n) {
        System.out.print(n.string);
    }

    public void visit(This n) {
        System.out.print("this");
    }

    // Exp lhs;
    public void visit(NewArray n) {
        System.out.print("new int [");
        n.exp.accept(this);
        System.out.print("]");
    }

    // Identifier identifier;
    public void visit(NewObject n) {
        System.out.print("new ");
        System.out.print(n.identifier.string);
        System.out.print("()");
    }

    // Exp lhs;
    public void visit(Not n) {
        System.out.print("!");
        n.exp.accept(this);
    }

    // String statement;
    public void visit(Identifier n) {
        System.out.print(n.string);
    }
}
