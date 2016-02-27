package syntaxtree;

import visitor.TypeVisitor;
import visitor.Visitor;

public class ClassDeclSimple extends ClassDecl {

    public Identifier identifier;
    public VarDeclList varDeclList;
    public MethodDeclList methodDeclList;

    public ClassDeclSimple(Identifier identifier, VarDeclList varDeclList, MethodDeclList methodDeclList) {
        this.identifier = identifier;
        this.varDeclList = varDeclList;
        this.methodDeclList = methodDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Type accept(TypeVisitor visitor) {
        return visitor.visit(this);
    }

}
