package syntaxtree;

import java.util.Vector;

public class ExpList {

    private Vector expList;

    public ExpList() {
        expList = new Vector();
    }

    public void addElement(Exp exp) {
        expList.addElement(exp);
    }

    public Exp elementAt(int index) {
        return (Exp) expList.elementAt(index);
    }

    public int size() {
        return expList.size();
    }

}
