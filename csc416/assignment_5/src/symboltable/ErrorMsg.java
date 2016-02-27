package symboltable;

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
    public void complain(String message) {
        hasErrors = true;

        System.out.println(message);
    }

    /**
     * Complain about the provided error message.
     *
     * @param message The error message to display.
     */
    public void complain(int lineNumber, String message) {
        hasErrors = true;

        System.out.println(String.format("%d: %s", lineNumber, message));
    }

}
