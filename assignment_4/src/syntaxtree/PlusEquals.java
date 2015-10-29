package syntaxtree;

import visitor.Visitor;

public class PlusEquals extends Statement {

    public Identifier identifier;
    public Exp exp;

    public PlusEquals(Identifier identifier, Exp exp) {
        this.identifier = identifier;
        this.exp = exp;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}

