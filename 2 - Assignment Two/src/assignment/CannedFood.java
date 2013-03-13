/**
 * CSC240
 * Dr. Richard Epstein
 * Assignment #2
 * 
 * @author Marshall Bowers
 */

package assignment;

import java.util.Scanner;
import java.util.StringTokenizer;

public class CannedFood extends Element {
	// Class variable declaration
	private String name;
	private String manufacturer;
	private String nutrients;
	
	/**
	 * Creates a new CannedFood object with all blank fields.
	 */
	
	public CannedFood() {
		name = "";
		manufacturer = "";
		nutrients = "";
	}
	
	/**
	 * Creates a new CannedFood object whose fields are initialized to the given
	 * parameters.
	 * 
	 * @param name
	 * @param manufacturer
	 * @param nutrients
	 */
	
	public CannedFood(String name, String manufacturer, String nutrients) {
		this.name = name.toUpperCase();
		this.manufacturer = manufacturer.toUpperCase();
		this.nutrients = nutrients.toUpperCase();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getNutrients() {
		return nutrients;
	}

	public void setNutrients(String nutrients) {
		this.nutrients = nutrients;
	}

	public void readIn() {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter the name of the Canned Food: ");
		name = input.nextLine().toUpperCase();

		System.out.print("Enter the name of the manufacturer: ");
		manufacturer = input.nextLine().toUpperCase();

		System.out.print("Enter the number of nutrients for this food: ");
		int numNu = Integer.parseInt(input.nextLine());

		System.out.print("Enter the nutrients when prompted: \n");
		nutrients = "";

		for (int i = 0; i < numNu; i++) {
			System.out.print((i + 1) + ") ");
			nutrients += input.nextLine().toUpperCase();
			if (i != numNu - 1)
				nutrients += ", ";
		}

		input.close();
	}
	
	public void display() {
		System.out.println("Name: " + name);
		System.out.println("Manufacturer: " + manufacturer);
		StringTokenizer token = new StringTokenizer(nutrients.replace(',', ' '));
		while (token.hasMoreTokens()) {
			System.out.println("  " + token.nextToken());
		}
	}
	
	public boolean equals(Element dobj) {
		if (getName().equals(((CannedFood)dobj).getName()))
			return true;
		else
			return false;
	}
	
	public Element clone() {
		FrozenFood clone = new FrozenFood();
		
		clone.setName(getName());
		clone.setManufacturer(getManufacturer());
		clone.setNutrients(getNutrients());
		
		return clone;
	}
}
