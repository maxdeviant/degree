package syntaxtree;

import visitor.TypeVisitor;
import visitor.Visitor;


public class Slice extends Exp {

    public Exp e1;
    public Exp e2;
    public Exp e3;

    public Slice(Exp e1, Exp e2, Exp e3) {
        this.e1 = e1;
        this.e2 = e2;
        this.e3 = e3;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }

}
