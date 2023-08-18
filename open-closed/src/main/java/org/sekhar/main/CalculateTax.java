package org.sekhar.main;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import org.sekhar.logging.ConsoleLogger;
import org.sekhar.persistence.EmployeeRepository;
import org.sekhar.persistence.EmployeeSerializer;
import org.sekhar.pojo.Employee;
import org.sekhar.pojo.Intern;
import org.sekhar.taxes.TaxCalculator;
import org.sekhar.taxes.TaxCalculatorFactory;

public class CalculateTax {

	public static void main(String[] args) {

		ConsoleLogger logger = new ConsoleLogger();
		EmployeeSerializer employeeSerializer = new EmployeeSerializer();
		EmployeeRepository employeeRepository = new EmployeeRepository(employeeSerializer);

		Employee emp1 = new Intern("Praveen M", 12000, 25);
		employeeRepository.add(emp1);

		List<Employee> empList = employeeRepository.findAll();

		Locale locale = new Locale("en", "IN");
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

		double totalTaxes = 0;
		for (Employee employee : empList) {
			TaxCalculator tax = TaxCalculatorFactory.create(employee);
			double empTax = tax.calculateTax(employee);
			String formattedTax = currencyFormatter.format(empTax);
			logger.writeInfo("Employee : " + employee.getFullName() + " Tax:" + formattedTax);
			totalTaxes += empTax;
		}
		logger.writeInfo("Total taxes = " + currencyFormatter.format(totalTaxes));

	}

}
