package com.apache.test.seleniumExcelTest;

import org.testng.annotations.Test;
import java.io.*;
import org.apache.poi.xssf.usermodel.*;

public class ExcelCreateWb {

	@Test
	public void CreateWorkbook () throws IOException {
		
	
		//Create Blank workbook
	      XSSFWorkbook workbook = new XSSFWorkbook(); 
	      //Create file system using specific name
	      FileOutputStream out = new FileOutputStream (new File("F:\\apache_poi\\ExcelData\\createworkbook.xlsx"));
	      //write operation workbook using file out object 
	      workbook.write(out);
	      out.close();
	      System.out.println("createworkbook.xlsx written successfully");
		
		
	}
}
