package syntaxtree;

import visitor.TypeVisitor;
import visitor.Visitor;

public class Program {

    public MainClass mainClass;
    public ClassDeclList classDeclList;

    public Program(MainClass mainClass, ClassDeclList classDeclList) {
        this.mainClass = mainClass;
        this.classDeclList = classDeclList;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }

}
