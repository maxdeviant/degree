package visitor;

import syntaxtree.*;

public interface Visitor {

    void visit(Program n);

    void visit(MainClass n);

    void visit(ClassDeclSimple n);

    void visit(VarDecl n);

    void visit(MethodDecl n);

    void visit(Formal n);

    void visit(IntArrayType n);

    void visit(BooleanType n);

    void visit(IntegerType n);

    void visit(IdentifierType n);

    void visit(Block n);

    void visit(If n);

    void visit(While n);

    void visit(Print n);

    void visit(Println n);

    void visit(Assign n);

    void visit(ArrayAssign n);

    void visit(And n);

    void visit(Or n);

    void visit(LessThan n);

    void visit(Equals n);

    void visit(Plus n);

    void visit(PlusEquals n);

    void visit(MinusEquals n);

    void visit(Minus n);

    void visit(Times n);

    void visit(Slice n);

    void visit(ArrayLookup n);

    void visit(ArrayLength n);

    void visit(Call n);

    void visit(IntegerLiteral n);

    void visit(True n);

    void visit(False n);

    void visit(IdentifierExp n);

    void visit(This n);

    void visit(NewArray n);

    void visit(NewObject n);

    void visit(Not n);

    void visit(Identifier n);

    void visit(ParenExp n);

    void visit(ClassDeclExtends n);

}
