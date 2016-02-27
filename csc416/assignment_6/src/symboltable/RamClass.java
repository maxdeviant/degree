package symboltable;

import syntaxtree.IdentifierType;
import syntaxtree.Type;

import java.util.*;


public class RamClass {

    private String identifier;
    private Hashtable<String, RamMethod> methods;
    private Hashtable<String, RamVariable> globals;
    private Type type;

    public RamClass(String identifier) {
        this.identifier = identifier;
        type = new IdentifierType(identifier);
        methods = new Hashtable<>();
        globals = new Hashtable<>();
    }

    public RamClass() {
    }

    public String getIdentifier() {
        return identifier;
    }

    public Type type() {
        return type;
    }

    public boolean addMethod(String id, Type type) {
        if (containsMethod(id)) {
            return false;
        }

        methods.put(id, new RamMethod(id, type));

        return true;
    }

    public Set<String> getMethods() {
        return methods.keySet();
    }

    public RamMethod getMethod(String id) {
        if (containsMethod(id)) {
            return methods.get(id);
        }

        return null;
    }

    public int numMethods() {
        return methods.size();
    }

    public int numGlobals() {
        return globals.size();
    }

    public boolean addVar(String id, Type type) {
        if (globals.containsKey(id)) {
            return false;
        }

        globals.put(id, new RamVariable(id, type));

        return true;
    }

    public RamVariable getVar(String id) {
        if (containsVar(id)) {
            return globals.get(id);
        }

        return null;
    }

    public boolean containsVar(String id) {
        return globals.containsKey(id);
    }

    public boolean containsMethod(String id) {
        return methods.containsKey(id);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%s\n", identifier));

        stringBuilder.append("    ");
        stringBuilder.append("    ");
        stringBuilder.append("Fields:\n");

        for (RamVariable ramVariable : globals.values()) {
            stringBuilder.append("    ");
            stringBuilder.append("    ");
            stringBuilder.append("    ");
            stringBuilder.append(String.format("%s\n", ramVariable.toString()));
        }

        stringBuilder.append("    ");
        stringBuilder.append("    ");
        stringBuilder.append("Methods:\n");

        for (RamMethod ramMethod : methods.values()) {
            stringBuilder.append("    ");
            stringBuilder.append("    ");
            stringBuilder.append("    ");
            stringBuilder.append(String.format("%s\n", ramMethod.toString()));
        }

        return stringBuilder.toString();
    }

}

