package symboltable;

import syntaxtree.Type;
import visitor.CodeGenerator;

import java.util.*;

public class RamMethod {

    private String id;
    private Type type;
    private Map<String, RamVariable> params;
    private Map<String, RamVariable> vars;
    private int varOffset = -CodeGenerator.FRAME_MIN;
    private int paramOffset = 4;

    public RamMethod(String id, Type type) {
        this.id = id;
        this.type = type;
        this.params = new LinkedHashMap<>();
        this.vars = new HashMap<>();
    }

    public boolean addParam(String id, Type type) {
        if (params.containsKey(id)) {
            return false;
        }
        params.put(id, new RamVariable(id, type, paramOffset));
        paramOffset += 4;
        return true;
    }

    public boolean addVar(String id, Type type) {
        if (vars.containsKey(id)) {
            return false;
        }
        vars.put(id, new RamVariable(id, type, varOffset));
        varOffset -= 4;
        return true;
    }

    public boolean containsParam(String id) {
        return params.containsKey(id);
    }

    public boolean containsVar(String id) {
        return vars.containsKey(id);
    }

    public String getId() {
        return id;
    }

    public RamVariable getParam(String id) {
        return params.get(id);
    }

    public RamVariable getParamAt(int i) {
        return new LinkedList<>(params.values()).get(i);
    }

    public Set<RamVariable> getParams() {
        return new LinkedHashSet<>(params.values());
    }

    public RamVariable getVar(String id) {
        return vars.get(id);
    }

    public Set<RamVariable> getVars() {
        return new LinkedHashSet<>(vars.values());
    }

    public Type type() {
        return type;
    }

    public int numParams() {
        return params.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("            ").append(id).append(" - ").append(type).append("\n");
        sb.append("                Params:\n");
        for (RamVariable v : getParams()) {
            sb.append("                    ").append(v).append("\n");
        }
        sb.append("                Locals:\n");
        for (RamVariable v : getVars()) {
            sb.append("                    ").append(v).append("\n");
        }
        return sb.toString();
    }

}
