package com.apache.test.seleniumExcelMain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementsOnPage {

	private WebDriver driver;

	public void MainPageElements(String fiName, String lName, boolean gender, boolean proff, String cont,
			String mSelect) {

		final By parentPage = By.cssSelector(".form-horizontal>fieldset");
		final WebElement mainPage = driver.findElement(parentPage);

		final By fname = By.name("firstname");
		final WebElement firstName = mainPage.findElement(fname);
		firstName.clear();
		firstName.sendKeys(fiName);

		final By lname = By.name("lastname");
		final WebElement lastName = mainPage.findElement(lname);
		lastName.clear();
		lastName.sendKeys(lName);

		final By male = By.id("sex-0");
		final WebElement mle = mainPage.findElement(male);

		final By female = By.id("sex-1");
		final WebElement fmle = mainPage.findElement(female);

		boolean gend = gender;
		if (gend == true) {
			mle.click();
		} else {
			fmle.click();
		}

		final By manual = By.id("profession-0");
		final WebElement mnl = mainPage.findElement(manual);

		final By autmtion = By.id("profession-1");
		final WebElement auto = mainPage.findElement(autmtion);

		boolean prof = proff;
		if (prof == true) {
			mnl.click();

		} else {
			auto.click();

		}

		By contDrpDwn = By.id("continents");
		WebElement cDrpdwn = mainPage.findElement(contDrpDwn);

		Select slt = new Select(cDrpdwn);
		slt.selectByVisibleText(cont);

		Select slct = new Select(mainPage.findElement(By.cssSelector("#selenium_commands")));

		List<String> list = new ArrayList<String>(Arrays.asList(mSelect.split(",")));

		for (String check : list) {
			slct.selectByVisibleText(check);
		}

	}

	public ElementsOnPage(WebDriver driver) {
		this.driver = driver;
	}

}
