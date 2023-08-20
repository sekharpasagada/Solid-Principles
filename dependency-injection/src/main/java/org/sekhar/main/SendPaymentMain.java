package org.sekhar.main;

import org.sekhar.notification.EmailNotifier;
import org.sekhar.notification.EmployeeNotifier;
import org.sekhar.payment.PaymentProcessor;
import org.sekhar.persistence.EmployeeRepository;

public class SendPaymentMain {

	public static void main(String[] args) {
		
		EmployeeRepository employeeRepository = new EmployeeRepository();
		  EmployeeNotifier employeeNotifier = new EmailNotifier();
	        PaymentProcessor paymentProcessor = new PaymentProcessor(
	                employeeRepository,
	                employeeNotifier);

	        int totalPayments = paymentProcessor.sendPayments();
	        System.out.println("Total payments " + totalPayments);
	}
	
}
