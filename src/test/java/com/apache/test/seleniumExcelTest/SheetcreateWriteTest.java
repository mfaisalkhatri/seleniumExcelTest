package com.apache.test.seleniumExcelTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class SheetcreateWriteTest {

	@Test 
	public void ExcelReadTest () throws IOException {
		
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sh = wb.createSheet("Employees");

		XSSFRow row;
		Map<String, Object []> empinfo = new TreeMap<String, Object[]>();
	
		empinfo.put("1", new Object[] {
				"EMP ID", "EMP Name", "EMP DESIGNATION"});
		empinfo.put("2", new Object[] {
				"tp01", "Gopal", "Technical Manager"});
		empinfo.put("3", new Object[] {
				"tp02", "Manish", "Proof Reader"});
		empinfo.put("4", new Object[] {
				"tp03", "Mastan", "Technical Writer"});
		empinfo.put("5", new Object[] {
				"tp04", "Satish", "Technical Writer"});
		empinfo.put("6", new Object[] {
				"tp05", "Krishna", "Technical Writer"});
		
		Set<String> keyid = empinfo.keySet();
		int rowid = 0;
		
		for (String key: keyid) {
			row = sh.createRow(rowid++);
			Object [] objectArr = empinfo.get(key);
			int cellid = 0;
			
			for (Object obj : objectArr)
	         {
	            Cell cell = row.createCell(cellid++);
	            cell.setCellValue((String)obj);
	         }
	      }
	      //Write the workbook in file system
		String fpath = "F:\\apache_poi\\ExcelData\\createworkbook.xlsx";
	      FileOutputStream out = new FileOutputStream(new File(fpath));
	      wb.write(out);
	      out.close();
	      System.out.println( 
	      "WorkSheet in createworkbook.xlsx written successfully" );
		}
		
		
		}
	
	

