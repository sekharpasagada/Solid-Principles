package org.sekhar.pojo;

public class Intern extends Employee {

	public Intern(String fullName, int monthlyIncome, int numberOfHours) {
		super(fullName, monthlyIncome);
		this.setNumberOfHours(numberOfHours);
	}
}
