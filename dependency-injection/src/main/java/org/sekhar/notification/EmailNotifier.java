package org.sekhar.notification;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.sekhar.pojo.Employee;



public class EmailNotifier implements EmployeeNotifier {

	public void notify(Employee employee) {
		// Configure email server
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "465");

		Session session = Session.getInstance(prop, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("psekhar2007@gmail.com", "negrvgzryrnmpfnu");
			}

		});

		// Send actual email
		try {
			Message message = new MimeMessage(session);

			// to/from
			message.setFrom(new InternetAddress("payment@globomantics.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(employee.getEmail()));

			// subject
			message.setSubject("Salary Notification");

			// content
			String msg = "Salary sent; Value: $" + employee.getMonthlyIncome();
			MimeBodyPart mimeBodyPart = new MimeBodyPart();
			mimeBodyPart.setContent(msg, "text/html");
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(mimeBodyPart);
			message.setContent(multipart);

			// send and wait (mail server has limit)
			Transport.send(message);
			System.out.println("Notified " + employee.getEmail());
			Thread.sleep(3000);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}