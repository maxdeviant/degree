/**
 * CSC240
 * Dr. Richard Epstein
 * Assignment #4
 * 
 * @author Marshall Bowers
 */

package assignment;

import java.util.Scanner;

public class Application {
	static Scanner input = new Scanner(System.in);

	private static Set<Element> list = new Set<Element>();

	public static void main(String[] args) {
		menu();
	}

	/**
	 * Prompts the user if he wants to quit.
	 * 
	 * @return false if user does not want to quit, else returns true
	 */

	private static boolean getQuit() {
		System.out.println("Do you want to quit?\nY)es\nN)o");
		if (input.nextLine().toUpperCase().charAt(0) == 'N')
			return false;
		else
			return true;
	}

	/**
	 * Presents the user with a menu, prompts for input, and then executes the
	 * user's choice.
	 */

	private static void menu() {
		boolean validChoice = false;
		char menuChoice;
		String[] options = { "Add a Frozen Food product", "Add a Canned Food product",
				"Display names of all Frozen Food products", "Display names of all Canned Food products",
				"Display data for a Frozen Food product", "Display data for a Canned Food product",
				"Edit data for a Frozen Food Product", "Edit data for a Canned Food product", "Quit" };

		do {
			System.out.println("\nWholly Nutritious Foods Data Menu:");
			for (int i = 0; i < 9; i++)
				System.out.println((i + 1) + ") " + options[i]);

			System.out.print("Please select an option: ");
			menuChoice = input.nextLine().charAt(0);

			if (menuChoice <= '9' && menuChoice >= '0')
				validChoice = true;
			else
				System.out.println("\nSorry, that is not a valid choice. Try again.");

		} while (!validChoice);

		switch (menuChoice) {
		case '1':
			addFrozenFood();
			break;
		case '2':
			addCannedFood();
			break;
		case '3':
			displayFrozenNames();
			break;
		case '4':
			displayCannedNames();
			break;
		case '5':
			displayFrozenData();
			break;
		case '6':
			displayCannedData();
			break;
		case '7':
			editFrozenFood();
			break;
		case '8':
			editCannedFood();
			break;
		default:
			break;
		}

		if (menuChoice != '9')
			menu();
		else if (!getQuit())
			menu();
	}

	/**
	 * Menu 1): Add a new FrozenFood to the Set<Element> list.
	 */

	private static void addFrozenFood() {
		FrozenFood temp = new FrozenFood();
		temp.readIn();

		try {
			if (list.isMemberOf(temp))
				throw new DuplicateObjectException("This FrozenFood is already in the list.");

			list.add(temp);
			System.out.println("\nThis FrozenFood was added successfully!");
		} catch (DuplicateObjectException e) {
			System.out.println("FrozenFood not added.");
		}
	}

	/**
	 * Menu 2): Add a new CannedFood to the Set<Element> list.
	 */

	private static void addCannedFood() {
		CannedFood temp = new CannedFood();
		temp.readIn();

		try {
			if (list.isMemberOf(temp))
				throw new DuplicateObjectException("This CannedFood is already in the list.");

			list.add(temp);
			System.out.println("\nThis CannedFood was added successfully!");
		} catch (DuplicateObjectException e) {
			System.out.println("CannedFood not added.");
		}
	}

	/**
	 * Menu 3): Display the names of all FrozenFood products in the Set<Element>
	 * list.
	 */

	private static void displayFrozenNames() {
		// If list is empty, there can be no FrozenFoods in the list
		if (list.isEmpty())
			System.out.println("There are no FrozenFood products.");
		else {
			// Counter for number of FrozenFoods in the list
			int count = 0;
			for (int i = 0; i < list.size(); i++) {
				Element e = list.getCurrent();
				if (e.getClass().getName().contains("FrozenFood")) {
					System.out.println(((FrozenFood) e).getName());
					count++;
				}
			}
			// If the counter is still zero, no FrozenFoods were found
			if (count == 0)
				System.out.println("There are no FrozenFood products.");
		}
	}

	/**
	 * Menu 4): Display the names of all CannedFood products in the Set<Element>
	 * list.
	 */

	private static void displayCannedNames() {
		// If list is empty, there can be no CannedFoods in the list
		if (list.isEmpty())
			System.out.println("There are no CannedFood products.");
		else {
			// Counter for number of CannedFoods in the list
			int count = 0;
			for (int i = 0; i < list.size(); i++) {
				Element e = list.getCurrent();
				if (e.getClass().getName().contains("CannedFood")) {
					System.out.println(((CannedFood) e).getName());
					count++;
				}
			}
			// If the counter is still zero, no CannedFoods were found
			if (count == 0)
				System.out.println("There are no CannedFood products.");
		}
	}

	/**
	 * Menu 5): Display the data of a specified FrozenFood product in the
	 * Set<Element> list.
	 */

	private static void displayFrozenData() {
		System.out.print("Enter the name of a FrozenFood product: ");
		String name = input.nextLine().toUpperCase();
		FrozenFood temp = new FrozenFood(name);

		try {
			if (!list.isMemberOf(temp))
				throw new CannotFindException("This FrozenFood could not be found.");

			list.displayAnObject(new FrozenFood(name));
		} catch (CannotFindException e) {
			System.out.println("FrozenFood data not displayed.");
		}
	}

	/**
	 * Menu 6): Display the data of a specified CannedFood product in the
	 * Set<Element> list.
	 */

	private static void displayCannedData() {
		System.out.print("Enter the name of a CannedFood product: ");
		String name = input.nextLine().toUpperCase();
		CannedFood temp = new CannedFood(name);

		try {
			if (!list.isMemberOf(temp))
				throw new CannotFindException("This CannedFood could not be found.");

			list.displayAnObject(new CannedFood(name));
		} catch (CannotFindException e) {
			System.out.println("CannedFood data not displayed.");
		}
	}

	/**
	 * Menu 7): Edit the data of a specified FrozenFood product in the
	 * Set<Element> list.
	 */

	private static void editFrozenFood() {
		FrozenFood temp = new FrozenFood();
		temp.readIn();

		try {
			if (!list.isMemberOf(temp))
				throw new CannotEditException("This FrozenFood could not be found.");

			list.editAnObject(temp);
			System.out.println("\nThis FrozenFood was successfully replaced.");
		} catch (CannotEditException e) {
			System.out.println("FrozenFood not edited.");
		}
	}

	/**
	 * Menu 8): Edit the data of a specified CannedFood product in the
	 * Set<Element> list.
	 */

	private static void editCannedFood() {
		CannedFood temp = new CannedFood();
		temp.readIn();

		try {
			if (!list.isMemberOf(temp))
				throw new CannotEditException("This CannedFood could not be found.");

			list.editAnObject(temp);
			System.out.println("\nThis CannedFood was successfully replaced.");
		} catch (CannotEditException e) {
			System.out.println("CannedFood not edited.");
		}
	}
}
