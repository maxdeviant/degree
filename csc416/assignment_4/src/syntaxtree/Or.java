package syntaxtree;

import visitor.Visitor;

public class Or extends Exp {

    public Exp lhs;
    public Exp rhs;

    public Or(Exp lhs, Exp rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
