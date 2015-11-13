package syntaxtree;

import visitor.TypeVisitor;
import visitor.Visitor;

public class If extends Statement {

    public Exp exp;
    public Statement statement;
    public Statement statementTwo;

    public If(Exp ae, Statement statement, Statement statementTwo) {
        exp = ae;
        this.statement = statement;
        this.statementTwo = statementTwo;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Type accept(TypeVisitor visitor) {
        return visitor.visit(this);
    }

}

