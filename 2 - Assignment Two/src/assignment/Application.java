package assignment;

import java.util.Scanner;
import assignment.*;

public class Application {
	private static Scanner input = new Scanner(System.in);
	
	private static ElementSet list = new ElementSet();

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
	 * user's choice
	 */
	
	private static void menu() {
		boolean validChoice = false;
		char menuChoice;
		String[] options = { "Add a Frozen Food product",
				"Add a Canned Food product",
				"Display names of all Frozen Food products",
				"Display names of all Canned Food products",
				"Display data for a Frozen Food product",
				"Display data for a Canned Food product",
				"Edit data for a Frozen Food Product",
				"Edit data for a Canned Food product", "Quit" };

		do {
			System.out.println("\nWholly Nutritious Foods Data Menu:");
			for (int i = 0; i < 9; i++)
				System.out.println((i + 1) + ") " + options[i]);

			System.out.print("Please select an option: ");
			menuChoice = input.nextLine().charAt(0);
			if (menuChoice <= '9' && menuChoice >= '0')
				validChoice = true;
			else
				System.out
						.println("Sorry, that is not a valid choice. Try again.");

		} while (!validChoice);

		switch (menuChoice) {
		case '1':
			menuOne();
			break;
		case '2':
			menuTwo();
			break;
		case '3':
			menuThree();
			break;
		case '4':
			menuFour();
			break;
		case '5':
			menuFive();
			break;
		case '6':
			menuSix();
			break;
		case '7':
			menuSeven();
			break;
		case '8':
			menuEight();
			break;
		default:
			break;
		}

		if (menuChoice != '9')
			menu();
		else
			if (!getQuit())
				menu();
	}
	
	private static void menuOne() {
		FrozenFood temp = new FrozenFood();
		temp.readIn();
		list.add(temp);
	}
	
	private static void menuTwo() {
		CannedFood temp = new CannedFood();
		temp.readIn();
		list.add(temp);
	}
	
	private static void menuThree() {
		for (int i = 0; i < list.size(); i++)
			if (list.getCurrent().getClassName().equals("FrozenFood"))
				((FrozenFood)list.getCurrent()).getName();
			else if (i == list.size())
				System.out.println("There are no FrozenFood products.");
	}
	
	private static void menuFour() {
		for (int i = 0; i < list.size(); i++) {
			if (list.getCurrent().getClassName().equals("CannedFood"))
				((CannedFood)list.getCurrent()).getName();
			else if (i == list.size())
				System.out.println("There are no CannedFood products.");
		}
	}
	
	private static void menuFive() {
		System.out.print("Enter the name of a FrozenFood product: ");
		String name = input.nextLine();
		FrozenFood temp = new FrozenFood(name, "", "");
		if (list.isMemberOf(temp))
			list.displayAnObject(temp);
	}
	
	private static void menuSix() {
		System.out.print("Enter the name of a CannedFood product: ");
		String name = input.nextLine();
		CannedFood temp = new CannedFood(name, "", "");
		if (list.isMemberOf(temp))
			list.displayAnObject(temp);
	}
	
	private static void menuSeven() {
		System.out.print("Enter the name of a FrozenFood product: ");
		String name = input.nextLine();
		FrozenFood temp = new FrozenFood(name, "", "");
		if (list.isMemberOf(temp))
			list.editAnObject(temp);
	}
	
	private static void menuEight() {
		System.out.print("Enter the name of a FrozenFood product: ");
		String name = input.nextLine();
		FrozenFood temp = new FrozenFood(name, "", "");
		if (list.isMemberOf(temp))
			list.editAnObject(temp);
	}
}
