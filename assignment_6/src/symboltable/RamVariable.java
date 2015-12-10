package symboltable;

import syntaxtree.Type;

public class RamVariable {

    private String id;
    private Type type;
    private Integer offset;

    public RamVariable(String id, Type type) {
        this(id, type, null);
    }

    public RamVariable(String id, Type type, Integer offset) {
        this.id = id;
        this.type = type;
        this.offset = offset;
    }

    public String getId() {
        return id;
    }

    public Type type() {
        return type;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String toString() {
        return id + " - " + type;
    }

}
