package syntaxtree;

import visitor.Visitable;
import visitor.Visitor;

public class MethodDecl implements Visitable {

    public Type type;
    public Identifier identifier;
    public FormalList formalList;
    public VarDeclList varDeclList;
    public StatementList statementList;
    public Exp exp;

    public MethodDecl(Type type, Identifier identifier, FormalList formalList, VarDeclList varDeclList, StatementList statementList, Exp exp) {
        this.type = type;
        this.identifier = identifier;
        this.formalList = formalList;
        this.varDeclList = varDeclList;
        this.statementList = statementList;
        this.exp = exp;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
