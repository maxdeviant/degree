package syntaxtree;

import visitor.Visitable;
import visitor.Visitor;

public abstract class Type implements Visitable {

    @Override
    public abstract void accept(Visitor visitor);

}
