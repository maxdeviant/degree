package syntaxtree;

import visitor.Visitor;

public class ArrayLength extends Exp {

    public Exp exp;

    public ArrayLength(Exp exp) {
        this.exp = exp;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
