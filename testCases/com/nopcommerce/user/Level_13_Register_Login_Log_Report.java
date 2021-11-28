package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.nopcommerce.CustomerInfoPageObject;
import PageObjects.nopcommerce.HomePageObject;
import PageObjects.nopcommerce.LoginPageObject;
import PageObjects.nopcommerce.RegisterPageObject;
import commons.BaseTest;

public class Level_13_Register_Login_Log_Report extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	CustomerInfoPageObject myAccountPage;
	String ProjectPath = System.getProperty("user.dir");
	String firstName, lastName, day, month, year, emailAddress, companyName, password;
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		log.info("Pre-condition - Step 01: Open browser" + browserName);
		driver = getBrowserName(browserName, url);
				
		//1 Mở app url lên -> Khởi tạo Home Page
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
		
		log.info("TC_01_Register - Step 01: Open Register link");
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);
		
		log.info("TC_01_Register - Step 02: Click to Gender Male radio");
		registerPage.clickToGenderMaleRadio();
		
		log.info("TC_01_Register - Step 03: Click to FirstName textbox");
		registerPage.enterToFirstNameTextbox(firstName);
		
		log.info("TC_01_Register - Step 04: Click to LastName textbox");
		registerPage.enterToLastNameTextbox(lastName);
		
		log.info("TC_01_Register - Step 05: Select Day dropdown");
		registerPage.selectDayDropdown(day);
		
		log.info("TC_01_Register - Step 06: Select Day dropdown");
		registerPage.selectMonthDropdown(month);
		
		log.info("TC_01_Register - Step 07: Select Day dropdown");
		registerPage.selectYearDropdown(year);
		
		log.info("TC_01_Register - Step 08: Click to Email textbox" + emailAddress);
		registerPage.enterToEmailTextbox(emailAddress);
		
		log.info("TC_01_Register - Step 09: Click to Company textbox");
		registerPage.enterToCompanyTextbox(companyName);
		
		log.info("TC_01_Register - Step 10: Click to Password textbox" + password);
		registerPage.enterToPasswordTextbox(password);
		
		log.info("TC_01_Register - Step 11: Click to ConfirmPassword textbox");
		registerPage.enterToConfirmPasswordTextbox(password);
		
		log.info("TC_01_Register - Step 12: Click to Register button");
		registerPage.clickToRegisterButton();
		
		log.info("TC_01_Register - Step 13: Verify Register success message is displayed");
		verifyTrue(registerPage.isRegisterSuccessMessageDisplay());
		
		//đang từ regsiter sẽ click vào logout link -> navigate về homepage
		log.info("TC_01_Register - Step 14: Click to logout button");
		registerPage.clickToLogout();
		homePage = new HomePageObject(driver);
	}
	
	@Test
	public void TC_02_Login() {
		//4 Đang từ HomePage click vào login link -> Navigate tới login
		log.info("TC_02_Login - Step 01: Click to Login link");
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		
		log.info("TC_02_Login - Step 02: Enter to Email textbox");
		loginPage.enterToEmailTextbox(emailAddress);
		
		log.info("TC_02_Login - Step 03: Enter to Password textbox");
		loginPage.enterToPasswordTextbox(password);
		
		log.info("TC_02_Login - Step 04: Click to Login button");
		loginPage.clickToLoginButton();
		
		//5 Đang từ lgoin click login button => navigate tới Homepage
		homePage = new HomePageObject(driver);
		
	}

	@AfterTest
	public void afterclass() {
		driver.quit();
	}
}
