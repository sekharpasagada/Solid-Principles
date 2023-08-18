package org.sekhar.persistence;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.sekhar.pojo.Employee;
import org.sekhar.pojo.FullTime;
import org.sekhar.pojo.PartTime;

public class EmployeeRepository {

	EmployeeSerializer serializer;
	List<Employee> employees = new ArrayList<Employee>();

	public EmployeeRepository() {
		Employee employee1 = new FullTime("Sekhar Pasagada", 10000);
		Employee employee2 = new FullTime("Anusha Mandadi", 12000);

		Employee employee3 = new PartTime("Dhanvith Pasagada", 500);
		Employee employee4 = new PartTime("Hassith Pasagada", 500);

		employees.add(employee1);
		employees.add(employee2);
		employees.add(employee3);
		employees.add(employee4);

	}

	public EmployeeRepository(EmployeeSerializer serializer) {
		this();
		this.serializer = serializer;
	}

	public Employee add(Employee e) {
		employees.add(e);
		return e;
	}

	public List<Employee> findAll() {
		return employees;
	}

	public void save(Employee employee) throws IOException {
		String serialize = serializer.serialize(employee);

		Path path = Paths.get(employee.getFullName().replace(" ", "_") + ".rec");
		Files.write(path, serialize.getBytes());
	}
}
