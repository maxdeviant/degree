package symboltable;

import syntaxtree.Type;

public class RamVariable {

    private final String identifier;
    private final Type type;

    public RamVariable(String identifier, Type type) {
        this.identifier = identifier;
        this.type = type;
    }

    public String id() {
        return identifier;
    }

    public Type type() {
        return type;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
