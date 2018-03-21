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
	public void ExcelTest1(String usrName, String password, String message) throws InterruptedException {

		LoginPage login = new LoginPage(driver);
		login.loginSite(usrName, password, message);

		Thread.sleep(1000);

	}

	@DataProvider(name = "personalData")
	public Object[][] passData() {
		String xlPath = "F:\\Eclipse_Neon\\Workspace\\seleniumExcelTest\\TestData\\LoginData.xlsx";
		ExcelDataConfig excl = new ExcelDataConfig(xlPath);
		int rows = excl.getRowCount(0);

		Object[][] data = new Object[rows][3];
		for (int i = 0; i < rows; i++) {

			data[i][0] = excl.getData(0, i + 1, 0);
			data[i][1] = excl.getData(0, i + 1, 1);
			data[i][2] = excl.getData(0, i + 1, 2);
		}
		return data;
	}

}
