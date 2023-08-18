package org.sekhar.main;

import java.util.List;

import org.sekhar.logging.ConsoleLogger;
import org.sekhar.persistence.EmployeeRepository;
import org.sekhar.persistence.EmployeeSerializer;
import org.sekhar.pojo.Employee;

public class SaveEmployee {

	public static void main(String[] args) {

		ConsoleLogger logger = new ConsoleLogger();
		EmployeeSerializer serializer = new EmployeeSerializer();
		EmployeeRepository empRepo = new EmployeeRepository(serializer);

		List<Employee> empList = empRepo.findAll();

		for (Employee employee : empList) {
			try {
				empRepo.save(employee);
				logger.writeInfo("Saved employee " + employee.toString());
			} catch (Exception e) {
				logger.writeError("Error saving employee", e);
			}

		}

	}

}
