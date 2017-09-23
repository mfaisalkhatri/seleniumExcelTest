package com.apache.test.seleniumExcelTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class OpenExcel {

	
	@Test
	public void OpenExcleTest () throws IOException {
	File file = new File("F:\\apache_poi\\ExcelData\\createworkbook.xlsx");
    FileInputStream fIP = new FileInputStream(file);
    //Get the workbook instance for XLSX file 
    XSSFWorkbook workbook = new XSSFWorkbook(fIP);
    
    if(file.isFile() && file.exists())
    {
       System.out.println("createworkbook.xlsx file open successfully.");
    }
    else
    {
       System.out.println("Error to open openworkbook.xlsx file.");
	
}

	}	
}