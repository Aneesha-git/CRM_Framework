package com.selenium.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	public ExcelDataProvider() {
		File src=new File("./TestData/testDataSheet.xlsx");
		 try {
		FileInputStream fis=new FileInputStream(src);
		
			wb=new XSSFWorkbook(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to read excel"+e.getMessage());
		}
		
	}
	
	public String getStringData(String sheet,int rownum,int col) {
	return	wb.getSheet(sheet).getRow(rownum).getCell(col).getStringCellValue();		
		
	}
	
	public String getStringData(int sheet,int rownum,int col) {
		return	wb.getSheetAt(sheet).getRow(rownum).getCell(col).getStringCellValue();		
			
		}
	public double getNumericData(String sheet,int rownum,int col) {
		return	wb.getSheet(sheet).getRow(rownum).getCell(col).getNumericCellValue();		
			
		}
		

}
