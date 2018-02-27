package pl.kobietydokodu.catbase.model;

import java.util.Date;

public class Cat {

	String name;
	Date dateOfBirth;
	Float weight;
	String ownerName;

	public String introduceYourself() {
		return "Cat " + name + ", born " + dateOfBirth + ", weight: " + weight + ", owner name: " + ownerName;
	}

}