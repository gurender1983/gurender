package com.APBCBS.performancereport.TestUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelCreation {
	
	public  String path;
	public  FileInputStream fis = null;
	//private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row   =null;
	private XSSFCell cell = null;
	//public static String excelCreationFilePath = "D://Daily_CBS_Performance";
	
	@SuppressWarnings("rawtypes")
	public void createExcel(String sheetName, ArrayList<Map<String, Object>> resultSet,FileOutputStream fileOut, XSSFWorkbook workbook)
	{
		CreationHelper createHelper = workbook.getCreationHelper();
		sheet = workbook.createSheet(sheetName);
		XSSFFont headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short)14);
		headerFont.setColor(IndexedColors.RED.getIndex());
		
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);
		
		//create row
		row = sheet.createRow(0);
		//System.out.println(resultSet.size());
		for(Map<String, Object> rowData: resultSet)
		{
			Set keys =  rowData.entrySet();
			Iterator iterator = keys.iterator();
			
			for(int i=0; i<keys.size();i++)
			{			
					Map.Entry mapEntry = (Entry) iterator.next();				
					String keyName = (String) mapEntry.getKey();				
					cell = row.createCell(i);
					cell.setCellValue(keyName);
					cell.setCellStyle(headerCellStyle);			
			}
			break;		
		}
		
		CellStyle dateCellStyle = workbook.createCellStyle();
		dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
		//Create Cell with values
		int rowNum =1;
		for(Map<String, Object> rowData: resultSet)
		{			
			Set keys =  rowData.entrySet();
			Iterator iterator = keys.iterator();		
			row = sheet.createRow(rowNum++);
			for(int i=0; i<keys.size();i++)
			{			
					Map.Entry mapEntry = (Entry) iterator.next();				
					String keyName = (String) mapEntry.getKey();
					String keyValues = null;
					if(mapEntry.getValue() instanceof String) {
					 keyValues = (String) mapEntry.getValue();
					}
					if(mapEntry.getValue() instanceof BigDecimal) {
						 
						BigDecimal keyValuesBD = (BigDecimal) mapEntry.getValue();
						keyValues = keyValuesBD.toString();
						}
					if(mapEntry.getValue() instanceof Date)
					{
						Date keyValueDate = (Date) mapEntry.getValue();
						keyValues = keyValueDate.toString();
					}
					//System.out.println("Key : " + keyName + "Values : "+keyValues);
					cell = row.createCell(i);
					cell.setCellValue(keyValues);
					//cell.setCellStyle(headerCellStyle);			
			}		
		}
		//Resize all the columns
		for(Map<String, Object> rowData: resultSet)
		{
			Set keys =  rowData.entrySet();
			Iterator iterator = keys.iterator();
			
			for(int i=0; i<keys.size();i++)
			{			
				sheet.autoSizeColumn(i);		
			}
			break;		
		}
		
		
	}

}
