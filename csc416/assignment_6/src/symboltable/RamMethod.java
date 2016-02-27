package symboltable;

import syntaxtree.Type;
import visitor.CodeGenerator;

import java.util.Hashtable;

/**
 * A symbol table representation of a method.
 *
 * @author Marshall Bowers
 */
public class RamMethod {

    /**
     * The name of the method.
     */
    private final String identifier;

    /**
     * The return type of the method.
     */
    private final Type type;

    /**
     * A collection of all the parameters for this method.
     */
    private Hashtable<String, RamVariable> parameters = new Hashtable<>();

    /**
     * A collection of all the variables for this method.
     */
    private Hashtable<String, RamVariable> variables = new Hashtable<>();

    private int variableOffset = -CodeGenerator.FRAME_MIN;
    private int parameterOffset = 4;

    /**
     * Creates a new method with the specified name and return type.
     *
     * @param identifier The name of the method.
     * @param type       The return type of the method.
     */
    public RamMethod(String identifier, Type type) {
        this.identifier = identifier;
        this.type = type;
    }

    /**
     * Retrieves the name of this method.
     *
     * @return The name of this method.
     */
    public String getId() {
        return identifier;
    }

    /**
     * Adds a parameter with the specified name and type to the method.
     *
     * @param identifier The name of the parameter to add.
     * @param type       The type of the parameter to add.
     * @return True if the parameter was added (identifier.e., does not already exist), false otherwise.
     */
    public boolean addParam(String identifier, Type type) {
        if (containsParam(identifier)) {
            return false;
        }

        parameters.put(identifier, new RamVariable(identifier, type, parameterOffset));

        parameterOffset += 4;

        return true;
    }

    /**
     * Retrieves the parameter with the specified name.
     *
     * @param identifier THe name of the parameter to retrieve.
     * @return The parameter with the specified name, if it exists.
     */
    public RamVariable getParam(String identifier) {
        if (!containsParam(identifier)) {
            return null;
        }

        return parameters.get(identifier);
    }

    /**
     * Retrieves the parameter at the specified index of the method arguments.
     *
     * @param index The index to get the parameter at.
     * @return The parameter at the specified index of the method arguments.
     */
    public RamVariable getParamAt(int index) {
        if (index > parameters.size()) {
            return null;
        }

        int counter = 0;

        for (RamVariable variable : parameters.values()) {
            if (counter == index) {
                return variable;
            }
        }

        return null;
    }

    /**
     * Returns whether or not the method contains a parameter with the specified name.
     *
     * @param identifier The name of the parameter to check if the method contains.
     * @return A flag indicating whether or not the method contains the specified parameter.
     */
    public boolean containsParam(String identifier) {
        return parameters.containsKey(identifier);
    }

    public int numParams() {
        return parameters.size();
    }

    /**
     * Adds a variable with the specified name and type to the method.
     *
     * @param identifier The name of the variable to add.
     * @param type       The type of the variable to add.
     * @return True if the variable was added (identifier.e., does not already exist), false otherwise.
     */
    public boolean addVar(String identifier, Type type) {
        if (containsVar(identifier)) {
            return false;
        }

        variables.put(identifier, new RamVariable(identifier, type, variableOffset));

        variableOffset -= 4;

        return true;
    }

    /**
     * Retrieves the variable with the specified name.
     *
     * @param identifier THe name of the variable to retrieve.
     * @return The variable with the specified name, if it exists.
     */
    public RamVariable getVar(String identifier) {
        if (!containsVar(identifier)) {
            return null;
        }

        return variables.get(identifier);
    }

    public Hashtable<String, RamVariable> getVars() {
        return variables;
    }

    /**
     * Returns whether or not the method contains a variable with the specified name.
     *
     * @param identifier The name of the variable to check if the method contains.
     * @return A flag indicating whether or not the method contains the specified variable.
     */
    public boolean containsVar(String identifier) {
        return variables.containsKey(identifier);
    }

    /**
     * Retrieves the type of the method.
     *
     * @return The type of the method.
     */
    public Type type() {
        return type;
    }

    /**
     * Retrieves the string representation of this object.
     *
     * @return The string representation of this object.
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%s %s\n", type.getClass(), identifier));

        stringBuilder.append("    ");
        stringBuilder.append("    ");
        stringBuilder.append("    ");
        stringBuilder.append("    ");
        stringBuilder.append("Params:\n");

        for (RamVariable ramVariable : parameters.values()) {
            stringBuilder.append("    ");
            stringBuilder.append("    ");
            stringBuilder.append("    ");
            stringBuilder.append("    ");
            stringBuilder.append("    ");
            stringBuilder.append(String.format("%s\n", ramVariable.toString()));
        }

        stringBuilder.append("    ");
        stringBuilder.append("    ");
        stringBuilder.append("    ");
        stringBuilder.append("    ");
        stringBuilder.append("Locals:\n");

        for (RamVariable ramVariable : variables.values()) {
            stringBuilder.append("    ");
            stringBuilder.append("    ");
            stringBuilder.append("    ");
            stringBuilder.append("    ");
            stringBuilder.append("    ");
            stringBuilder.append(String.format("%s\n", ramVariable.toString()));
        }

        return stringBuilder.toString();
    }

}
