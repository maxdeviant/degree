package syntaxtree;

import visitor.Visitable;
import visitor.Visitor;

public abstract class ClassDecl implements Visitable {

    @Override
    public abstract void accept(Visitor visitor);

}
