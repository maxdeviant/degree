package ram15compiler;


import java.util.LinkedList;
import java.util.List;

public class ErrorMsg {

    private static ErrorMsg instance = null;
    private List<Exception> errors;

    private ErrorMsg() {
        errors = new LinkedList<>();
    }

    public static ErrorMsg getInstance() {
        if (instance == null) {
            instance = new ErrorMsg();
        }
        return instance;
    }

    public int errorCount() {
        return errors.size();
    }

    public boolean hasErrors() {
        return errors.size() > 0;
    }

    public void addError(Exception e) {
        errors.add(e);
    }

    public List<Exception> getErrors() {
        return new LinkedList<>(errors);
    }

    public void flush() {
        errors = new LinkedList<>();
    }

    public void print() {
        for (Exception e : errors) {
            System.out.println(e.getMessage());
        }
    }

}
