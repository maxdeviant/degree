package assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
	// Variable declaration
	private static Scanner input = new Scanner(System.in);
	private static FrozenFood FF = new FrozenFood();
	private static ArrayList<FrozenFood> origFoodList = new ArrayList<FrozenFood>();
	private static ArrayList<FrozenFood> foodList;
	private static int numFF = 0;
	
	public static void main(String[] args) {
		// Fill origFoodList with the FrozenFood data
		do {
			System.out.print("Enter the name of the frozen food: ");
			String name = input.nextLine();
			
			System.out.print("Enter the name of the manufacturer: ");
			String manufacturer = input.nextLine();
			
			System.out.print("Enter the number of nutrients for this food: ");
			int numNu = Integer.parseInt(input.nextLine());
			
			System.out.print("Enter the nutrients when prompted: \n");
			String nutrients = "";
			for (int i = 0; i < numNu; i++) {
				System.out.print((i + 1) + ") ");
				nutrients += input.nextLine();
				if (i != numNu - 1)
					nutrients += ", ";
			}
			
			origFoodList.add(new FrozenFood(name.toUpperCase(), manufacturer.toUpperCase(), nutrients.toUpperCase()));
			numFF++;
		} while (!getQuit());
		
		foodList = new ArrayList<FrozenFood>(numFF);
		for (FrozenFood i : origFoodList)
			foodList.add(i);
		
		// Debugging code
		System.out.println("Unsorted: ");
		for (FrozenFood i : foodList)
			System.out.println(i.getName());
		
		foodList = bubbleSort(foodList);
		
		// Debugging code
		System.out.println("Sorted: ");
		for (FrozenFood i : foodList)
			System.out.println(i.getName());
		
		menu();
	}
	
	private static boolean getQuit() {
		System.out.println("Do you want to quit?\nY)es\nN)o");
		if (input.nextLine().toUpperCase().charAt(0) == 'N')
			return false;
		else
			return true;
	}
	
	private static ArrayList<FrozenFood> bubbleSort(ArrayList<FrozenFood> list) {
		int num = list.size();
		boolean swapped = false;
		
		do {
			for (int i = 1; i <= num - 1; i++) {
				String item1 = list.get(i - 1).getName();
				String item2 = list.get(i).getName();
				//System.out.println(item1 + " " + item2);
				if (item1.compareTo(item2) > 0) {
					FrozenFood temp = list.get(i);
					list.set(i, list.get(i - 1));
					list.set(i - 1, temp);
					swapped = true;
				}
			}
			num -= 1;
		} while (!swapped);
		
		return list;
	}
	
	private static void menu() {
		boolean wantsToQuit = false;
		boolean validChoice = false;
		int menuChoice;
		String[] options = { "Display the names of all frozen food products",
				"Display all data for a specific frozen food product",
				"Display the names of all frozen food products from a given manufacturer",
				"Display the names of all products with a given top nutrient",
				"Quit the program" };

		do {
			for (int i = 0; i < 5; i++)
				System.out.println((i + 1) + ") " + options[i]);
			
			System.out.print("Please select an option: ");
			menuChoice = Integer.parseInt(input.nextLine());
			if (menuChoice <= 5 && menuChoice >= 0)
				validChoice = true;
			else
				System.out.println("Sorry, that is not a valid choice. Try again.");
			
		} while (!validChoice);
		
		switch (menuChoice) {
		case 1:
			FF.displayFrozenFoodNames(foodList);
			break;
		case 2:
			FF.displaySpecificFrozenFood(foodList);
			break;
		case 3:
			FF.displayFrozenFoodWManufacturer(foodList);
			break;
		case 4:
			FF.displayFrozenFoodWNutrient(foodList);
			break;
		default:
			if (!wantsToQuit && menuChoice != 5)
				menu();
			else {
				wantsToQuit = getQuit();
				if (!wantsToQuit)
					menu();
			}
			break;
		}
	}
}
