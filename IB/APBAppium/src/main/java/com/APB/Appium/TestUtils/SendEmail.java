package com.APB.Appium.TestUtils;

import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.poi.poifs.nio.FileBackedDataSource;

import javax.activation.*;



public class SendEmail {
	
	public static void sendReportInEmail(final String from, final String password, String to, String subject, String body)
	{/*
		Properties props= System.getProperties();
		
		//System.out.println(props);
		
		String host = "smtp.gmail.com";

		props.put("mail.smtp.starttls.enable", "true");

		props.put("mail.smtp.host", host);

		props.put("mail.smtp.user", from);

		props.put("mail.smtp.password", password);

		props.put("mail.smtp.port", "587");

		props.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(props);
		
		//System.out.println(session);

		MimeMessage message = new MimeMessage(session);
		
		
		try
		{
			//Set Address
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			//Set Subject
			message.setSubject(subject);
			message.setText(body);
			
			BodyPart objMessagePart = new MimeBodyPart();
			objMessagePart.setText("Please Find the Attached Automation Suite Report");
			
			Multipart multipart = new MimeMultipart();
			
			multipart.addBodyPart(objMessagePart);
			
			objMessagePart = new MimeBodyPart();
			
			
			//Set the path of Extent Report 
			
			String filename= "D:\\eclipse-workspace\\APBAppium\\extentreport.html";
			
			
			//Create data source and pass the filename
			DataSource source = new FileDataSource(filename);
			
			//set the handler
			
			objMessagePart.setDataHandler(new DataHandler(source));
			
			//set the file
			
			objMessagePart.setFileName(filename);
			
			multipart.addBodyPart(objMessagePart);
			
			message.setContent(multipart);
			
			Transport transport = session.getTransport("smtp");
			
			transport.connect(host, from, password);
			
			transport.send(message, message.getAllRecipients());
			
			
			transport.close();
			
		}catch(AddressException  e)
		{
			e.printStackTrace();
		}catch (MessagingException me) 
		{

			me.printStackTrace();
		}*/
		
		Properties props = new Properties();
	    props.put("mail.smtp.auth", true);
	    props.put("mail.smtp.starttls.enable", true);
	    props.put("mail.smtp.host", "10.56.139.57");
	    props.put("mail.smtp.port", "25");

	    Session session = Session.getInstance(props,
	            new javax.mail.Authenticator() {
	                protected PasswordAuthentication getPasswordAuthentication() {
	                    return new PasswordAuthentication(from, password);
	                }
	            });

	    try {

	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress(from));
	        message.setRecipients(Message.RecipientType.TO,
	                InternetAddress.parse(to));
	        message.setSubject(subject);
	        message.setText(body);
	        
	        MimeBodyPart messageBodyPart = new MimeBodyPart();

	        Multipart multipart = new MimeMultipart();

	        messageBodyPart = new MimeBodyPart();
	        String file = "path of file to be attached";
	        String fileName = "attachment name";
	        DataSource source = new FileDataSource(file);
	        messageBodyPart.setDataHandler(new DataHandler(source));
	        messageBodyPart.setFileName(fileName);
	        multipart.addBodyPart(messageBodyPart);

	        message.setContent(multipart);

	        System.out.println("Sending");

	        Transport.send(message);

	        System.out.println("Done");

	    } catch (MessagingException e) {
	        e.printStackTrace();
	    }
	}
}
