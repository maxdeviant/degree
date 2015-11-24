package symboltable;import syntaxtree.*;import java.util.Hashtable;public class Table {    private Hashtable<String, RamClass> hashtable;    public Table() {        hashtable = new Hashtable<>();    }    public boolean addClass(String id) {        if (containsClass(id)) {            return false;        } else {            hashtable.put(id, new RamClass(id));        }        return true;    }    public RamClass getClass(String id) {        if (containsClass(id)) {            return hashtable.get(id);        } else {            return null;        }    }    public int numClasses() {        return hashtable.size();    }    public boolean containsClass(String id) {        return hashtable.containsKey(id);    }    public Type getVarType(RamMethod m, RamClass c, String id) {        if (m != null) {            if (m.getVar(id) != null) {                return m.getVar(id).type();            }            if (m.getParam(id) != null) {                return m.getParam(id).type();            }        }        if (c.getVar(id) != null) {            return c.getVar(id).type();        }        System.out.println("Variable " + id + " not defined in current scope");        System.exit(0);        return null;    }    public RamMethod getMethod(String id, String classScope) {        if (getClass(classScope) == null) {            System.out.println("Class " + classScope + " not defined");            System.exit(0);        }        RamClass c = getClass(classScope);        if (c.getMethod(id) != null) {            return c.getMethod(id);        }        System.out.println("Method " + id + " not defined in class " + classScope);        System.exit(0);        return null;    }    public Type getMethodType(String id, String classScope) {        if (getClass(classScope) == null) {            System.out.println("Class " + classScope + " not defined");            System.exit(0);        }        RamClass c = getClass(classScope);        if (c.getMethod(id) != null) {            return c.getMethod(id).type();        }        System.out.println("Method " + id + " not defined in class " + classScope);        System.exit(0);        return null;    }    public boolean compareTypes(Type t1, Type t2) {        if (t1 == null || t2 == null) {            return false;        }        if (t1 instanceof IntegerType && t2 instanceof IntegerType) {            return true;        }        if (t1 instanceof BooleanType && t2 instanceof BooleanType) {            return true;        }        if (t1 instanceof IntArrayType && t2 instanceof IntArrayType) {            return true;        }        if (t1 instanceof IdentifierType && t2 instanceof IdentifierType) {            IdentifierType i1 = (IdentifierType) t1;            IdentifierType i2 = (IdentifierType) t2;            RamClass c = getClass(i2.string);            if (i1.string.equals(c.getIdentifier())) {                return true;            }        }        return false;    }    public boolean anyErrors() {        // TODO: Return a real result here        return false;    }}