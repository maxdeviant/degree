package syntaxtree;

import visitor.Visitor;

public class NewArray extends Exp {

    public Exp exp;

    public NewArray(Exp exp) {
        this.exp = exp;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
