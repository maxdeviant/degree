package syntaxtree;

import visitor.TypeVisitor;
import visitor.Visitor;

public class VarDecl {

    public Type type;
    public Identifier identifier;

    public VarDecl(Type type, Identifier identifier) {
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
