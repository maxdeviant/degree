package syntaxtree;

import visitor.Visitable;
import visitor.Visitor;

public class Formal implements Visitable {

    public Type type;
    public Identifier identifier;

    public Formal(Type type, Identifier identifier) {
        this.type = type;
        this.identifier = identifier;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
