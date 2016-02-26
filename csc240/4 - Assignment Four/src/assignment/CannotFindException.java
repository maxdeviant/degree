package assignment;

@SuppressWarnings("serial")
public class CannotFindException extends Exception {
	public CannotFindException(String error) {
		System.out.println("\n" + error);
	}
}