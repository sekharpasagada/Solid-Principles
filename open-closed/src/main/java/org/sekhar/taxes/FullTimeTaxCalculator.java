package org.sekhar.taxes;

import org.sekhar.pojo.Employee;

public class FullTimeTaxCalculator implements TaxCalculator {

	 private final int RETIREMENT_TAX_PERCENTAGE = 10;
	    private final int INCOME_TAX_PERCENTAGE = 16;
	    private final int BASE_HEALTH_INSURANCE = 100;
	
	@Override
	public double calculateTax(Employee employee) {
		
		double totalTax = BASE_HEALTH_INSURANCE+ (employee.getMonthlyIncome() * (INCOME_TAX_PERCENTAGE+RETIREMENT_TAX_PERCENTAGE) )/100;
		
		return totalTax;
	}

}
