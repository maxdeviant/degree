package syntaxtree;

import visitor.TypeVisitor;
import visitor.Visitor;

public class IntegerType extends Type {

    public static final String name = "integer";

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Type accept(TypeVisitor visitor) {
        return visitor.visit(this);
    }

}
