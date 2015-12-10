package symboltable.impl;

import symboltable.RamMethod;
import symboltable.RamVariable;
import syntaxtree.Type;
import visitor.impl.CodeGenerator;

import java.util.*;

public class RamMethodImpl implements RamMethod {

    private String id;
    private Type type;
    private Map<String, RamVariable> params;
    private Map<String, RamVariable> vars;
    private int varOffset = -CodeGenerator.FRAME_MIN;
    private int paramOffset = 4;

    public RamMethodImpl(String id, Type type) {
        this.id = id;
        this.type = type;
        this.params = new LinkedHashMap<>();
        this.vars = new HashMap<>();
    }

    @Override
    public boolean addParam(String id, Type type) {
        if (params.containsKey(id)) {
            return false;
        }
        params.put(id, new RamVariableImpl(id, type, paramOffset));
        paramOffset += 4;
        return true;
    }

    @Override
    public boolean addVar(String id, Type type) {
        if (vars.containsKey(id)) {
            return false;
        }
        vars.put(id, new RamVariableImpl(id, type, varOffset));
        varOffset -= 4;
        return true;
    }

    @Override
    public boolean containsParam(String id) {
        return params.containsKey(id);
    }

    @Override
    public boolean containsVar(String id) {
        return vars.containsKey(id);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public RamVariable getParam(String id) {
        return params.get(id);
    }

    @Override
    public RamVariable getParamAt(int i) {
        return new LinkedList<>(params.values()).get(i);
    }

    @Override
    public Set<RamVariable> getParams() {
        return new LinkedHashSet<>(params.values());
    }

    @Override
    public RamVariable getVar(String id) {
        return vars.get(id);
    }

    @Override
    public Set<RamVariable> getVars() {
        return new LinkedHashSet<>(vars.values());
    }

    @Override
    public Type type() {
        return type;
    }

    @Override
    public int numParams() {
        return params.size();
    }

    @Override
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
