package syntaxtree;

import java.util.Vector;

public class StatementList {

    private Vector<Statement> statements;

    public StatementList() {
        statements = new Vector<>();
    }

    public void addElement(Statement statement) {
        statements.addElement(statement);
    }

    public Statement elementAt(int index) {
        return statements.elementAt(index);
    }

    public int size() {
        return statements.size();
    }

}
