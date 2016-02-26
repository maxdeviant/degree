/**
 * CSC240
 * Dr. Richard Epstein
 * Assignment #1
 * 
 * @author Marshall Bowers
 */

package assignment;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FrozenFood {
	// Class variable declaration
	private Scanner input = new Scanner(System.in);
	private String name;
	private String manufacturer;
	private String nutrients;

	/**
	 * Creates a new FrozenFood object with all blank fields.
	 */
	public FrozenFood() {
		name = "";
		manufacturer = "";
		nutrients = "";
	}

	/**
	 * Creates a new FrozenFood object whose fields are initialized to the given
	 * parameters.
	 * 
	 * @param n
	 * @param m
	 * @param nu
	 */
	public FrozenFood(String n, String m, String nu) {
		name = n;
		manufacturer = m;
		nutrients = nu;
	}

	/**
	 * Returns the name of the FrozenFood.
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the manufacturer of the FrozenFood.
	 * 
	 * @return manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * Returns the nutrients of the FrozenFood.
	 * 
	 * @return nutrients
	 */
	public String getNutrients() {
		return nutrients;
	}

	/**
	 * Display the names of all FrozenFood products.
	 * 
	 * @param foodList
	 */
	public void displayFrozenFoodNames(ArrayList<FrozenFood> foodList) {
		System.out.println("\nFrozen Food Products: ");
		for (FrozenFood i : foodList)
			System.out.println("  " + i.getName());
	}

	/**
	 * Display all data for a specific FrozenFood product.
	 * 
	 * @param foodList
	 */
	public void displaySpecificFrozenFood(ArrayList<FrozenFood> foodList) {
		System.out.print("Enter the name of a specific frozen food product: ");
		String name = input.nextLine().toUpperCase();
		FrozenFood result = binarySearch(foodList, name, 0, foodList.size() - 1);

		if (result != null) {
			System.out.println("\nName: " + result.getName());
			System.out.println("Manufacturer: " + result.getManufacturer());
			StringTokenizer token = new StringTokenizer(result.getNutrients().replace(',', ' '));
			System.out.println("Nutrients: ");
			while (token.hasMoreTokens()) {
				System.out.println("  " + token.nextToken());
			}
		} else {
			System.out.println(name + " was not found.");
		}
	}

	/**
	 * Display the names of all FrozenFood products from a given manufacturer.
	 * 
	 * @param foodList
	 */
	public void displayFrozenFoodWManufacturer(ArrayList<FrozenFood> foodList) {
		System.out.print("Enter the name of a frozen food manufacturer: ");
		String manufacturer = input.nextLine().toUpperCase();
		ArrayList<FrozenFood> results = new ArrayList<FrozenFood>();

		for (FrozenFood f : foodList) {
			if (f.getManufacturer().equals(manufacturer))
				results.add(f);
		}

		if (results.size() > 0) {
			System.out.println("\n" + manufacturer + " makes these frozen foods: ");
			for (FrozenFood f : results) {
				System.out.println("  " + f.getName());
			}
		} else {
			System.out.println(manufacturer + " does not appear to make any frozen foods.");
		}
	}

	/**
	 * Display the names of all FrozenFood products with a given top nutrient.
	 * 
	 * @param foodList
	 */
	public void displayFrozenFoodWNutrient(ArrayList<FrozenFood> foodList) {
		System.out.print("Enter the name of a frozen food nutrient: ");
		String nutrient = input.nextLine().toUpperCase();
		ArrayList<FrozenFood> results = new ArrayList<FrozenFood>();

		for (FrozenFood f : foodList) {
			if (f.getNutrients().contains(nutrient))
				results.add(f);
		}

		if (results.size() > 0) {
			System.out.println("\nThese frozen foods contain " + nutrient + ": ");
			for (FrozenFood f : results) {
				System.out.println("  " + f.getName());
			}
		} else {
			System.out.println("No frozen foods contain " + nutrient);
		}
	}

	/**
	 * Searches the given list with a binary search until the item matching the
	 * key is found.
	 * 
	 * @param foodList
	 * @param key
	 * @param min
	 * @param max
	 * @return the FrozenFood object being searched for
	 */
	private FrozenFood binarySearch(ArrayList<FrozenFood> foodList, String key, int min, int max) {
		if (max < min)
			return null;
		else {
			int mid = min + ((max - min) / 2);

			if (foodList.get(mid).getName().compareTo(key) > 0)
				return binarySearch(foodList, key, min, mid - 1);
			else if (foodList.get(mid).getName().compareTo(key) < 0)
				return binarySearch(foodList, key, mid + 1, max);
			else
				return foodList.get(mid);
		}
	}
}