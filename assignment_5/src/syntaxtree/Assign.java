package syntaxtree;

import visitor.TypeVisitor;
import visitor.Visitor;

public class Assign extends Statement {

    public Identifier identifier;
    public Exp exp;

    public Assign(Identifier identifier, Exp exp) {
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

