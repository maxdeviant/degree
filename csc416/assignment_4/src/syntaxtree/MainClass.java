package syntaxtree;

import visitor.Visitable;
import visitor.Visitor;

public class MainClass implements Visitable {

    public Identifier identifier;
    public Identifier identifierTwo;
    public Statement statement;

    public MainClass(Identifier identifier, Identifier identifierTwo, Statement statement) {
        this.identifier = identifier;
        this.identifierTwo = identifierTwo;
        this.statement = statement;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}

