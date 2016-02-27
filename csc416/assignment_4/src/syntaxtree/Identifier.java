package syntaxtree;

import visitor.Visitable;
import visitor.Visitor;

public class Identifier implements Visitable {

    public String string;

    public Identifier(String string) {
        this.string = string;
    }

    public String toString() {
        return string;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
