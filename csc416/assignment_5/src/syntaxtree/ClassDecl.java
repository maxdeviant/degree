package syntaxtree;

import visitor.TypeVisitor;
import visitor.Visitable;
import visitor.Visitor;

public abstract class ClassDecl implements Visitable {

    public abstract void accept(Visitor visitor);

    public abstract Type accept(TypeVisitor visitor);

}
