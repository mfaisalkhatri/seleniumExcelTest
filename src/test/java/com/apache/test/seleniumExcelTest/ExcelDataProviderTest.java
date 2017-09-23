package com.apache.test.seleniumExcelTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.apache.test.seleniumExcelMain.ElementsOnPage;
import com.apache.test.seleniumExcelMain.ExcelDataConfig;

public class ExcelDataProviderTest {

	
	public WebDriver driver;
	public String baseurl = "http://toolsqa.com/automation-practice-form/";
	
	@BeforeMethod
	public void StartUp(){
		String chromepath = "F:\\Driver\\Chrome\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromepath);
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(baseurl);
	}
	
	
	@AfterMethod 
	public void TearDown() {
		System.out.println("End of Test!!");
		driver.quit();	
	}
	
	@Test(dataProvider = "personalData")
	public void ExcelTest1 (String fName, String lName, String gen, String prof,String cont, String selCmnds) throws InterruptedException {
		
		ElementsOnPage elm = new ElementsOnPage(this.driver);
		elm.MainPageElements(fName, lName, Boolean.parseBoolean(gen), Boolean.parseBoolean(prof), cont, selCmnds);
		Thread.sleep(3000);
		System.out.println("Data Entry Done");
		
	}
	
	@DataProvider (name = "personalData") 
	public Object[][] passData (){
		String xlPath = "F:\\Eclipse_Neon\\Workspace\\seleniumExcelTest\\TestData\\TestData.xlsx";
		ExcelDataConfig excl = new ExcelDataConfig(xlPath);
		int rows = excl.getRowCount(0);
	
		Object[][] data  = new Object [rows][6];
		for (int i = 0; i< rows ;i++) {
			
			data [i][0] = excl.getData(0, i + 1, 0);
			data [i][1] = excl.getData(0, i + 1, 1);
			data [i][2] = excl.getData(0, i + 1, 2);
			data [i][3] = excl.getData(0, i + 1, 3);
			data [i][4] = excl.getData(0, i + 1, 4);
			data [i][5] = excl.getData(0, i + 1, 5);
			
		}
		return data;
	}
	
	
	
}
