package syntaxtree;

import java.util.Vector;

public class FormalList {

    private Vector formatList;

    public FormalList() {
        formatList = new Vector();
    }

    public void addElement(Formal formal) {
        formatList.addElement(formal);
    }

    public Formal elementAt(int index) {
        return (Formal) formatList.elementAt(index);
    }

    public int size() {
        return formatList.size();
    }

}
