package syntaxtree;

import java.util.Vector;

public class VarDeclList {

    private Vector<VarDecl> varDecls;

    public VarDeclList() {
        varDecls = new Vector<>();
    }

    public void addElement(VarDecl varDecl) {
        varDecls.addElement(varDecl);
    }

    public VarDecl elementAt(int index) {
        return varDecls.elementAt(index);
    }

    public int size() {
        return varDecls.size();
    }

}
