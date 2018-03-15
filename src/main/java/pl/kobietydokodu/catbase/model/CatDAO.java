package pl.kobietydokodu.catbase.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CatDAO {

	static Scanner scan = new Scanner(System.in);

	static List<Cat> cats = new ArrayList<Cat>();

	public static void addCat() {

		Cat cat = new Cat();

		System.out.println("What is the Cat name?:");
		cat.setName(Main.getUserInput());
		System.out.println("Who is the owner of this cat?");
		cat.setOwnerName(Main.getUserInput());

//		System.out.println("Ok! so for now, i know almost everythink about this cat! :-)");
//
//		System.out.println("What is the weight of this cat?");
//		Pattern weightPattern = Pattern.compile("([1-9]+\\.?[0-9]*)");
//		do {
//			Matcher matcher = weightPattern.matcher(Main.getUserInput());
//			if (matcher.matches()) {
//				cat.setWeight(Float.parseFloat(matcher.group(1)));
//			} else {
//				System.out.println("It has to be a float value ");
//			}
//		} while (cat.getWeight() == null);
//
//		System.out.println("When this cat was born?(YYYY-MM-DD)");
//		Pattern birthPattern = Pattern.compile("([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))");
//		while (cat.getDateOfBirth() == null) {
//			Matcher matcher = birthPattern.matcher(Main.getUserInput());
//			if (matcher.matches()) {
//				cat.setDateOfBirth(LocalDate.parse(matcher.group()));
//			} else {
//				System.out.println("Error with format (YYYY-MM-DD) Try again:");
//			}
//		}

		System.out.println("Thank you, that is all information i need!");
		scan.close();

		cats.add(cat);
		System.out.println("Cat added.");

	}

	public static void showCats(List<Cat> cats) {
		for (Cat cat : cats) {
			System.out.println(cat.introduceYourself());
		}
	}

	// public static String getUserInput() {
	// return scan.nextLine().trim();
	// }

}
