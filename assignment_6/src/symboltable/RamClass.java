package symboltable;

import symboltable.RamClass;
import symboltable.RamMethod;
import symboltable.RamVariable;
import syntaxtree.IdentifierType;
import syntaxtree.Type;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;


public class RamClass {

    private String id;
    private Map<String, RamMethod> methods;
    private Map<String, RamVariable> globals;
    private Type type;

    public RamClass(String id) {
        this.id = id;
        type = new IdentifierType(id);
        methods = new LinkedHashMap<>();
        globals = new LinkedHashMap<>();
    }

    public RamClass() {
    }

    public String getId() {
        return id;
    }

    public Type type() {
        return type;
    }

    public boolean addMethod(String id, Type type) {
        if (containsMethod(id)) {
            return false;
        } else {
            methods.put(id, new RamMethod(id, type));
            return true;
        }
    }

    public Set<RamMethod> getMethods() {
        return new LinkedHashSet<>(methods.values());
    }

    public RamMethod getMethod(String id) {
        return methods.get(id);
    }

    public int numMethods() {
        return methods.size();
    }

    public boolean addVar(String id, Type type) {
        if (globals.containsKey(id)) {
            return false;
        } else {
            globals.put(id, new RamVariable(id, type));
            return true;
        }
    }

    public RamVariable getVar(String id) {
        return globals.get(id);
    }

    public Set<RamVariable> getVars() {
        return new LinkedHashSet<>(globals.values());
    }

    public boolean containsVar(String id) {
        return globals.containsKey(id);
    }

    public boolean containsMethod(String id) {
        return methods.containsKey(id);
    }

    public int numGlobals() {
        return globals.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("    ").append(id).append("\n");
        sb.append("        Fields:\n");
        for (RamVariable v : getVars()) {
            sb.append("            ").append(v).append("\n");
        }
        sb.append("        Methods:\n");
        for (RamMethod m : getMethods()) {
            sb.append(m);
        }
        return sb.toString();
    }
}

