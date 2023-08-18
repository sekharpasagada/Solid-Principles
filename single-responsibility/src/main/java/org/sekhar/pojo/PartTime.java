package org.sekhar.pojo;

public class PartTime extends Employee {

	public PartTime(String fullName, int monthlyIncome) {
        super(fullName, monthlyIncome);
        setNumberOfHours(20);
    }
}
