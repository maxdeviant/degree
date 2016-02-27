package syntaxtree;

import visitor.Visitable;
import visitor.Visitor;

public abstract class Exp implements Visitable {

    @Override
    public abstract void accept(Visitor visitor);

}
