package syntaxtree;

import visitor.Visitable;
import visitor.Visitor;

public abstract class Statement implements Visitable {

    @Override
    public abstract void accept(Visitor visitor);

}
