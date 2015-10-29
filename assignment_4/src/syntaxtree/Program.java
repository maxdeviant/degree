package syntaxtree;

import visitor.Visitable;
import visitor.Visitor;

public class Program implements Visitable {

    public MainClass mainClass;
    public ClassDeclList classDeclList;

    public Program(MainClass mainClass, ClassDeclList classDeclList) {
        this.mainClass = mainClass;
        this.classDeclList = classDeclList;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
