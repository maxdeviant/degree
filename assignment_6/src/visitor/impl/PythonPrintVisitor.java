package visitor.impl;


import syntaxtree.*;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class PythonPrintVisitor implements Visitor {

    private List<Identifier> instanceVars;
    private List<Identifier> localVars;
    private int depth;  // indentation depth

    public PythonPrintVisitor() {
        instanceVars = new ArrayList<>();
        localVars = new ArrayList<>();
        depth = 0;
    }

    private void printIndent(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("\t");
        }
    }

    @Override
    public void visit(Program n) {
        for (int i = 0; i < n.cl.size(); i++) {
            n.cl.elementAt(i).accept(this);
            System.out.println();
        }
        n.m.accept(this);
    }

    @Override
    public void visit(MainClass n) {
        System.out.println("if __name__ == '__main__':");
        depth++;
        n.s.accept(this);
        depth--;
    }

    @Override
    public void visit(ClassDeclSimple n) {
        System.out.print("class ");
        n.i.accept(this);
        System.out.println(":");
        depth++;

        instanceVars = new ArrayList<>();
        for (int i = 0; i < n.vl.size(); i++) {
            instanceVars.add(n.vl.elementAt(i).i);
        }

        for (int i = 0; i < n.ml.size(); i++) {
            n.ml.elementAt(i).accept(this);
            if (i < n.ml.size() - 1) {
                System.out.println();
            }
        }

        depth--;
        System.out.println();
    }

    @Override
    public void visit(VarDecl n) {
        throw new UnsupportedOperationException("No var declarations needed for python");
    }

    @Override
    public void visit(MethodDecl n) {
        printIndent(depth);
        System.out.print("def ");
        n.i.accept(this);
        System.out.print("(self");
        for (int i = 0; i < n.fl.size(); i++) {
            System.out.print(", ");
            n.fl.elementAt(i).accept(this);
        }
        System.out.print("):\n");
        depth++;

        localVars = new ArrayList<>();
        for (int i = 0; i < n.vl.size(); i++) {
            localVars.add(n.vl.elementAt(i).i);
        }

        for (int i = 0; i < n.sl.size(); i++) {
            n.sl.elementAt(i).accept(this);
            System.out.println();
        }

        printIndent(depth);
        System.out.print("return ");
        n.e.accept(this);
        System.out.println();
        depth--;
    }

    @Override
    public void visit(Formal n) {
        n.i.accept(this);
    }

    @Override
    public void visit(IntArrayType n) {
        throw new UnsupportedOperationException("No type declarations needed for python");
    }

    @Override
    public void visit(BooleanType n) {
        throw new UnsupportedOperationException("No type declarations needed for python");
    }

    @Override
    public void visit(IntegerType n) {
        throw new UnsupportedOperationException("No type declarations needed for python");
    }

    @Override
    public void visit(IdentifierType n) {
        throw new UnsupportedOperationException("No type declarations needed for python");
    }

    @Override
    public void visit(Block n) {
        for (int i = 0; i < n.statementList.size(); i++) {
            n.statementList.elementAt(i).accept(this);
            if (i < n.statementList.size() - 1) {
                System.out.println();
            }
        }
    }

    @Override
    public void visit(If n) {
        printIndent(depth);
        System.out.print("if ");
        n.e.accept(this);
        System.out.println(":");

        depth++;
        n.s1.accept(this);
        System.out.println();
        depth--;

        printIndent(depth);
        System.out.println("else:");

        depth++;
        n.s2.accept(this);
        depth--;
    }

    @Override
    public void visit(While n) {
        printIndent(depth);
        System.out.print("while ");
        n.e.accept(this);
        System.out.print(":\n");

        depth++;
        n.s.accept(this);
        depth--;
    }

    @Override
    public void visit(Print n) {
        printIndent(depth);
        System.out.print("print(");
        for (int i = 0; i < n.el.size(); i++) {
            n.el.elementAt(i).accept(this);
            System.out.print(", ");
        }
        if (n.el.size() > 1) {
            System.out.print("sep=\"\", ");
        }
        System.out.print("end=\"\")");
    }

    @Override
    public void visit(Println n) {
        printIndent(depth);
        System.out.print("print(");
        for (int i = 0; i < n.el.size(); i++) {
            n.el.elementAt(i).accept(this);
            if (i < n.el.size() - 1) {
                System.out.print(", ");
            }
        }
        if (n.el.size() > 1) {
            System.out.print("sep=\"\"");
        }
        System.out.print(")");
    }

    @Override
    public void visit(Assign n) {
        printIndent(depth);
        n.identifier.accept(this);
        System.out.print(" = ");
        n.exp.accept(this);
    }

    @Override
    public void visit(ArrayAssign n) {
        printIndent(depth);
        n.identifier.accept(this);
        System.out.print("[");
        n.lhs.accept(this);
        System.out.print("] = ");
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
        n.e1.accept(this);
        System.out.print(" or ");
        n.e2.accept(this);
    }

    @Override
    public void visit(LessThan n) {
        n.e1.accept(this);
        System.out.print(" < ");
        n.e2.accept(this);
    }

    @Override
    public void visit(ParenExp n) {
        System.out.print("(");
        n.e1.accept(this);
        System.out.print(")");
    }

    @Override
    public void visit(Equals n) {
        n.e1.accept(this);
        System.out.print(" == ");
        n.e2.accept(this);
    }

    @Override
    public void visit(Plus n) {
        n.e1.accept(this);
        System.out.print(" + ");
        n.e2.accept(this);
    }

    @Override
    public void visit(PlusEquals n) {
        printIndent(depth);
        n.i.accept(this);
        System.out.print(" += ");
        n.e.accept(this);
    }

    @Override
    public void visit(MinusEquals n) {
        printIndent(depth);
        n.i.accept(this);
        System.out.print(" -= ");
        n.e.accept(this);
    }

    @Override
    public void visit(Minus n) {
        n.e1.accept(this);
        System.out.print(" - ");
        n.e2.accept(this);
    }

    @Override
    public void visit(Times n) {
        n.e1.accept(this);
        System.out.print(" * ");
        n.e2.accept(this);
    }

    @Override
    public void visit(Slice n) {
        n.e1.accept(this);
        System.out.print("[");
        if (n.e2 != null) {
            n.e2.accept(this);
        }
        System.out.print(":");
        if (n.e3 != null) {
            n.e3.accept(this);
        }
        System.out.print("]");
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
        n.e.accept(this);
        System.out.print(".");
        n.i.accept(this);
        System.out.print("(");
        for (int i = 0; i < n.el.size(); i++) {
            n.el.elementAt(i).accept(this);
            if (i + 1 < n.el.size()) {
                System.out.print(", ");
            }
        }
        System.out.print(")");
    }

    @Override
    public void visit(IntegerLiteral n) {
        System.out.print(n.i);
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
        for (Identifier i : localVars) {
            if (i.s.equals(n.s)) {
                System.out.print(n.s);
                return;
            }
        }

        for (Identifier i : instanceVars) {
            if (i.s.equals(n.s)) {
                System.out.print("self." + n.s);
                return;
            }
        }
        System.out.print(n.s);
    }

    @Override
    public void visit(This n) {
        System.out.print("self");
    }

    @Override
    public void visit(NewArray n) {
        System.out.print("[None]*");
        n.e.accept(this);
    }

    @Override
    public void visit(NewObject n) {
        System.out.print(n.i.s);
        System.out.print("()");
    }

    @Override
    public void visit(Not n) {
        System.out.print(" not ");
        n.e.accept(this);
    }

    @Override
    public void visit(Identifier n) {
        for (Identifier i : localVars) {
            if (i.s.equals(n.s)) {
                System.out.print(n.s);
                return;
            }
        }

        for (Identifier i : instanceVars) {
            if (i.s.equals(n.s)) {
                System.out.print("self." + n.s);
                return;
            }
        }
        System.out.print(n.s);
    }
}
