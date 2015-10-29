package syntaxtree;

import visitor.Visitor;

public class IntegerLiteral extends Exp {
    public int i;

    public IntegerLiteral(int ai) {
        i = ai;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

}
