package syntaxtree;

import visitor.Visitor;

public class IntegerType extends Type {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
