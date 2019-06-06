package com.APBCBS.performancereport.Testcases;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.APBCBS.performancereport.TestUtils.DBConnectionUtil;
import com.APBCBS.performancereport.TestUtils.ExcelCreation;
import com.APBCBS.performancereport.TestUtils.PropertySetup;



public class APIDailyPerfor {
	
	public static ExcelCreation excelCreate = new ExcelCreation();
	public static DBConnectionUtil dbConnection = new DBConnectionUtil();
	public static PropertySetup propertysetup = new PropertySetup();	
	public static  FileOutputStream fileOut =null;
	//public static String excelCreationFilePath = "D://Daily_CBS_Performance";
	public static String excelCreationFilePath = "./OutputExcel/Daily_CBS_Performance_";
	private static XSSFWorkbook workbook = null;
	
	static ArrayList<String> eList;
	static Properties prop = new Properties();
	public static String configFile = "./src/test/resources/propertiesFiles/config.properties";

	public static void api_dailyPerfor()
	{
		
		String[] sheetNames = {"API_Daily", "API_Hourly_Diff_Data", "Hourly_API_Traffic", "Normal_API_Window", "Worst_API_Window", "Detail_GEFU_Data", "GEFU_Daily", "EOD_Category", "EOD_Shell"};
		workbook = new XSSFWorkbook();
		
		Date d = new Date();		
		excelCreationFilePath = excelCreationFilePath + d.toString().replace(":", "_").replace(" ", "_")+ ".xlsx";
		System.out.println(excelCreationFilePath);
		
		for(String sheetName : sheetNames)
		{
		ArrayList<Map<String, Object>> resultSet = dbConnection.apiDaily(propertysetup.getDBurl(), propertysetup.getDBusername(), propertysetup.getDBuserpwd(), propertysetup.api_Daily_performance(sheetName));
		//System.out.println(resultSet);
		excelCreate.createExcel(sheetName, resultSet, fileOut, workbook);
		//excelCreate.createExcel("API_Hourly_Diff_Data", resultSet);
		}
        try {
        	fileOut = new FileOutputStream(excelCreationFilePath);
			workbook.write(fileOut);
			fileOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) throws AddressException, MessagingException {
		api_dailyPerfor();
		
		try {
			prop.load(new FileInputStream(configFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		eList = new ArrayList<String>(Arrays.asList(prop.getProperty("emailList").split(";")));
		System.out.println("Mail List is" + eList);
		APIDailyPerfor launcher = new APIDailyPerfor();
		//launcher.captureScreenshot();
		launcher.emailer();
	}
	
	
	public void emailer() throws AddressException, MessagingException
	{
		String host =  prop.getProperty("host");
		//		"10.56.108.156";
		// String port = "25";
		String Password = "";
		String from = "a_GurenderKumar.Kush@airtelbank.com";
		//String from = prop.getProperty("from");
		
		String  filename= excelCreationFilePath;
		String BodyText = "Hi, Please find the attached 'CBS_Daily_Performance' excel file.";
		String subject = prop.getProperty("subject");
		
		// Get system properties
			Properties props = System.getProperties();
			props.put("mail.smtp.host", host);
			if ("true".equals(prop.getProperty("isPortRequired"))) {
				System.out.println("Port is getting set to: " + prop.getProperty("port") + "  ....");
				props.put("mail.smtp.port", prop.getProperty("port"));
			}
			
		//props.put("mail.smtps.auth", "true");
		//props.put("mail.smtp.starttls.enable", "true");
			System.out.println("Host : "+ prop.getProperty("host"));
			System.out.println("isPortRequired : "+ prop.getProperty("isPortRequired"));
			System.out.println("Port : "+ prop.getProperty("port"));
			
			Session session = Session.getDefaultInstance(props, null);
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			
			for (int i = 0; i < eList.size(); i++) {
				String temp = eList.get(i);
				message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(temp));
			}
			
			message.setSubject(subject);
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(BodyText);
			
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			messageBodyPart = new MimeBodyPart();
			
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			//messageBodyPart.setHeader("Content-ID", "<image>");
			messageBodyPart.setFileName(filename);
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
			
			try {

				System.out.println("Connecting email server ....");
				Transport tr = session.getTransport("smtp");
				tr.connect(host, from, Password);
				// tr.connect(host, from);
				System.out.println("Sending email...");
				tr.sendMessage(message, message.getAllRecipients());
				System.out.println("Mail Sent Successfully!!");
				tr.close();
			}

			catch (SendFailedException sfe) {
				System.out.println("Email reporting failed!! See the details below :");
				System.out.println(sfe);
			}
	}
	
}
