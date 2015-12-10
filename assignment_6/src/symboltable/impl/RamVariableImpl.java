package symboltable.impl;

import symboltable.RamVariable;
import syntaxtree.Type;

public class RamVariableImpl implements RamVariable {

    private String id;
    private Type type;
    private Integer offset;

    public RamVariableImpl(String id, Type type) {
        this(id, type, null);
    }

    public RamVariableImpl(String id, Type type, Integer offset) {
        this.id = id;
        this.type = type;
        this.offset = offset;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Type type() {
        return type;
    }

    @Override
    public int getOffset() {
        return offset;
    }

    @Override
    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Override
    public String toString() {
        return id + " - " + type;
    }

}
