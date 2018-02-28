package pl.kobietydokodu.catbase.model;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	static Scanner scan = new Scanner(System.in);

	static CatDAO catDao = new CatDAO();

	public static void main(String[] args) {

		Cat cat = new Cat();

		System.out.println("What is the Cat name?:");
		cat.setName(getUserInput());
		System.out.println("Who is the owner of this cat?");
		cat.setOwnerName(getUserInput());

		System.out.println("Ok! so for now, i know almost everythink about this cat! :-)");

		System.out.println("What is the weight of this cat?");
		Pattern weightPattern = Pattern.compile("([1-9]+\\.?[0-9]*)");
		do {
			Matcher matcher = weightPattern.matcher(getUserInput());
			if (matcher.matches()) {
				cat.setWeight(Float.parseFloat(matcher.group(1)));
			} else {
				System.out.println("It has to be a float value ");
			}
		} while (cat.getWeight() == null);

		System.out.println("When this cat was born?(YYYY-MM-DD)");
		Pattern birthPattern = Pattern.compile("([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))");
		while (cat.getDateOfBirth() == null) {
			Matcher matcher = birthPattern.matcher(getUserInput());
			if (matcher.matches()) {
				// try {
				cat.setDateOfBirth(LocalDate.parse(matcher.group()));
				// } catch (DateTimeParseException e) {
				// System.out.println("Error. Try again:");
				// }
			} else {
				System.out.println("Error with format (YYYY-MM-DD) Try again:");
			}
		}

		catDao.addCat(cat);

		System.out.println("Thank you, that is all information i need!");
		scan.close();
	}

	public static String getUserInput() {
		while (scan.hasNextLine()) {
			return scan.nextLine();
		}
		return "There is no more text.";
	}

}
