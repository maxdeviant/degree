package syntaxtree;

import visitor.Visitor;

public class Call extends Exp {

    public Exp exp;
    public Identifier identifier;
    public ExpList expList;

    public Call(Exp exp, Identifier identifier, ExpList expList) {
        this.exp = exp;
        this.identifier = identifier;
        this.expList = expList;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
