package com.APBCBS.performancereport.TestUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class PropertySetup {
	
	DBConnectionUtil dbconn = new DBConnectionUtil();
	
	public static Properties configProperty;
	
	public static String propertyFilepath ="./src/test/resources/propertiesFiles/config.properties";
	
	//dbconn.setUpConnection(configProperty.getProperty("dburl"), configProperty.getProperty("dbusrname"), configProperty.getProperty("dbusrpwd"))
	
	public PropertySetup()
	{
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilepath));
			configProperty = new Properties();
			try {
				configProperty.load(reader);
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public String getFilePath()
	{
		String filePath = configProperty.getProperty("filePath");
		if(filePath!= null) return filePath;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
	}
	
	public String getDBurl()
	{
		String dburl = configProperty.getProperty("dburl");
		if(dburl!= null) return dburl;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
	}
	
	public String getDBusername()
	{
		String dbusername = configProperty.getProperty("dbusername");
		if(dbusername!= null) return dbusername;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
	}
	
	public String getDBuserpwd()
	{
		String dbuserpwd = configProperty.getProperty("dbuserpwd");
		if(dbuserpwd!= null) return dbuserpwd;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
	}
	
	public String api_Daily_performance(String sheetName)
	{
		
			if(sheetName.equals("API_Daily"))
			{
				String query = configProperty.getProperty("API_Daily_Query");
				if(query!= null) return query;
				else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");	
			}else if(sheetName.equalsIgnoreCase("API_Hourly_Diff_Data"))
			{
				String query = configProperty.getProperty("api_Hourly_Diff_Data");
				if(query!= null) return query;
				else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
			}else if(sheetName.equalsIgnoreCase("Hourly_API_Traffic"))
			{
				String query = configProperty.getProperty("Hourly_API_Traffic");
				if(query!= null) return query;
				else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
			}else if(sheetName.equalsIgnoreCase("Normal_API_Window"))
			{
				String query = configProperty.getProperty("Normal_API_Window");
				if(query!= null) return query;
				else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
			}else if(sheetName.equalsIgnoreCase("Worst_API_Window"))
			{
				String query = configProperty.getProperty("Worst_API_Window");
				if(query!= null) return query;
				else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
			}else if(sheetName.equalsIgnoreCase("Detail_GEFU_Data"))
			{
				String query = configProperty.getProperty("Detail_GEFU_Data");
				if(query!= null) return query;
				else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
			}else if(sheetName.equalsIgnoreCase("GEFU_Daily"))
			{
				String query = configProperty.getProperty("GEFU_Daily");
				if(query!= null) return query;
				else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
			}else if(sheetName.equalsIgnoreCase("EOD_Category"))
			{
				String query = configProperty.getProperty("EOD_Category");
				if(query!= null) return query;
				else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
			}else if(sheetName.equalsIgnoreCase("EOD_Shell"))
			{
				String query = configProperty.getProperty("EOD_Shell");
				if(query!= null) return query;
				else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
			}else
			{
				return null;
			}
		
		/*String apiDaily = configProperty.getProperty("API_Daily_Query");
		if(apiDaily!= null) return apiDaily;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");	*/
		//return null;	
	}
	
	public String api_Hourly_Diff_Data()
	{
		String apiHourlyDiffData = configProperty.getProperty("api_Hourly_Diff_Data");
		if(apiHourlyDiffData!= null) return apiHourlyDiffData;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
	}

}
