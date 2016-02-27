package syntaxtree;

import java.util.Vector;

public class MethodDeclList {

    private Vector<MethodDecl> methodDecls;

    public MethodDeclList() {
        methodDecls = new Vector<>();
    }

    public void addElement(MethodDecl methodDecl) {
        methodDecls.addElement(methodDecl);
    }

    public MethodDecl elementAt(int index) {
        return methodDecls.elementAt(index);
    }

    public int size() {
        return methodDecls.size();
    }

}
