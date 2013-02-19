package assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
	// Class variable declaration
	private static Scanner input = new Scanner(System.in);
	private static FrozenFood FF = new FrozenFood();
	private static ArrayList<FrozenFood> origFoodList = new ArrayList<FrozenFood>();
	private static ArrayList<FrozenFood> foodList;

	public static void main(String[] args) {
		// Fill origFoodList with the FrozenFood data provided by the user
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

			// Adds a newly created FrozenFood object to origFoodList
			origFoodList.add(new FrozenFood(name.toUpperCase(), manufacturer
					.toUpperCase(), nutrients.toUpperCase()));
		} while (!getQuit());

		// Creates a new FrozenFood ArrayList equal in size to origFoodList
		foodList = new ArrayList<FrozenFood>(origFoodList.size());
		// Copies the data from origFoodList into foodList
		for (FrozenFood i : origFoodList)
			foodList.add(i);

		// Sorts the FrozenFood ArrayList using a Bubble Sort
		foodList = bubbleSort(foodList);

		// Presents a menu with options for the user
		menu();
	}

	/**
	 * Prompts the user if he wants to quit.
	 * 
	 * @return false if user wants to quit, else returns true
	 */
	private static boolean getQuit() {
		System.out.println("Do you want to quit?\nY)es\nN)o");
		if (input.nextLine().toUpperCase().charAt(0) == 'N')
			return false;
		else
			return true;
	}

	/**
	 * Sorts the contents of the FrozenFood ArrayList via a bubble sort.
	 * 
	 * @param list
	 * @return sorted list of FrozenFood
	 */
	private static ArrayList<FrozenFood> bubbleSort(ArrayList<FrozenFood> list) {
		int num = list.size();

		do {
			int newNum = 0;
			for (int i = 1; i <= num - 1; i++) {
				String stringA = list.get(i - 1).getName();
				String stringB = list.get(i).getName();
				if (stringA.compareTo(stringB) > 0) {
					FrozenFood temp = list.get(i);
					list.set(i, list.get(i - 1));
					list.set(i - 1, temp);
					newNum = i;
				}
			}
			num = newNum;
		} while (num != 0);

		return list;
	}

	/**
	 * Presents the user with a menu, prompts for input, and then executes the
	 * user's choice
	 */
	private static void menu() {
		boolean wantsToQuit = false;
		boolean validChoice = false;
		char menuChoice;
		String[] options = {
				"Display the names of all frozen food products",
				"Display all data for a specific frozen food product",
				"Display the names of all frozen food products from a given manufacturer",
				"Display the names of all products with a given top nutrient",
				"Quit the program" };

		do {
			System.out.println("\n\nMenu:");
			for (int i = 0; i < 5; i++)
				System.out.println((i + 1) + ") " + options[i]);

			System.out.print("Please select an option: ");
			menuChoice = input.nextLine().charAt(0);
			if (menuChoice <= '5' && menuChoice >= '0')
				validChoice = true;
			else
				System.out.println("Sorry, that is not a valid choice. Try again.");

		} while (!validChoice);

		switch (menuChoice) {
		case '1':
			FF.displayFrozenFoodNames(foodList);
			break;
		case '2':
			FF.displaySpecificFrozenFood(foodList);
			break;
		case '3':
			FF.displayFrozenFoodWManufacturer(foodList);
			break;
		case '4':
			FF.displayFrozenFoodWNutrient(foodList);
			break;
		default:
			break;
		}
		if (!wantsToQuit && menuChoice != '5')
			menu();
		else {
			wantsToQuit = getQuit();
			if (!wantsToQuit)
				menu();
		}
	}
}