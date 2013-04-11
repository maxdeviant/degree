package assignment;

@SuppressWarnings("serial")
public class DuplicateObjectException extends Exception {
	public DuplicateObjectException(String error) {
		System.out.println("\n" + error);
	}
}