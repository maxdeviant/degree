package syntaxtree;

import visitor.TypeVisitor;
import visitor.Visitable;
import visitor.Visitor;

public class Formal implements Visitable {

    public Type type;
    public Identifier identifier;

    public Formal(Type type, Identifier identifier) {
        this.type = type;
        this.identifier = identifier;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Type accept(TypeVisitor visitor) {
        return visitor.visit(this);
    }

}
