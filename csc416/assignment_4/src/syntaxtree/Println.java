package syntaxtree;

import visitor.Visitor;

public class Println extends Statement {

    public ExpList expList;

    public Println(ExpList expList) {
        this.expList = expList;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
