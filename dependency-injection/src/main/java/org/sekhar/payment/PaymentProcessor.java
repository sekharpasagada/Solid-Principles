package org.sekhar.payment;

import java.util.List;

import org.sekhar.notification.EmployeeNotifier;
import org.sekhar.persistence.EmployeeRepository;
import org.sekhar.pojo.Employee;

public class PaymentProcessor {

	
    private EmployeeRepository employeeRepository;
    private EmployeeNotifier employeeNotifier;

    public PaymentProcessor(EmployeeRepository employeeRepository,
                            EmployeeNotifier employeeNotifier){
        this.employeeRepository = employeeRepository;
        this.employeeNotifier = employeeNotifier;
    }

    public int sendPayments(){
        List<Employee> employees = this.employeeRepository.findAll();
        int totalPayments = 0;

        for(Employee employee : employees){
            totalPayments += employee.getMonthlyIncome();
            this.employeeNotifier.notify(employee);
        }

        return totalPayments;
    }
}
