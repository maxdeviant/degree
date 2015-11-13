package symboltable;

import syntaxtree.Type;

public class RamMethod {

    private final String identifier;
    private final Type type;

    public RamMethod(String identifier, Type type) {
        this.identifier = identifier;
        this.type = type;
    }

    public String getIdentifier() {
        return identifier;
    }


    public boolean addParameter(String identifier, Type type) {
        return false;
    }

    public boolean containsParameter(String identifier) {
        return false;
    }

    public RamVariable getParameter(String identifier) {
        return null;
    }

    public RamVariable getParameterAt(int index) {
        return null;
    }

    public boolean addVariable(String identifier, Type type) {
        return false;
    }

    public boolean containsVariable(String identifier) {
        return false;
    }

    public RamVariable getVariable(String identifier) {
        return null;
    }

    public Type type() {
        return type;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
