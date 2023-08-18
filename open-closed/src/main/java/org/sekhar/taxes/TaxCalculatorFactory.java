package org.sekhar.taxes;

import org.sekhar.pojo.Employee;
import org.sekhar.pojo.FullTime;
import org.sekhar.pojo.Intern;
import org.sekhar.pojo.PartTime;

public class TaxCalculatorFactory {

	public static TaxCalculator create(Employee emp) {

		TaxCalculator taxCalculator;

		if (emp instanceof PartTime) {
			taxCalculator = new PartTimeTaxCalculator();
		} else if (emp instanceof FullTime) {
			taxCalculator = new FullTimeTaxCalculator();

		} else if (emp instanceof Intern) {
			taxCalculator = new InternTaxCalculator();
		} else {
			throw new IllegalArgumentException("Employee should be either Full time/Part time or Intern");
		}

		return taxCalculator;
	}
}
