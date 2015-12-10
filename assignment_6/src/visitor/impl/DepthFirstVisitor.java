package visitor.impl;

import syntaxtree.*;
import visitor.Visitor;

public class DepthFirstVisitor implements Visitor {

    // MainClass m;
    // ClassDeclList cl;
    @Override
    public void visit(Program n) {
        n.m.accept(this);
        for (int i = 0; i < n.cl.size(); i++) {
            n.cl.elementAt(i).accept(this);
        }
    }

    // Identifier i1,i2;
    // Statement s;
    @Override
    public void visit(MainClass n) {
        n.i1.accept(this);
        n.i2.accept(this);
        n.s.accept(this);
    }

    // Identifier identifier;
    // VarDeclList vl;
    // MethodDeclList ml;
    @Override
    public void visit(ClassDeclSimple n) {
        n.i.accept(this);
        for (int i = 0; i < n.vl.size(); i++) {
            n.vl.elementAt(i).accept(this);
        }
        for (int i = 0; i < n.ml.size(); i++) {
            n.ml.elementAt(i).accept(this);
        }
    }

    // Type t;
    // Identifier identifier;
    @Override
    public void visit(VarDecl n) {
        n.t.accept(this);
        n.i.accept(this);
    }

    // Type t;
    // Identifier identifier;
    // FormalList fl;
    // VarDeclList vl;
    // StatementList statementList;
    // Exp exp;
    @Override
    public void visit(MethodDecl n) {
        n.t.accept(this);
        n.i.accept(this);
        for (int i = 0; i < n.fl.size(); i++) {
            n.fl.elementAt(i).accept(this);
        }
        for (int i = 0; i < n.vl.size(); i++) {
            n.vl.elementAt(i).accept(this);
        }
        for (int i = 0; i < n.sl.size(); i++) {
            n.sl.elementAt(i).accept(this);
        }
        n.e.accept(this);
    }

    // Type t;
    // Identifier identifier;
    @Override
    public void visit(Formal n) {
        n.t.accept(this);
        n.i.accept(this);
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

    // String s;
    @Override
    public void visit(IdentifierType n) {
    }

    // StatementList statementList;
    @Override
    public void visit(Block n) {
        for (int i = 0; i < n.statementList.size(); i++) {
            n.statementList.elementAt(i).accept(this);
        }
    }

    // Exp exp;
    // Statement s1,s2;
    @Override
    public void visit(If n) {
        n.e.accept(this);
        n.s1.accept(this);
        n.s2.accept(this);
    }

    // Exp exp;
    // Statement s;
    @Override
    public void visit(While n) {
        n.e.accept(this);
        n.s.accept(this);
    }

    @Override
    public void visit(Print n) {
        for (int i = 0; i < n.el.size(); i++) {
            n.el.elementAt(i).accept(this);
        }
    }

    @Override
    public void visit(Println n) {
        for (int i = 0; i < n.el.size(); i++) {
            n.el.elementAt(i).accept(this);
        }
    }

    // Identifier identifier;
    // Exp exp;
    @Override
    public void visit(Assign n) {
        n.identifier.accept(this);
        n.exp.accept(this);
    }

    // Identifier identifier;
    // Exp lhs,rhs;
    @Override
    public void visit(ArrayAssign n) {
        n.identifier.accept(this);
        n.lhs.accept(this);
        n.rhs.accept(this);
    }

    // Exp lhs,rhs;
    @Override
    public void visit(And n) {
        n.lhs.accept(this);
        n.rhs.accept(this);
    }

    @Override
    public void visit(Or n) {
        n.e1.accept(this);
        n.e2.accept(this);
    }

    // Exp lhs,rhs;
    @Override
    public void visit(LessThan n) {
        n.e1.accept(this);
        n.e2.accept(this);
    }

    @Override
    public void visit(Equals n) {
        n.e1.accept(this);
        n.e2.accept(this);
    }

    // Exp lhs,rhs;
    @Override
    public void visit(Plus n) {
        n.e1.accept(this);
        n.e2.accept(this);
    }

    @Override
    public void visit(PlusEquals n) {
        n.i.accept(this);
        n.e.accept(this);
    }

    @Override
    public void visit(MinusEquals n) {
        n.i.accept(this);
        n.e.accept(this);
    }

    // Exp lhs,rhs;
    @Override
    public void visit(Minus n) {
        n.e1.accept(this);
        n.e2.accept(this);
    }

    // Exp lhs,rhs;
    @Override
    public void visit(Times n) {
        n.e1.accept(this);
        n.e2.accept(this);
    }

    @Override
    public void visit(Slice n) {
        n.e1.accept(this);
        if (n.e2 != null) {
            n.e2.accept(this);
        }
        if (n.e3 != null) {
            n.e3.accept(this);
        }
    }

    // Exp lhs,rhs;
    @Override
    public void visit(ArrayLookup n) {
        n.lhs.accept(this);
        n.rhs.accept(this);
    }

    // Exp exp;
    @Override
    public void visit(ArrayLength n) {
        n.exp.accept(this);
    }

    // Exp exp;
    // Identifier identifier;
    // ExpList el;
    @Override
    public void visit(Call n) {
        n.e.accept(this);
        n.i.accept(this);
        for (int i = 0; i < n.el.size(); i++) {
            n.el.elementAt(i).accept(this);
        }
    }

    // int identifier;
    @Override
    public void visit(IntegerLiteral n) {
    }

    @Override
    public void visit(True n) {
    }

    @Override
    public void visit(False n) {
    }

    // String s;
    @Override
    public void visit(IdentifierExp n) {
    }

    @Override
    public void visit(This n) {
    }

    // Exp exp;
    @Override
    public void visit(NewArray n) {
        n.e.accept(this);
    }

    // Identifier identifier;
    @Override
    public void visit(NewObject n) {
    }

    // Exp exp;
    @Override
    public void visit(Not n) {
        n.e.accept(this);
    }

    // String s;
    @Override
    public void visit(Identifier n) {
    }

    @Override
    public void visit(ParenExp n) {
        n.e1.accept(this);
    }
}
