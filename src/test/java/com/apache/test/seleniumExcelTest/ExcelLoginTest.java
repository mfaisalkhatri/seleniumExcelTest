package com.apache.test.seleniumExcelTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.apache.test.seleniumExcelMain.ExcelDataConfig;
import com.apache.test.seleniumExcelMain.LoginPage;

public class ExcelLoginTest {

	public WebDriver driver;
	public String baseurl = "https://demo.dotcms.com/dotAdmin/#/public/login";

	@BeforeMethod
	public void StartUp() {
		String chromepath = "D:\\Driver\\Chrome\\chromedriver.exe";
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
	public void ExcelTest1(String usrName, String password, String message) throws InterruptedException {

		LoginPage login = new LoginPage(driver);
		login.loginSite(usrName, password, message);

		Thread.sleep(1000);

	}

	@DataProvider(name = "personalData")
	public Object[][] passData() {
		String xlPath = "D:\\Github\\seleniumExcelTest\\TestData\\LoginData.xlsx";
		ExcelDataConfig excl = new ExcelDataConfig(xlPath);
		int rows = excl.getRowCount(0);
		int col = 3;

		Object[][] data = new Object[rows][col];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < col; j++) {

				data[i][j] = excl.getData(0, i + 1, j);
			}
		}
		return data;
	}

}
