package syntaxtree;

import visitor.TypeVisitor;
import visitor.Visitor;

public class NewObject extends Exp {

    public Identifier identifier;

    public NewObject(Identifier identifier) {
        this.identifier = identifier;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Type accept(TypeVisitor visitor) {
        return visitor.visit(this);
    }

}
