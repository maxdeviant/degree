package syntaxtree;

import visitor.TypeVisitor;
import visitor.Visitor;

public class MinusEquals extends Statement {

    public Identifier identifier;
    public Exp exp;

    public MinusEquals(Identifier identifier, Exp exp) {
        this.identifier = identifier;
        this.exp = exp;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public Type accept(TypeVisitor visitor) {
        return visitor.visit(this);
    }

}

