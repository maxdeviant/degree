package syntaxtree;

import visitor.Visitor;

public class Print extends Statement {

    public ExpList expList;

    public Print(ExpList expList) {
        this.expList = expList;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
