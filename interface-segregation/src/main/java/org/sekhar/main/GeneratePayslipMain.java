package org.sekhar.main;

import java.time.Month;
import java.util.List;

import org.sekhar.documents.GeneratePayslip;
import org.sekhar.persistence.EmployeeRepository;
import org.sekhar.pojo.Employee;

public class GeneratePayslipMain {

	public static void main(String[] args) {

		EmployeeRepository repository = new EmployeeRepository();
		List<Employee> list = repository.findAll();

		for (Employee employee : list) {

			String content = (new GeneratePayslip(employee, Month.AUGUST)).toText().toUpperCase();
			System.out.println("Employee Payslip: " + content);
		}

	}

}
