package assignment;

@SuppressWarnings("serial")
public class CannotEditException extends Exception {
	public CannotEditException(String error) {
		System.out.println("\n" + error);
	}
}