package visitor;

/**
 * @author Marshall Bowers
 */
public interface Visitable {

    void accept(Visitor visitor);

}
