package syntaxtree;

import visitor.TypeVisitor;
import visitor.Visitor;

public class Print extends Statement {

    public ExpList expList;

    public Print(ExpList expList) {
        this.expList = expList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Type accept(TypeVisitor visitor) {
        return visitor.visit(this);
    }

}
