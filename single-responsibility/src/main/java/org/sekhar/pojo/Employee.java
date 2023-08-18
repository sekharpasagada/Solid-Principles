package org.sekhar.pojo;

public abstract class Employee {

	private String lastName;
	private String firstName;
	private int monthlyIncome;
	private int numberOfHours;

	public Employee(String fullName, int monthlyIncome) {

		String[] name = fullName.split(" ");
		this.lastName = name[1];
		this.firstName = name[0];
		setMonthlyIncome(monthlyIncome);
	}

	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}

	public String getEmail() {
		return getFullName() + "@sekhar.org";
	}

	public void setMonthlyIncome(int monthlyIncome) {
		if (monthlyIncome <= 0) {
			throw new IllegalArgumentException("Monthly income must be positive");
		}
		this.monthlyIncome = monthlyIncome;
	}

	public void setNumberOfHours(int numberOfHours) {
		if (numberOfHours <= 0) {
			throw new IllegalArgumentException("Number of hours must be positive");
		}
		this.numberOfHours = numberOfHours;
	}

	public int getMonthlyIncome() {
		return this.monthlyIncome;
	}

	public int getNumberOfHours() {
		return this.numberOfHours;
	}
}
