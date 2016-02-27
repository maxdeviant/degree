package syntaxtree;

import visitor.Visitor;

public class Slice extends Exp {

    public Exp expOne;
    public Exp expTwo;
    public Exp expThree;

    public Slice(Exp expOne, Exp expTwo, Exp expThree) {
        this.expOne = expOne;
        this.expTwo = expTwo;
        this.expThree = expThree;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
