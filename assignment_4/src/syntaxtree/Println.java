package syntaxtree;

import visitor.Visitor;

public class Println extends Statement {
    public ExpList el;

    public Println(ExpList ael) {
        el = ael;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

}
