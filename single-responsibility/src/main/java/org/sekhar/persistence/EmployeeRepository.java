package org.sekhar.persistence;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.sekhar.pojo.Employee;
import org.sekhar.pojo.FullTime;
import org.sekhar.pojo.PartTime;

public class EmployeeRepository {

	EmployeeSerializer serializer;
	List<Employee> employees;

	public EmployeeRepository(EmployeeSerializer serializer) {
	this.serializer = serializer;
	}
	
	public List<Employee> findAll() {
		Employee employee1 = new FullTime("Sekhar Pasagada", 10000);
		Employee employee2 = new FullTime("Anusha Mandadi", 12000);

		Employee employee3 = new PartTime("Dhanvith Pasagada", 500);
		Employee employee4 = new PartTime("Hassith Pasagada", 500);

		employees = Arrays.asList(employee1, employee2, employee3, employee4);

		return employees;
	}

	public void save(Employee employee) throws IOException {
		String serialize = serializer.serialize(employee);

		Path path = Paths.get(employee.getFullName().replace(" ", "_") + ".rec");
		Files.write(path, serialize.getBytes());
	}
}
