package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_02_Register_Login_BasePage_Part_3 extends BasePage {
	WebDriver driver;
	Select select;
	String ProjectPath = System.getProperty("user.dir");
	String firstName, lastName, day, month, year, emailAddress, companyName, password;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", ProjectPath + "/browserDriver/geckodriver.exe");
		driver = new FirefoxDriver();
		
		openPageUrl(driver, "https://demo.nopcommerce.com/");
		
		firstName = "Automation";
		lastName = "FC";
		day = "20";
		month = "March";
		year = "1987";
		emailAddress =randEmail();
		companyName ="Humax";
		password = "123456987";
	}
	@Test
	public void TC_01_Register() {
		clickToELement(driver, "//a[@class='ico-register']");
		checkToCheckboxRadio(driver, "//input[@id='gender-male']");
		sendkeyToELement(driver, "//input[@id='FirstName']", firstName);
		sendkeyToELement(driver, "//input[@id='LastName']", lastName);
		
		selectItemInDefaultDropdown(driver, "//select[@name='DateOfBirthDay']", day);
		selectItemInDefaultDropdown(driver, "//select[@name='DateOfBirthMonth']", month);
		selectItemInDefaultDropdown(driver, "//select[@name='DateOfBirthYear']", year);
		
		sendkeyToELement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToELement(driver, "//input[@id='Company']", companyName);
		
		clickToELement(driver, "//input[@id='Newsletter']");
		
		sendkeyToELement(driver, "//input[@id='Password']", password);
		sendkeyToELement(driver, "//input[@id='ConfirmPassword']", password);
		
		clickToELement(driver, "//button[@id='register-button']");
		
		Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");
		
		clickToELement(driver, "//a[@class='ico-logout']");
		
	}
	
	@Test
	public void TC_02_Login() {
		clickToELement(driver, "//a[@class='ico-login']");
		
		sendkeyToELement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToELement(driver, "//input[@id='Password']", password);
		clickToELement(driver, "//button[text()='Log in']");
		
		Assert.assertTrue(isElementDisplay(driver, "//a[@class='ico-account']"));
		Assert.assertTrue(isElementDisplay(driver, "//a[@class='ico-logout']"));
	}
	
	@Test
	public void TC_03_My_Account() {
		clickToELement(driver, "//a[@class='ico-account']");
		
		Assert.assertEquals(getElementText(driver, "//h1"), "My account - Customer info");
		Assert.assertTrue(isElementSelected(driver, "//input[@id='gender-male']"));
		
		Assert.assertEquals(getAttributeValue(driver, "//input[@id='LastName']", "value"), lastName);
		Assert.assertEquals(getAttributeValue(driver, "//input[@id='Email']", "value"), emailAddress);
		Assert.assertEquals(getAttributeValue(driver, "//input[@id='Company']", "value"), companyName);
		
		Assert.assertEquals(getFirstSelectedItemInDefaultDropdown(driver, "//select[@name='DateOfBirthDay']"), day);
		Assert.assertEquals(getFirstSelectedItemInDefaultDropdown(driver, "//select[@name='DateOfBirthMonth']"), month);
		Assert.assertEquals(getFirstSelectedItemInDefaultDropdown(driver, "//select[@name='DateOfBirthYear']"), year);
	}
	public String randEmail() {
		Random rand = new Random();
		return "hoamt" + rand.nextInt() + "@gmail.com";
	}
}
