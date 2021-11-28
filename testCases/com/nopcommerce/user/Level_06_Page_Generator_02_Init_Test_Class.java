package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.nopcommerce.HomePageObject;
import PageObjects.nopcommerce.LoginPageObject;
import PageObjects.nopcommerce.CustomerInfoPageObject;
import PageObjects.nopcommerce.RegisterPageObject;
import commons.BaseTest;

public class Level_06_Page_Generator_02_Init_Test_Class extends BaseTest{
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
		driver = getBrowserName(browserName, url);
				
		//1 Mở app url lên -> Khởi tạo Home Page
		//cứ từ page này chuyển page kia thì sẽ new page mới lên, không quan tâm đến việc che giấu đối tượng
		// Khởi tạo New nhiều lần
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
		registerPage = homePage.clickToRegisterLink();
		
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
		
		homePage = registerPage.clickToLogout();
	}
	
	@Test
	public void TC_02_Login() {
		//4 Đang từ HomePage click vào login link -> Navigate tới login
		loginPage = homePage.clickToLoginLink();
		
		loginPage.enterToEmailTextbox(emailAddress);
		loginPage.enterToPasswordTextbox(password);

		//5 Đang từ lgoin click login button => navigate tới Homepage
		homePage = loginPage.clickToLoginButton();
		
	}
	
	@Test
	public void TC_03_My_Account() {
		//6 Đang từ homepage click My account link => navigate tới My account page
		
		myAccountPage = homePage.clickToMyAccountLink();
		
		Assert.assertTrue(myAccountPage.isGenderMaleRadioSelected());
		Assert.assertEquals(myAccountPage.getFirstNameTextboxValue(),firstName);
		Assert.assertEquals(myAccountPage.getLastNameTextboxValue(),lastName);
		Assert.assertEquals(myAccountPage.getEmailTextboxValue(),emailAddress);
		Assert.assertEquals(myAccountPage.getCompanyNameTextboxValue(),companyName);
		
		Assert.assertEquals(myAccountPage.getDateDropdownValue(),day);
		Assert.assertEquals(myAccountPage.getMonthDropdownValue(),month);
		Assert.assertEquals(myAccountPage.getYearDropdownValue(),year);
	}

	@AfterTest
	public void afterclass() {
		driver.quit();
	}
}
