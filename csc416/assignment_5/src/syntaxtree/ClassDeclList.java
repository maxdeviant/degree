package syntaxtree;

import java.util.Vector;

public class ClassDeclList {

    private Vector<ClassDecl> classDecls;

    public ClassDeclList() {
        classDecls = new Vector<>();
    }

    public void addElement(ClassDecl classDecl) {
        classDecls.addElement(classDecl);
    }

    public ClassDecl elementAt(int index) {
        return classDecls.elementAt(index);
    }

    public int size() {
        return classDecls.size();
    }

}
