package syntaxtree;

import visitor.TypeVisitor;
import visitor.Visitor;

public class IdentifierType extends Type {

    public String string;

    public IdentifierType(String string) {
        this.string = string;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Type accept(TypeVisitor visitor) {
        return visitor.visit(this);
    }

}
