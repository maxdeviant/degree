package syntaxtree;

import visitor.Visitor;

public class This extends Exp {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }


}
