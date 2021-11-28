package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.nopcommerce.HomePageObject;
import PageObjects.nopcommerce.LoginPageObject;
import PageObjects.nopcommerce.CustomerInfoPageObject;
import PageObjects.nopcommerce.RegisterPageObject;

public class Level_03_Register_Login_Page_Object_Pattern {
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	CustomerInfoPageObject myAccountPage;
	String ProjectPath = System.getProperty("user.dir");
	String firstName, lastName, day, month, year, emailAddress, companyName, password;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", ProjectPath + "/browserDriver/geckodriver.exe");
		driver = new FirefoxDriver();
		
		//1 Mở app url lên -> Khởi tạo Home Page
		driver.get("http://demo.nopcommerce.com/");
		homePage = new HomePageObject(driver);
		
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
		//2 Đang từ homepage thì click vào register link -> navigate tới register page
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);
		
		registerPage.clickToGenderMaleRadio();
		registerPage.enterToFirstNameTextbox(firstName);
		registerPage.enterToLastNameTextbox(lastName);
		registerPage.selectDayDropdown(day);
		registerPage.selectMonthDropdown(month);
		registerPage.selectYearDropdown(year);
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToCompanyTextbox(companyName);
		registerPage.enterToPasswordTextbox(password);
		registerPage.enterToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isRegisterSuccessMessageDisplay());
		
		//đang từ regsiter sẽ click vào logout link -> navigate về homepage
		registerPage.clickToLogout();
		homePage = new HomePageObject(driver);
	}
	
	@Test
	public void TC_02_Login() {
		//4 Đang từ HomePage click vào login link -> Navigate tới login
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		
		loginPage.enterToEmailTextbox(emailAddress);
		loginPage.enterToPasswordTextbox(password);
		loginPage.clickToLoginButton();
		
		//5 Đang từ lgoin click login button => navigate tới Homepage
		homePage = new HomePageObject(driver);
		
	}
	
	@Test
	public void TC_03_My_Account() {
		//6 Đang từ homepage click My account link => navigate tới My account page
		homePage.clickToMyAccountLink();
		myAccountPage = new CustomerInfoPageObject(driver);
		
		Assert.assertTrue(myAccountPage.isGenderMaleRadioSelected());
		Assert.assertEquals(myAccountPage.getFirstNameTextboxValue(),firstName);
		Assert.assertEquals(myAccountPage.getLastNameTextboxValue(),lastName);
		Assert.assertEquals(myAccountPage.getEmailTextboxValue(),emailAddress);
		Assert.assertEquals(myAccountPage.getCompanyNameTextboxValue(),companyName);
		
		Assert.assertEquals(myAccountPage.getDateDropdownValue(),day);
		Assert.assertEquals(myAccountPage.getMonthDropdownValue(),month);
		Assert.assertEquals(myAccountPage.getYearDropdownValue(),year);
	}
	public String randEmail() {
		Random rand = new Random();
		return "hoamt" + rand.nextInt() + "@gmail.com";
	}
	@AfterTest
	public void afterclass() {
		driver.quit();
	}
}
