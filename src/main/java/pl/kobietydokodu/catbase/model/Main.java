package pl.kobietydokodu.catbase.model;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		Cat cat = new Cat();

		System.out.println("What is the Cat name?:");
		cat.setName(getUserInput());
		System.out.println("Who is the owner of this cat?");
		cat.setOwnerName(getUserInput());

		System.out.println("Ok! so for now, i know almost everythink about this cat! :-)");

		do {
			System.out.println("What is the weight of this cat?");
			try {
				cat.setWeight(Float.parseFloat(getUserInput()));
			} catch (NumberFormatException e) {
				System.out.println("It has to be a float value");
			}
		} while (cat.getWeight() == null);

		while (cat.getDateOfBirth() == null) {
			System.out.println("When this cat was born?(YYYY-MM-DD)");
			try {
				cat.setDateOfBirth(LocalDate.parse(getUserInput()));
			} catch (DateTimeParseException e) {
				System.out.println("Some error with format");
			}
		}

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
