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
		// TODO implement readIn()
	}
	
	public void display() {
		// TODO implement display()
	}
	
	public boolean equals(Element dobj) {
		// TODO implement equals(Element dobj)
		return false; // Temporary error fix
	}
	
	public Element clone() {
		// TODO implement clone()
		return null; // Temporary error fix
	}
}
