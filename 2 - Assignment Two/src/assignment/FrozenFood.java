/**
 * CSC240
 * Dr. Richard Epstein
 * Assignment #2
 * 
 * @author Marshall Bowers
 */

package assignment;

public abstract class FrozenFood extends Element {
	// Class variable declaration
	private String name;
	private String manufacturer;
	private String nutrients;
	
	public FrozenFood(String name, String manufacturer, String nutrients) {
		this.name = name;
		this.manufacturer = manufacturer;
		this.nutrients = nutrients;
	}
	
	public void readIn() {
		// TODO code in readIn()
	}
	
	public void display() {
		// TODO code in display()
	}
	
	public boolean equals(Element dobj) {
		// TODO code in equals(Element dobj)
		return false; // Temporary error fix
	}
	
	public Element clone() {
		// TODO code in clone()
		return null; // Temporary error fix
	}
}
