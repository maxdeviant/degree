package syntaxtree;

import visitor.TypeVisitor;
import visitor.Visitor;

public class Println extends Statement {

    public ExpList expList;

    public Println(ExpList expList) {
        this.expList = expList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Type accept(TypeVisitor visitor) {
        return visitor.visit(this);
    }

}
