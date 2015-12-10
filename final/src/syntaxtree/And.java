package syntaxtree;

import visitor.TypeVisitor;
import visitor.Visitor;

public class And extends Exp {

    public Exp lhs;
    public Exp rhs;

    public And(Exp lhs, Exp rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
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
