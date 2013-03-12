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
			FrozenFood tempFrozen = new FrozenFood();
			tempFrozen.readIn();
			list.add(tempFrozen);
			break;
		case '2':
			CannedFood tempCanned = new CannedFood();
			tempCanned.readIn();
			list.add(tempCanned);
			break;
		case '3':
			for (int i = 0; i < list.size(); i++)
				if (list.getCurrent().getClassName().equals("FrozenFood"))
					((FrozenFood)list.getCurrent()).getName();
				else if (i == list.size())
					System.out.println("There are no FrozenFood products.");
			break;
		case '4':
			for (int i = 0; i < list.size(); i++)
				if (list.getCurrent().getClassName().equals("CannedFood"))
					((CannedFood)list.getCurrent()).getName();
				else if (i == list.size())
					System.out.println("There are no CannedFood products.");
			break;
		case '5':
			// TODO implement menu choice 5
			break;
		case '6':
			// TODO implement menu choice 6
			break;
		case '7':
			// TODO implement menu choice 7
			break;
		case '8':
			// TODO implement menu choice 8
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
}
