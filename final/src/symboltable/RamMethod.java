package symboltable;


import syntaxtree.Type;

import java.util.Set;

public interface RamMethod {
    boolean addParam(String id, Type type);

    boolean addVar(String id, Type type);

    boolean containsParam(String id);

    boolean containsVar(String id);

    String getId();

    RamVariable getParam(String id);

    RamVariable getParamAt(int i);

    Set<RamVariable> getParams();

    int numParams();

    RamVariable getVar(String id);

    Set<RamVariable> getVars();

    Type type();

}
