package syntaxtree;

import visitor.Visitor;

public class If extends Statement {

    public Exp exp;
    public Statement statement;
    public Statement statementTwo;

    public If(Exp exp, Statement statement, Statement statementTwo) {
        this.exp = exp;
        this.statement = statement;
        this.statementTwo = statementTwo;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}

