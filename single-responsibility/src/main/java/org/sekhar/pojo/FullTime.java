package org.sekhar.pojo;

public class FullTime extends Employee{

	public FullTime(String fullName, int monthlyIncome)  {
	
		super(fullName, monthlyIncome);
		setNumberOfHours(40);
	}
	
}
