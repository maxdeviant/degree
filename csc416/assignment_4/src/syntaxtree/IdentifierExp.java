package syntaxtree;

import visitor.Visitor;

public class IdentifierExp extends Exp {

    public String string;

    public IdentifierExp(String string) {
        this.string = string;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
