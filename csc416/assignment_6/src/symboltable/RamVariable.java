package symboltable;

import syntaxtree.Type;

public class RamVariable {

    private final String identifier;
    private final Type type;
    private final Integer offset;

    public RamVariable(String identifier, Type type) {
        this(identifier, type, null);
    }

    public RamVariable(String identifier, Type type, Integer offset) {
        this.identifier = identifier;
        this.type = type;
        this.offset = offset;
    }

    public String id() {
        return identifier;
    }

    public Type type() {
        return type;
    }

    public Integer offset() {
        return offset;
    }

    @Override
    public String toString() {
        return String.format("%s %s", type.getClass(), identifier);
    }

}
