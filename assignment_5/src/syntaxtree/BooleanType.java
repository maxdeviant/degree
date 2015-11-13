package syntaxtree;

import visitor.TypeVisitor;
import visitor.Visitor;

public class BooleanType extends Type {

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Type accept(TypeVisitor visitor) {
        return visitor.visit(this);
    }

}
