package syntaxtree;

import visitor.Visitor;

public class IntArrayType extends Type {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
