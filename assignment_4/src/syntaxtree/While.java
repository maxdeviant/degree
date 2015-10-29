package syntaxtree;

import visitor.Visitor;

public class While extends Statement {

    public Exp exp;
    public Statement statement;

    public While(Exp exp, Statement statement) {
        this.exp = exp;
        this.statement = statement;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}

