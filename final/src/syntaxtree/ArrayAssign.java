package syntaxtree;

import visitor.TypeVisitor;
import visitor.Visitor;

public class ArrayAssign extends Statement {

    public Identifier identifier;
    public Exp lhs;
    public Exp rhs;

    public ArrayAssign(Identifier identifier, Exp lhs, Exp rhs) {
        this.identifier = identifier;
        this.lhs = lhs;
        this.rhs = rhs;
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

