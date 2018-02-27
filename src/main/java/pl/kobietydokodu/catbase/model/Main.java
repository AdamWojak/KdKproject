package pl.kobietydokodu.catbase.model;

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
	}

	public static String getUserInput() {
		while (scan.hasNextLine()) {
			return scan.nextLine();
		}
		return "There is no more text.";
	}
}
