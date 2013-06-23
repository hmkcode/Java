package com.hmkcode.poi;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class AppRead
{
    public static void main( String[] args )
    {
    	Workbook wb = null;
    	  try {
			wb = WorkbookFactory.create(new File("workbook.xlsx"));
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	 
    	Sheet sheet = wb.getSheetAt(0);
    	
    	//*********************************
    	Cell cell = sheet.getRow(0).getCell(0);
    	double numberVal = cell.getNumericCellValue();
    	System.out.println("Row: 0 - Column: 0 = "+numberVal);
    	//-----------------------------
    	cell = sheet.getRow(0).getCell(1);
    	String stringVal = cell.getStringCellValue();
    	System.out.println("Row: 0 - Column: 1 = "+stringVal);
    	//-----------------------------
    	cell = sheet.getRow(0).getCell(2);
    	Date dateVal = cell.getDateCellValue();
    	System.out.println("Row: 0 - Column: 2 = "+dateVal);
    	//-----------------------------
    	cell = sheet.getRow(0).getCell(3);
    	boolean booleanVal = cell.getBooleanCellValue();
    	System.out.println("Row: 0 - Column: 3 = "+booleanVal);
    	//-----------------------------
    	
    }
    
   
}
