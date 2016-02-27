package syntaxtree;

import visitor.Visitor;

public class IdentifierType extends Type {

    public String string;

    public IdentifierType(String string) {
        this.string = string;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
