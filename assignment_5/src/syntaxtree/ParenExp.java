package syntaxtree;

import visitor.TypeVisitor;
import visitor.Visitor;


public class ParenExp extends Exp {

    public Exp e1;

    public ParenExp(Exp e1) {
        this.e1 = e1;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }

}
