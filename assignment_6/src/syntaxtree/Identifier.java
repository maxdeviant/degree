package syntaxtree;

import visitor.TypeVisitor;
import visitor.Visitable;
import visitor.Visitor;

public class Identifier implements Visitable {

    public String string;

    public Identifier(String string) {
        this.string = string;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Type accept(TypeVisitor visitor) {
        return visitor.visit(this);
    }

    public String toString() {
        return string;
    }

}
