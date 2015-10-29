package syntaxtree;

import visitor.Visitor;

public class False extends Exp {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
