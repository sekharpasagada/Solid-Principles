package org.sekhar.documents;

import java.time.Month;

import org.sekhar.pojo.Employee;

public class GeneratePayslip implements ExportableText {

	private String empFullName;
	private int empSalary;
	private Month month;

	public GeneratePayslip(Employee employee, Month month) {
		this.empFullName = employee.getFullName();
		this.empSalary = employee.getMonthlyIncome();
		this.month = month;

	}

	@Override
	public String toText() {
		StringBuilder sb = new StringBuilder();
		sb.append("MONTH: ").append(this.month);
		sb.append(System.lineSeparator());
		sb.append("NAME: ").append(this.empFullName);
		sb.append(System.lineSeparator());
		sb.append("INCOME: ").append(this.empSalary);
		sb.append(System.lineSeparator());

		return sb.toString();

	}

	public String getEmpFullName() {
		return empFullName;
	}

	public int getEmpSalary() {
		return empSalary;
	}

	public Month getMonth() {
		return month;
	}

}
