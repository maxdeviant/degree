package syntaxtree;

import visitor.Visitable;
import visitor.Visitor;

public class VarDecl implements Visitable {

    public Type type;
    public Identifier identifier;

    public VarDecl(Type type, Identifier identifier) {
        this.type = type;
        this.identifier = identifier;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
