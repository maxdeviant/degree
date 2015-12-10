package syntaxtree;

import visitor.TypeVisitor;
import visitor.Visitor;

public class While extends Statement {

    public Exp exp;
    public Statement statement;

    public While(Exp exp, Statement statement) {
        this.exp = exp;
        this.statement = statement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Type accept(TypeVisitor visitor) {
        return visitor.visit(this);
    }

}

