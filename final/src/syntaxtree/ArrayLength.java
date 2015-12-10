package syntaxtree;

import visitor.TypeVisitor;
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

    @Override
    public Type accept(TypeVisitor visitor) {
        return visitor.visit(this);
    }

}
