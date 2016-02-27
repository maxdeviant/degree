package syntaxtree;

import visitor.TypeVisitor;
import visitor.Visitor;

public abstract class Type {

    public abstract void accept(Visitor visitor);

    public abstract Type accept(TypeVisitor visitor);

}
