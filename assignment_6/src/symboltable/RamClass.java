package symboltable;


import syntaxtree.Type;

import java.util.Set;

public interface RamClass {
    String getId();

    Type type();

    boolean addMethod(String id, Type type);

    Set<RamMethod> getMethods();

    RamMethod getMethod(String id);

    int numMethods();

    int numGlobals();

    boolean addVar(String id, Type type);

    RamVariable getVar(String id);

    Set<RamVariable> getVars();

    boolean containsVar(String id);

    boolean containsMethod(String id);
}
