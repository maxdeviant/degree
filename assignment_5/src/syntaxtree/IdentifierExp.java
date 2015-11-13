package syntaxtree;

import visitor.TypeVisitor;
import visitor.Visitor;

public class IdentifierExp extends Exp {

    public String string;

    public IdentifierExp(String string) {
        this.string = string;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Type accept(TypeVisitor visitor) {
        return visitor.visit(this);
    }

}
