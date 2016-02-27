package syntaxtree;

import visitor.TypeVisitor;
import visitor.Visitor;

public class IntegerLiteral extends Exp {

    public int integer;

    public IntegerLiteral(int integer) {
        this.integer = integer;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Type accept(TypeVisitor visitor) {
        return visitor.visit(this);
    }

}
