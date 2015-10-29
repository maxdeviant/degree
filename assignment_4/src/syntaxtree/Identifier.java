package syntaxtree;

import visitor.Visitor;

public class Identifier {
    public String s;

    public Identifier(String as) {
        s = as;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public String toString() {
        return s;
    }
}
