package visitor;import symboltable.RamClass;import symboltable.RamMethod;import symboltable.Table;import syntaxtree.*;public class BuildSymbolTableVisitor extends TypeDepthFirstVisitor {    private Table symbolTable;    private RamClass currentClass;    private RamMethod currentMethod;    public BuildSymbolTableVisitor() {        symbolTable = new Table();    }    public Table getSymTab() {        return symbolTable;    }    // MainClass mainClass;    // ClassDeclList classDeclList;    @Override    public Type visit(Program n) {        n.mainClass.accept(this);        for (int i = 0; i < n.classDeclList.size(); i++) {            n.classDeclList.elementAt(i).accept(this);        }        return null;    }    // Identifier identifier,identifierTwo;    // Statement string;    @Override    public Type visit(MainClass n) {        symbolTable.addClass(n.identifier.toString());        currentClass = symbolTable.getClass(n.identifier.toString());        // Ugly hack -- creating        // new IdentifierType("void") and new IdentifierType("String[]");        // not worth defining a VoidType and StringAryType        // for just a few occurrences        symbolTable.getClass(n.identifier.string).addMethod("main", new IdentifierType("void"));        currentMethod = symbolTable.getClass(n.identifier.toString()).getMethod("main");        symbolTable.getMethod("main", currentClass.getIdentifier()).addParam(n.identifierTwo.toString(), new IdentifierType("String[]"));        n.statement.accept(this);        currentMethod = null;        return null;    }    // Identifier identifier;    // VarDeclList varDeclList;    // MethodDeclList methodDeclList;    @Override    public Type visit(ClassDeclSimple n) {        if (!symbolTable.addClass(n.identifier.toString())) {            System.out.println("Class " + n.identifier.toString() + " is already defined");            System.exit(-1);        }        currentClass = symbolTable.getClass(n.identifier.toString());        for (int i = 0; i < n.varDeclList.size(); i++) {            n.varDeclList.elementAt(i).accept(this);        }        for (int i = 0; i < n.methodDeclList.size(); i++) {            n.methodDeclList.elementAt(i).accept(this);        }        return null;    }    // Type type;    // Identifier identifier;    @Override    public Type visit(VarDecl n) {        Type type = n.type.accept(this);        String identifier = n.identifier.toString();        if (currentMethod == null) {            if (!currentClass.addVar(identifier, type)) {                System.out.println(identifier + " is already defined in " + currentClass.getIdentifier());                System.exit(-1);            }        } else {            if (!currentMethod.addVar(identifier, type)) {                System.out.println(identifier + " is already defined in " + currentClass.getIdentifier() + "." + currentMethod.getId());                System.exit(-1);            }        }        return null;    }    @Override    public Type visit(MethodDecl n) {        Type type = n.type.accept(this);        String identifier = n.identifier.toString();        if (!currentClass.addMethod(identifier, type)) {            System.out.printf("Method %s is already defined in %s", identifier, currentClass.getIdentifier());            System.exit(-1);        }        currentMethod = currentClass.getMethod(identifier);        for (int i = 0; i < n.formalList.size(); i++) {            n.formalList.elementAt(i).accept(this);        }        for (int i = 0; i < n.varDeclList.size(); i++) {            n.varDeclList.elementAt(i).accept(this);        }        for (int i = 0; i < n.statementList.size(); i++) {            n.statementList.elementAt(i).accept(this);        }        n.exp.accept(this);        currentMethod = null;        return null;    }    @Override    public Type visit(Formal n) {        Type type = n.type.accept(this);        String identifier = n.identifier.toString();        if (!currentMethod.addParam(identifier, type)) {            System.out.printf("Formal %s is already defined in %s.%s", identifier, currentClass.getIdentifier(), currentMethod.getId());            System.exit(-1);        }        return null;    }    @Override    public Type visit(IntArrayType n) {        return n;    }    @Override    public Type visit(BooleanType n) {        return n;    }    @Override    public Type visit(IntegerType n) {        return n;    }    @Override    public Type visit(IdentifierType n) {        return n;    }    @Override    public Type visit(Block n) {        for (int i = 0; i < n.statementList.size(); i++) {            n.statementList.elementAt(i).accept(this);        }        return null;    }    @Override    public Type visit(Println n) {        return null;    }    @Override    public Type visit(Or n) {        return null;    }    @Override    public Type visit(Equals n) {        return null;    }    @Override    public Type visit(PlusEquals n) {        return null;    }    @Override    public String toString() {        return "FOOBAR";    }}