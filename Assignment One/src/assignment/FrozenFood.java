package assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class FrozenFood {
	private Scanner input = new Scanner(System.in);
	private String name;
	private String manufacturer;
	private String nutrients;
	
	public FrozenFood(String n, String m, String nu) {
		name = n;
		manufacturer = m;
		nutrients = nu;
	}
	
	public FrozenFood() {
		name = "";
		manufacturer = "";
		nutrients = "";
	}

	public String getName() {
		return name;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	
	public String getNutrients() {
		return nutrients;
	}
	
	/**
	 * Display the names of all frozen food products
	 * @param foodList
	 */
	public void displayFrozenFoodNames(ArrayList<FrozenFood> foodList) {
		for (FrozenFood i : foodList)
			System.out.println(i.getName());
	}

	/**
	 * Display all data for a specific frozen food product
	 * @param foodList
	 */
	public void displaySpecificFrozenFood(ArrayList<FrozenFood> foodList) {
		System.out.print("Enter the name of a specific frozen food product: ");
		String name = input.nextLine().toUpperCase();
		FrozenFood result = binarySearch(foodList, name, 0, foodList.size(), "Name");
		
		if (result != null) {
			System.out.println("\nName: " + result.getName());
			System.out.println("Manufacturer: " + result.getManufacturer());
			System.out.print("Nutrients: " + result.getNutrients());
		} else {
			System.out.println(name + " was not found.");
		}
	}
	
	/**
	 * Display the names of all frozen food products from a given manufacturer
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
			System.out.println("\n" + manufacturer + "makes these frozen foods: ");
			for (FrozenFood f : results) {
				System.out.println("  " + f.getName());
			}
		} else {
			System.out.println(manufacturer + " was not found.");
		}
	}

	/**
	 * Display the names of all products with a given top nutrient
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
			System.out.println("That nutrient was not found.");
		}
	}
	
	private FrozenFood binarySearch(ArrayList<FrozenFood> foodList, String key, int min, int max, String type) {
		if (max < min)
			return null;
		else {
			int mid = (min + max) / 2;
			
			switch(type) {
			case "Name":
					if (foodList.get(mid).getName().compareTo(key) > 0)
						return binarySearch(foodList, key, min, mid - 1, type);
					else if (foodList.get(mid).getName().compareTo(key) < 0)
						return binarySearch(foodList, key, mid + 1, max, type);
					else
						return foodList.get(mid);
			case "Manufacturer":
				if (foodList.get(mid).getManufacturer().compareTo(key) > 0)
					return binarySearch(foodList, key, min, mid - 1, type);
				else if (foodList.get(mid).getManufacturer().compareTo(key) < 0)
					return binarySearch(foodList, key, mid + 1, max, type);
				else
					return foodList.get(mid);
			case "Nutrients":
				if (foodList.get(mid).getNutrients().compareTo(key) > 0)
					return binarySearch(foodList, key, min, mid - 1, type);
				else if (foodList.get(mid).getNutrients().compareTo(key) < 0)
					return binarySearch(foodList, key, mid + 1, max, type);
				else
					return foodList.get(mid);
			default:
				return null;
			}
		}
	}
}
