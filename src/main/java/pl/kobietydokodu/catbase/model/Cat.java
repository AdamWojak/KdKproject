package pl.kobietydokodu.catbase.model;

import java.util.Date;

public class Cat {

	private String name;
	private Date dateOfBirth;
	private Float weight;
	private String ownerName;

	public String introduceYourself() {
		return "Cat " + name + ", born " + dateOfBirth + ", weight: " + weight + ", owner name: " + ownerName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

}