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
		
	}
	
	public void display() {
		
	}
	
	public boolean equals(Element dobj) {
		return false;
	}
	
	public Element clone() {
		return null;	
	}
}
