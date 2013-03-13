/**
 * @author Dr. Richard Epstein
 */

package assignment;

/**
 * ElementSet is a revised version of the PersonSet class. ElementSet
 * illustrates that we can use an array whose base type is an abstract class. In
 * this case the base type is Element.
 * 
 * Very little in the PersonSet class needed to be changed because of this.
 * However, the getCurrent() and add() methods are now much more general since
 * they do not make any assumption about the kinds of objects stored in the
 * ElementSet.
 */

public class ElementSet {
	// Fields ...
	private Element[] theList; // Will reference an array of objects
								// from the subclasses of the abstract
								// class, Element
	private int currentIndex; // Index of current element in the set
	private int currentSize; // Number of objects currently in the list
	private final int MAXSETSIZE = 100;

	// Maximum number of objects that can be
	// in an ElementSet.

	// Constructor ...

	/**
	 * The ElementSet constructor sets up an array with MAXSETSIZE-many cells to
	 * reference objects from the subclasses of Element. It also initializes
	 * currentIndex and currentSize.
	 */

	public ElementSet() {
		theList = new Element[MAXSETSIZE];
		currentIndex = -1;
		currentSize = 0;
	}

	// Test methods

	/**
	 * The isMemberOf method tests to see if the parameter, anElement, is
	 * already a member of the ElementSet. Note that anElement can reference
	 * either a Person, a Student, or any subclass (direct or indirect) of the
	 * Element class.
	 * 
	 * @param anElement
	 *            the object being checked for membership in the set
	 * @return true if anElement is already in the set and false
	 */

	public boolean isMemberOf(Element anElement) {
		// Local data ...
		String paramClass = anElement.getClassName();
		String currClass;

		// Logic ...
		for (int i = 0; i < currentSize; i++) {
			currClass = theList[i].getClassName();

			// Only compare anElement against those objects
			// that belong to anElement's class
			if (currClass.equals(paramClass)) {
				if (theList[i].equals(anElement)) {
					return true;
				}
			}
		}

		// This object was not found in the set
		return false;
	}

	/**
	 * The isFull method returns true if the calling object is full and false
	 * otherwise.
	 * 
	 * @return true if the calling object is full to capacity and false
	 *         otherwise.
	 */

	public boolean isFull() {
		return currentSize == MAXSETSIZE;
	}

	/**
	 * The isEmpty method returns true if the calling object is empty and false
	 * otherwise.
	 * 
	 * @return true if the calling object is empty and false otherwise.
	 */

	public boolean isEmpty() {
		return currentSize == 0;
	}

	// Access methods

	/**
	 * The size method returns the number of objects currently in the set.
	 * 
	 * @return the value of currentSize
	 */

	public int size() {
		return currentSize;
	}

	/**
	 * The getCurrent() method returns a reference to the current object in the
	 * set. Note the pre-condition. This method should only be called if the set
	 * is not empty. The method advances currentIndex to the next object to set
	 * up for the next call to getCurrent. If getCurrent returns a copy of the
	 * last object, currentIndex is reset to 0. Pre: currentIndex is not -1
	 * (which can only occur if currentSize is not 0).
	 * 
	 * @return copy of the current object
	 */

	public Element getCurrent() {
		// Local data ...
		int saveIndex = currentIndex;

		// Logic ...
		if (currentIndex == currentSize - 1) {
			// Recycle to beginning of list
			currentIndex = 0;
		} else {
			// Advance currentIndex to next object
			currentIndex++;
		}

		// Return a reference to a clone of the current object
		return theList[saveIndex].clone();
	}

	// Mutator methods ...

	/**
	 * The add method adds a reference to the parameter object to the set if the
	 * the set is not full and if the parameter object is not already in the
	 * set. The method returns 1 if the add was successful, 0 if the set is full
	 * and -1 if the object is already in the set.
	 * 
	 * @param anElement
	 *            the object we will try to add
	 * @return 1 for success, 0 for no more room, and -1 for duplicate object
	 */

	public int add(Element anElement) {
		// Logic ...
		if (currentSize == MAXSETSIZE) {
			return 0; // set is full
		} else if (this.isMemberOf(anElement)) {
			return -1; // it's already in there
		}

		// We will add a clone of anElement to
		// the set.
		theList[currentSize] = anElement.clone();

		// Increment currentSize.
		currentSize++;

		// Set currentIndex to object we just added if it was the
		// first object in the set.
		if (currentSize == 1)
			currentIndex = 0;

		// We succeeded.
		return 1;
	}

	/**
	 * The clear method resets the set to the empty set.
	 */

	public void clear() {
		// Clean up the memory associated with this object
		// while it is still in use.
		for (int i = 0; i < currentSize; i++) {
			theList[i] = null;
		}

		// Reset currentSize and currentIndex to empty set
		// values.
		currentIndex = -1;
		currentSize = 0;
	}

	// The display method

	/**
	 * The display method displays all of the objects in the set using
	 * polymorphism in a powerful way.
	 */

	public void display() {
		if (currentSize == 0) {
			System.out.println("There are no objects in the set. ");
		} else {
			System.out.println("Here are the objects in the set: \n");
			for (int i = 0; i < currentSize; i++) {
				theList[i].display();
				System.out.println("\n");
			}
		}
	}

	public boolean displayAnObject(Element anObject) {
		for (int i = 0; i < currentSize; i++) {
			Element e = getCurrent();
			String className = e.getClassName();
			if (className.equals("FrozenFood")) {
				if (((FrozenFood)e).equals(anObject)) {
					e.display();
					return true;
				}	
			} else if (className.equals("CannedFood")) {
				if (((CannedFood)e).equals(anObject)) {
					e.display();
					return true;
				}	
			}
		}
		return false;
	}

	public boolean editAnObject(Element editedObject) {
		for (int i = 0; i < currentSize; i++) {
			Element e = getCurrent();
			String className = e.getClassName();
			if (className.equals("FrozenFood")) {
				if (((FrozenFood)e).equals(editedObject)) {
					if (((FrozenFood)e).equals(editedObject)) {
						theList[i] = editedObject;
						return true;
					}	
				}	
			} else if (className.equals("CannedFood")) {
				if (((FrozenFood)e).equals(editedObject)) {
					if (((CannedFood)e).equals(editedObject)) {
						theList[i] = editedObject;
						return true;
					}	
				}	
			}
		}
		return false;
	}
}
