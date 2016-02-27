package syntaxtree;

import java.util.Vector;

public class FormalList {

    private Vector formalList;

    public FormalList() {
        formalList = new Vector();
    }

    public void addElement(Formal formal) {
        formalList.addElement(formal);
    }

    public Formal elementAt(int index) {
        return (Formal) formalList.elementAt(index);
    }

    public int size() {
        return formalList.size();
    }

}
