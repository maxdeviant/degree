package symboltable;import syntaxtree.IdentifierType;import syntaxtree.Type;import java.util.Hashtable;import java.util.Set;public class RamClass {    private String identifier;    private Hashtable<String, RamMethod> methods;    private Hashtable<String, RamVariable> globals;    private Type type;    public RamClass(String identifier) {        this.identifier = identifier;        type = new IdentifierType(identifier);        methods = new Hashtable<>();        globals = new Hashtable<>();    }    public RamClass() {    }    public String getIdentifier() {        return identifier;    }    public Type type() {        return type;    }    public boolean addMethod(String id, Type type) {        if (containsMethod(id)) {            return false;        }        methods.put(id, new RamMethod(id, type));        return true;    }    public Set<String> getMethods() {        return methods.keySet();    }    public RamMethod getMethod(String id) {        if (containsMethod(id)) {            return methods.get(id);        }        return null;    }    public int numMethods() {        return methods.size();    }    public boolean addVariable(String id, Type type) {        if (globals.containsKey(id)) {            return false;        }        globals.put(id, new RamVariable(id, type));        return true;    }    public RamVariable getVariable(String id) {        if (containsVariable(id)) {            return globals.get(id);        }        return null;    }    public boolean containsVariable(String id) {        return globals.containsKey(id);    }    public boolean containsMethod(String id) {        return methods.containsKey(id);    }}