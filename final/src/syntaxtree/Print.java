package syntaxtree;

import visitor.TypeVisitor;
import visitor.Visitor;


public class Print extends Statement {
    public ExpList el;

    public Print(ExpList ael) {
        el = ael;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Type accept(TypeVisitor visitor) {
        return visitor.visit(this);
    }


}
