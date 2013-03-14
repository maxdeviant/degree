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
	private String name;
	private String manufacturer;
	private String ingredients;

	private static Scanner input = new Scanner(System.in);

	/**
	 * Creates a new CannedFood object with all blank fields.
	 */

	public CannedFood() {
		name = "";
		manufacturer = "";
		ingredients = "";
	}

	/**
	 * Creates a new FrozenFood object with just a name.
	 * 
	 * @param name
	 */

	public CannedFood(String name) {
		this.name = name;
		manufacturer = "";
		ingredients = "";
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

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public void readIn() {
		System.out.print("Enter the name of the Canned Food: ");
		name = input.nextLine().toUpperCase();

		System.out.print("Enter the name of the manufacturer: ");
		manufacturer = input.nextLine().toUpperCase();

		System.out.print("Enter the number of ingredients for this food: ");
		int numNu = Integer.parseInt(input.nextLine());

		System.out.print("Enter the ingredients when prompted: \n");
		ingredients = "";

		for (int i = 0; i < numNu; i++) {
			System.out.print((i + 1) + ") ");
			ingredients += input.nextLine().toUpperCase();
			if (i != numNu - 1)
				ingredients += ", ";
		}
	}

	public void display() {
		System.out.println("Name: " + name);
		System.out.println("Manufacturer: " + manufacturer);
		System.out.println("Ingredients: ");
		StringTokenizer token = new StringTokenizer(ingredients.replace(',', ' '));
		while (token.hasMoreTokens()) {
			System.out.println("  " + token.nextToken());
		}
	}

	public boolean equals(Element dobj) {
		if (dobj.getClassName().equals("CannedFood")) {
			if (getName().equals(((CannedFood) dobj).getName()))
				return true;
			else
				return false;
		}

		if (dobj.getClassName().equals("FrozenFood")) {
			if (getName().equals(((FrozenFood) dobj).getName()))
				return true;
			else
				return false;
		}
		return false;
	}

	public Element clone() {
		CannedFood clone = new CannedFood();

		clone.setName(getName());
		clone.setManufacturer(getManufacturer());
		clone.setIngredients(getIngredients());

		return clone;
	}
}
