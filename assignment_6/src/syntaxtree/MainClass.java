package syntaxtree;

import visitor.TypeVisitor;
import visitor.Visitor;

public class MainClass {

    public Identifier identifier;
    public Identifier identifierTwo;
    public Statement statement;

    public MainClass(Identifier identifier, Identifier identifierTwo, Statement statement) {
        this.identifier = identifier;
        this.identifierTwo = identifierTwo;
        this.statement = statement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Type accept(TypeVisitor visitor) {
        return visitor.visit(this);
    }

}

