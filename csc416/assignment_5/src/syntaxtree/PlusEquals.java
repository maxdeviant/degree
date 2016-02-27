package syntaxtree;

import visitor.TypeVisitor;
import visitor.Visitor;

public class PlusEquals extends Statement {

    public Identifier identifier;
    public Exp exp;

    public PlusEquals(Identifier identifier, Exp exp) {
        this.identifier = identifier;
        this.exp = exp;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Type accept(TypeVisitor visitor) {
        return visitor.visit(this);
    }

}
