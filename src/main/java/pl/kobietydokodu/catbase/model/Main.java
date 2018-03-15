package pl.kobietydokodu.catbase.model;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		menu();

	}

	public static void menu() {
		String inputValue;
		do {
			System.out.println("Menu:");
			System.out.println("1 - add Cat.");
			System.out.println("2 - show all cats.");
			System.out.println("x - close program");

			inputValue = checkedUserInput();

			if (inputValue.equals("1")) {
				CatDAO.addCat();
			} else if (inputValue.equals("2")) {
				CatDAO.showCats(CatDAO.cats);
			}

		} while (!inputValue.equalsIgnoreCase("x"));

		System.out.println("The end of the program");
		scan.close();
	}

	public static String getUserInput() {
		// while (scan.hasNextLine()) {
		return scan.nextLine().trim();
		// }
		// return "There is no text";
	}

	public static String checkedUserInput() {
		String correctInput = null;
		Pattern menuPattern = Pattern.compile("1|2|x");
		while (correctInput == null) {
			Matcher matcher = menuPattern.matcher(getUserInput());
			if (matcher.matches()) {
				correctInput = matcher.group();
			} else {
				System.out.println("Wrong value");
			}
		}

		return correctInput;
	}

}
