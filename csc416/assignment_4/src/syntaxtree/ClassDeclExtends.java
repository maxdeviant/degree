package syntaxtree;

import visitor.Visitor;

public class ClassDeclExtends extends ClassDecl {

    public Identifier identifier;
    public Identifier identifierTwo;
    public VarDeclList varDeclList;
    public MethodDeclList methodDeclList;

    public ClassDeclExtends(Identifier identifier, Identifier identifierTwo, VarDeclList varDeclList, MethodDeclList methodDeclList) {
        this.identifier = identifier;
        this.identifierTwo = identifierTwo;
        this.varDeclList = varDeclList;
        this.methodDeclList = methodDeclList;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
