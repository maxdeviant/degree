package syntaxtree;

import visitor.Visitor;

public class NewObject extends Exp {

    public Identifier identifier;

    public NewObject(Identifier identifier) {
        this.identifier = identifier;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
