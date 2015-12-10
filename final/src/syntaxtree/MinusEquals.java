package syntaxtree;

import visitor.TypeVisitor;
import visitor.Visitor;


public class MinusEquals extends Statement {
    public Identifier i;
    public Exp e;

    public MinusEquals(Identifier ai, Exp ae) {
        i = ai;
        e = ae;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Type accept(TypeVisitor visitor) {
        return visitor.visit(this);
    }

}

