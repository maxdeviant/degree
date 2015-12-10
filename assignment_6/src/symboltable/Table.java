package symboltable;

import ram15compiler.ErrorMsg;
import ram15compiler.SemanticException;
import symboltable.RamClass;
import symboltable.RamMethod;
import symboltable.Table;
import syntaxtree.*;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Table {

    private Map<String, RamClass> table;
    private ErrorMsg errors;

    public Table() {
        table = new HashMap<>();
        errors = ErrorMsg.getInstance();
    }

    public boolean addClass(String id) {
        if (containsClass(id)) {
            return false;
        } else {
            table.put(id, new RamClass(id));
        }
        return true;
    }

    public RamClass getClass(String id) {
        if (containsClass(id)) {
            return table.get(id);
        } else {
            return null;
        }
    }

    public Set<RamClass> getClasses() {
        return new LinkedHashSet<>(table.values());
    }

    public int numClasses() {
        return table.size();
    }

    public boolean containsClass(String id) {
        return table.containsKey(id);
    }

    public Type getVarType(RamMethod m, RamClass c, String id) {
        if (m != null) {
            if (m.getVar(id) != null) {
                return m.getVar(id).type();
            }
            if (m.getParam(id) != null) {
                return m.getParam(id).type();
            }
        }

        if (c.getVar(id) != null) {
            return c.getVar(id).type();
        }

        errors.addError(new SemanticException("Variable " + id
                + " not defined in current scope"));
        return null;
    }

    public RamMethod getMethod(String id, String classScope) {
        if (getClass(classScope) == null) {
            errors.addError(new SemanticException("Class " + classScope
                    + " not defined"));
            return null;
        }

        RamClass c = getClass(classScope);

        if (c.getMethod(id) != null) {
            return c.getMethod(id);
        }

        errors.addError(new SemanticException("Method " + id + " not defined in class " + classScope));
        return null;
    }

    public boolean anyErrors() {
        return errors.hasErrors();
    }

    public Type getMethodType(String id, String classScope) {
        if (getClass(classScope) == null) {
            errors.addError(new SemanticException("Class " + classScope
                    + " not defined"));
            return null;
        }

        RamClass c = getClass(classScope);

        if (c.getMethod(id) != null) {
            return c.getMethod(id).type();
        }

        errors.addError(new SemanticException("Method " + id + " not defined in class " + classScope));
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

        // 1 = true, all other ints = false
        if (t1 instanceof BooleanType && t2 instanceof IntegerType) {
            return true;
        }

        if (t1 instanceof IntArrayType && t2 instanceof IntArrayType) {
            return true;
        }
        if (t1 instanceof IdentifierType && t2 instanceof IdentifierType) {
            IdentifierType i1 = (IdentifierType) t1;
            IdentifierType i2 = (IdentifierType) t2;

            RamClass c = getClass(i2.s);

            if (i1.s.equals(c.getId())) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Classes:\n");
        for (RamClass c : getClasses()) {
            sb.append(c).append("\n");
        }
        return sb.toString();
    }

}

