package com.apache.test.seleniumExcelMain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void loginSite(String userName, String password, String message) {

		WebElement usrNamefield = driver.findElement(By.id("login-component-login-input"));
		usrNamefield.click();
		usrNamefield.sendKeys(userName);

		WebElement passfield = driver.findElement(By.id("login-component-password-input"));
		passfield.click();
		passfield.sendKeys(password);

		WebElement submitBtn = driver.findElement(By.id("login-component-login-submit-button"));
		submitBtn.click();
		
		WebElement errMsg = driver.findElement(By.cssSelector(".error-message"));
		String msg = errMsg.getText();
		Assert.assertEquals(message, msg);
	}

}
