package syntaxtree;

import visitor.Visitor;

public class IntegerLiteral extends Exp {

    public int integer;

    public IntegerLiteral(int integer) {
        this.integer = integer;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
