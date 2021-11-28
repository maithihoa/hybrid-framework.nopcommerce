package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_02_Register_Login_BasePage_Part_1 {
	WebDriver driver;
	BasePage basePage;
	Select select;
	String ProjectPath = System.getProperty("user.dir");
	String firstName, lastName, day, month, year, emailAddress, companyName, password;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ProjectPath + "/browserDriver/chromedriver.exe");
		driver = new ChromeDriver();
		basePage = new BasePage();
		
		basePage.openPageUrl(driver, "https://demo.nopcommerce.com/");
		
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
		basePage.openPageUrl(driver, "https://demo.nopcommerce.com/");
		basePage.clickToELement(driver, "//a[@class='ico-register']");
		basePage.checkToCheckboxRadio(driver, "//input[@id='gender-male']");
		basePage.sendkeyToELement(driver, "//input[@id='FirstName']", firstName);
		basePage.sendkeyToELement(driver, "//input[@id='LastName']", lastName);
		
		basePage.selectItemInDefaultDropdown(driver, "//select[@name='DateOfBirthDay']", day);
		basePage.selectItemInDefaultDropdown(driver, "//select[@name='DateOfBirthMonth']", month);
		basePage.selectItemInDefaultDropdown(driver, "//select[@name='DateOfBirthYear']", year);
		
		basePage.sendkeyToELement(driver, "//input[@id='Email']", emailAddress);
		basePage.sendkeyToELement(driver, "//input[@id='Company']", companyName);
		
		basePage.clickToELement(driver, "//input[@id='Newsletter']");
		
		basePage.sendkeyToELement(driver, "//input[@id='Password']", password);
		basePage.sendkeyToELement(driver, "//input[@id='ConfirmPassword']", password);
		
		basePage.clickToELement(driver, "//button[@id='register-button']");
		
		Assert.assertEquals(basePage.getElementText(driver, "//div[@class='result']"), "Your registration completed");
		
		basePage.clickToELement(driver, "//a[@class='ico-logout']");
		
	}
	
	@Test
	public void TC_02_Login() {
		basePage.clickToELement(driver, "//a[@class='ico-login']");
		
		basePage.sendkeyToELement(driver, "//input[@id='Email']", emailAddress);
		basePage.sendkeyToELement(driver, "//input[@id='Password']", password);
		basePage.clickToELement(driver, "//button[text()='Log in']");
		
		Assert.assertTrue(basePage.isElementDisplay(driver, "//a[@class='ico-account']"));
		Assert.assertTrue(basePage.isElementDisplay(driver, "//a[@class='ico-logout']"));
	}
	
	@Test
	public void TC_03_My_Account() {
		basePage.clickToELement(driver, "//a[@class='ico-account']");
		
		Assert.assertEquals(basePage.getElementText(driver, "//h1"), "My account - Customer info");
		Assert.assertTrue(basePage.isElementSelected(driver, "//input[@id='gender-male']"));
		
		Assert.assertEquals(basePage.getAttributeValue(driver, "//input[@id='LastName']", "value"), lastName);
		Assert.assertEquals(basePage.getAttributeValue(driver, "//input[@id='Email']", "value"), emailAddress);
		Assert.assertEquals(basePage.getAttributeValue(driver, "//input[@id='Company']", "value"), companyName);
		
		Assert.assertEquals(basePage.getFirstSelectedItemInDefaultDropdown(driver, "//select[@name='DateOfBirthDay']"), day);
		Assert.assertEquals(basePage.getFirstSelectedItemInDefaultDropdown(driver, "//select[@name='DateOfBirthMonth']"), month);
		Assert.assertEquals(basePage.getFirstSelectedItemInDefaultDropdown(driver, "//select[@name='DateOfBirthYear']"), year);
	}
	public String randEmail() {
		Random rand = new Random();
		return "hoamt" + rand.nextInt() + "@gmail.com";
	}
}
