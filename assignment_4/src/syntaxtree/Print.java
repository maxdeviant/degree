package syntaxtree;

import visitor.Visitor;

public class Print extends Statement {
    public ExpList el;

    public Print(ExpList ael) {
        el = ael;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

}
