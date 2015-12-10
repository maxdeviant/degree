package symboltable;


import syntaxtree.Type;

import java.util.Set;

public interface Table {
    boolean addClass(String id);

    RamClass getClass(String id);

    Set<RamClass> getClasses();

    int numClasses();

    boolean containsClass(String id);

    Type getVarType(RamMethod m, RamClass c, String id);

    RamMethod getMethod(String id, String classScope);

    Type getMethodType(String id, String classScope);

    boolean compareTypes(Type t1, Type t2);

    boolean anyErrors();

}
