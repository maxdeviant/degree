package syntaxtree;

import visitor.TypeVisitor;
import visitor.Visitor;

public class Block extends Statement {

    public StatementList statementList;

    public Block(StatementList statementList) {
        this.statementList = statementList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Type accept(TypeVisitor visitor) {
        return visitor.visit(this);
    }

}

