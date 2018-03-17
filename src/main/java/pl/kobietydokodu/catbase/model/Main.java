package pl.kobietydokodu.catbase.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	static Scanner scan = new Scanner(System.in);

	static CatDAO catDao = new CatDAO();

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
				addCat();
			} else if (inputValue.equals("2")) {
				showCats();
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

	public static void addCat() {

		Cat cat = new Cat();

		System.out.println("What is the Cat name?:");
		cat.setName(getUserInput());
		System.out.println("Who is the owner of this cat?");
		cat.setOwnerName(getUserInput());

		
		Pattern birthPattern = Pattern.compile("([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))");
		do {
			System.out.println("When this cat was born?(YYYY-MM-DD)");
			Matcher matcher = birthPattern.matcher(getUserInput());
			if (matcher.matches()) {
				cat.setDateOfBirth(LocalDate.parse(matcher.group()));
			} else {
				System.out.println("Error with format (YYYY-MM-DD) Try again:");
			}
		} while (cat.getDateOfBirth() == null);

		
		
		Pattern weightPattern = Pattern.compile("([1-9]+\\.?[0-9]*)");
		do {
			System.out.println("What is the weight of this cat?");
			Matcher matcher = weightPattern.matcher(Main.getUserInput());
			if (matcher.matches()) {
				cat.setWeight(Float.parseFloat(matcher.group(1)));
			} else {
				System.out.println("It has to be a float value ");
			}
		} while (cat.getWeight() == null);

	
		System.out.println("Thank you, that is all information i need!");


		catDao.addCat(cat);
		System.out.println("Cat added.");

	}

	public static void showCats() {
		
		for (Cat cat : catDao.getCats()) {
//			System.out.println(cat.introduceYourself());
			System.out.println(cat.getName()+" owner: " + cat.getOwnerName());
		}
	}

}
