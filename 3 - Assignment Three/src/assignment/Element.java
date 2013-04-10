/**
 * CSC240
 * Dr. Richard Epstein
 * Assignment #3
 * 
 * @author Dr. Richard Epstein
 */

package assignment;

/**
 * The Element class is introduced to illustrate the use of abstract classes. In
 * this revised version of the PersonSet class example, the Person class will
 * inherit from this abstract class. The purpose of the abstract class Element
 * is to introduce the "common class protocol" for all of its subclasses. That
 * common class protocol is introduced using abstract as well as fully
 * implemented methods. The abstract methods are: readIn display equals clone In
 * addition, the abstract class Element fully implements the getClassName
 * method.
 */

public abstract class Element {

	// Access method

	/**
	 * The getClassName method returns the name of the calling object's class.
	 * 
	 * @return the name of the calling object's class
	 */

	public String getClassName() {
		// Local data ...
		String resultStr;
		// Result of applying toString method to
		// the calling object
		int whereAt; // Where the @ symbol is in resultStr

		// Logic ...
		resultStr = this.toString();
		whereAt = resultStr.indexOf('@');
		resultStr = resultStr.substring(0, whereAt);
		whereAt = resultStr.indexOf('.');
		return resultStr.substring(whereAt + 1);
	}

	// Abstract methods readIn, display, equals and clone.
	// A direct subclass must implement these abstract methods
	// unless the direct subclass is itself declared "abstract"

	public abstract void readIn();

	public abstract void display();

	public abstract boolean equals(Element dobj);

	public abstract Element clone();
}
