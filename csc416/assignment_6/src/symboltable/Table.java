package symboltable;

import syntaxtree.*;

import java.util.Hashtable;

public class Table {

    public ErrorMsg errorHandler = new ErrorMsg();

    private Hashtable<String, RamClass> hashtable;

    public Table() {
        hashtable = new Hashtable<>();
    }

    public boolean addClass(String id) {
        if (containsClass(id)) {
            return false;
        }

        hashtable.put(id, new RamClass(id));

        return true;
    }

    public RamClass getClass(String id) {
        if (containsClass(id)) {
            return hashtable.get(id);
        }

        return null;
    }

    public int numClasses() {
        return hashtable.size();
    }

    public boolean containsClass(String id) {
        return hashtable.containsKey(id);
    }

    public Type getVarType(RamMethod ramMethod, RamClass ramClass, String identifier) {
        if (ramMethod != null) {
            if (ramMethod.getVar(identifier) != null) {
                return ramMethod.getVar(identifier).type();
            }

            if (ramMethod.getParam(identifier) != null) {
                return ramMethod.getParam(identifier).type();
            }
        }

        if (ramClass.getVar(identifier) != null) {
            return ramClass.getVar(identifier).type();
        }

        errorHandler.complain(String.format("Variable %s not defined in current scope.", identifier));

        return null;
    }

    public RamMethod getMethod(String id, String classScope) {
        RamClass ramClass = getClass(classScope);

        if (ramClass == null) {
            errorHandler.complain(String.format("Class %s not defined.", classScope));
        }

        if (ramClass.getMethod(id) != null) {
            return ramClass.getMethod(id);
        }

        errorHandler.complain(String.format("Method %s not defined in class %s.", id, classScope));

        return null;
    }

    public Type getMethodType(String id, String classScope) {
        if (getClass(classScope) == null) {
            errorHandler.complain(String.format("Class %s not defined.", classScope));
        }

        RamClass c = getClass(classScope);

        if (c.getMethod(id) != null) {
            return c.getMethod(id).type();
        }

        errorHandler.complain(String.format("Method %s not defined in class %s", id, classScope));

        return null;
    }

    public boolean compareTypes(Type t1, Type t2) {

        if (t1 == null || t2 == null) {
            return false;
        }

        if (t1 instanceof IntegerType && t2 instanceof IntegerType) {
            return true;
        }

        if (t1 instanceof BooleanType && t2 instanceof BooleanType) {
            return true;
        }

        if (t1 instanceof IntArrayType && t2 instanceof IntArrayType) {
            return true;
        }

        if (t1 instanceof IdentifierType && t2 instanceof IdentifierType) {
            IdentifierType i1 = (IdentifierType) t1;
            IdentifierType i2 = (IdentifierType) t2;

            RamClass c = getClass(i2.string);

            if (i1.string.equals(c.getIdentifier())) {
                return true;
            }
        }

        return false;
    }

    public boolean anyErrors() {
        return errorHandler.hasErrors;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Classes:\n");

        for (RamClass ramClass : hashtable.values()) {
            stringBuilder.append("    ");
            stringBuilder.append(String.format("%s\n", ramClass.toString()));
        }

        return stringBuilder.toString();
    }

}
