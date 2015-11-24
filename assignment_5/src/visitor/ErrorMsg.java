package visitor;

/**
 * A class for handling error message in the compiler.
 */
public class ErrorMsg {

    /**
     * A flag indicating whether or not any errors were encountered.
     */
    boolean hasErrors;

    /**
     * Complain about the provided error message.
     *
     * @param message The error message to display.
     */
    void complain(String message) {
        hasErrors = true;

        System.out.println(message);
    }

}
