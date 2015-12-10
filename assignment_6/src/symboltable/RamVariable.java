package symboltable;


import syntaxtree.Type;

public interface RamVariable {
    String getId();

    Type type();

    int getOffset();

    void setOffset(int offset);
}
