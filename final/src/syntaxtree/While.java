package syntaxtree;

import visitor.TypeVisitor;
import visitor.Visitor;


public class While extends Statement {
    public Exp e;
    public Statement s;

    public While(Exp ae, Statement as) {
        e = ae;
        s = as;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Type accept(TypeVisitor visitor) {
        return visitor.visit(this);
    }


}

