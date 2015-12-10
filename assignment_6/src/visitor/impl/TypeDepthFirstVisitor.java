package visitor.impl;

import syntaxtree.*;
import visitor.TypeVisitor;

public class TypeDepthFirstVisitor implements TypeVisitor {

    @Override
    public Type visit(Println n) {
        for (int i = 0; i < n.el.size(); i++) {
            n.el.elementAt(i).accept(this);
        }
        return null;
    }

    @Override
    public Type visit(Or n) {
        n.e1.accept(this);
        n.e2.accept(this);
        return null;
    }

    @Override
    public Type visit(Equals n) {
        n.e1.accept(this);
        n.e2.accept(this);
        return null;
    }

    @Override
    public Type visit(PlusEquals n) {
        n.i.accept(this);
        n.e.accept(this);
        return null;
    }

    @Override
    public Type visit(MinusEquals n) {
        n.i.accept(this);
        n.e.accept(this);
        return null;
    }

    @Override
    public Type visit(Slice n) {
        n.e1.accept(this);
        if (n.e2 != null) {
            n.e2.accept(this);
        }
        if (n.e3 != null) {
            n.e3.accept(this);
        }
        return null;
    }

    @Override
    public Type visit(ParenExp n) {
        n.e1.accept(this);
        return null;
    }

    // MainClass m;
    // ClassDeclList cl;
    @Override
    public Type visit(Program n) {
        n.m.accept(this);
        for (int i = 0; i < n.cl.size(); i++) {
            n.cl.elementAt(i).accept(this);
        }
        return null;
    }

    // Identifier i1,i2;
    // Statement s;
    @Override
    public Type visit(MainClass n) {
        n.i1.accept(this);
        n.i2.accept(this);
        n.s.accept(this);
        return null;
    }

    // Identifier identifier;
    // VarDeclList vl;
    // MethodDeclList ml;
    @Override
    public Type visit(ClassDeclSimple n) {
        n.i.accept(this);
        for (int i = 0; i < n.vl.size(); i++) {
            n.vl.elementAt(i).accept(this);
        }
        for (int i = 0; i < n.ml.size(); i++) {
            n.ml.elementAt(i).accept(this);
        }
        return null;
    }

    // Type t;
    // Identifier identifier;
    @Override
    public Type visit(VarDecl n) {
        n.t.accept(this);
        n.i.accept(this);
        return null;
    }

    // Type t;
    // Identifier identifier;
    // FormalList fl;
    // VarDeclList vl;
    // StatementList statementList;
    // Exp exp;
    @Override
    public Type visit(MethodDecl n) {
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
        return null;
    }

    // Type t;
    // Identifier identifier;
    @Override
    public Type visit(Formal n) {
        n.t.accept(this);
        n.i.accept(this);
        return null;
    }

    @Override
    public Type visit(IntArrayType n) {
        return null;
    }

    @Override
    public Type visit(BooleanType n) {
        return null;
    }

    @Override
    public Type visit(IntegerType n) {
        return null;
    }

    // String s;
    @Override
    public Type visit(IdentifierType n) {
        return null;
    }

    // StatementList statementList;
    @Override
    public Type visit(Block n) {
        for (int i = 0; i < n.statementList.size(); i++) {
            n.statementList.elementAt(i).accept(this);
        }
        return null;
    }

    // Exp exp;
    // Statement s1,s2;
    @Override
    public Type visit(If n) {
        n.e.accept(this);
        n.s1.accept(this);
        n.s2.accept(this);
        return null;
    }

    // Exp exp;
    // Statement s;
    @Override
    public Type visit(While n) {
        n.e.accept(this);
        n.s.accept(this);
        return null;
    }

    // Exp exp;
    @Override
    public Type visit(Print n) {
        for (int i = 0; i < n.el.size(); i++) {
            n.el.elementAt(i).accept(this);
        }
        return null;
    }

    // Identifier identifier;
    // Exp exp;
    @Override
    public Type visit(Assign n) {
        n.identifier.accept(this);
        n.exp.accept(this);
        return null;
    }

    // Identifier identifier;
    // Exp lhs,rhs;
    @Override
    public Type visit(ArrayAssign n) {
        n.identifier.accept(this);
        n.lhs.accept(this);
        n.rhs.accept(this);
        return null;
    }

    // Exp lhs,rhs;
    @Override
    public Type visit(And n) {
        n.lhs.accept(this);
        n.rhs.accept(this);
        return null;
    }

    // Exp lhs,rhs;
    @Override
    public Type visit(LessThan n) {
        n.e1.accept(this);
        n.e2.accept(this);
        return null;
    }

    // Exp lhs,rhs;
    @Override
    public Type visit(Plus n) {
        n.e1.accept(this);
        n.e2.accept(this);
        return null;
    }

    // Exp lhs,rhs;
    @Override
    public Type visit(Minus n) {
        n.e1.accept(this);
        n.e2.accept(this);
        return null;
    }

    // Exp lhs,rhs;
    @Override
    public Type visit(Times n) {
        n.e1.accept(this);
        n.e2.accept(this);
        return null;
    }

    // Exp lhs,rhs;
    @Override
    public Type visit(ArrayLookup n) {
        n.lhs.accept(this);
        n.rhs.accept(this);
        return null;
    }

    // Exp exp;
    @Override
    public Type visit(ArrayLength n) {
        n.exp.accept(this);
        return null;
    }

    // Exp exp;
    // Identifier identifier;
    // ExpList el;
    @Override
    public Type visit(Call n) {
        n.e.accept(this);
        n.i.accept(this);
        for (int i = 0; i < n.el.size(); i++) {
            n.el.elementAt(i).accept(this);
        }
        return null;
    }

    // int identifier;
    @Override
    public Type visit(IntegerLiteral n) {
        return null;
    }

    @Override
    public Type visit(True n) {
        return null;
    }

    @Override
    public Type visit(False n) {
        return null;
    }

    // String s;
    @Override
    public Type visit(IdentifierExp n) {
        return null;
    }

    @Override
    public Type visit(This n) {
        return null;
    }

    // Exp exp;
    @Override
    public Type visit(NewArray n) {
        n.e.accept(this);
        return null;
    }

    // Identifier identifier;
    @Override
    public Type visit(NewObject n) {
        return null;
    }

    // Exp exp;
    @Override
    public Type visit(Not n) {
        n.e.accept(this);
        return null;
    }

    // String s;
    @Override
    public Type visit(Identifier n) {
        return null;
    }
}
