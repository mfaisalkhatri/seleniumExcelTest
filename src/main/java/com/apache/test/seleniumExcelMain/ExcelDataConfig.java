package com.apache.test.seleniumExcelMain;
import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.codec.digest.Sha2Crypt;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelDataConfig {

	XSSFWorkbook wb;
	XSSFSheet sh1;
	
	
	public  ExcelDataConfig (String excelPath) {
		
		try {
			File src = new  File (excelPath);
			FileInputStream fis = new FileInputStream(src);
			
			wb = new XSSFWorkbook(fis);
		
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
			
	
	public String getData (int shNum, int row, int col ) {
		
		sh1 = wb.getSheetAt(shNum);
		String data = sh1.getRow(row).getCell(col).getStringCellValue();
		
		return data;
		
	}
	
	public int getRowCount(int sheetIndex) {
		
		int row = wb.getSheetAt(sheetIndex).getLastRowNum();
		//row = row +1;
		
		return row;
	}
}

