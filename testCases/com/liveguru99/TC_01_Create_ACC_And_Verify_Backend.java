package com.liveguru99;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import PageObjectLiveGuru99.AdminHomePageObject;
import PageObjectLiveGuru99.AdminManagerCustomerPageObject;
import PageObjectLiveGuru99.PageGenerator;
import PageObjectLiveGuru99.UserDashboardPageObject;
import PageObjectLiveGuru99.UserHomePageObject;
import PageObjectLiveGuru99.UserLoginPageObject;
import PageObjectLiveGuru99.UserRegisterPageObject;
import commons.BaseTest;

public class TC_01_Create_ACC_And_Verify_Backend extends BaseTest{
	WebDriver driver;
	String ProjectPath = System.getProperty("user.dir");
	String firstName, lastName, day, month, year, emailAddress, companyName, password;
	AdminManagerCustomerPageObject  adminManagerCustomerPage ;
	AdminHomePageObject  adminHomePage;
	UserDashboardPageObject  userDashboardPage;
	UserHomePageObject  userHomePage;
	UserLoginPageObject   userLoginPage;
	UserRegisterPageObject  userRegisterPage;
	

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserName(browserName, url);
		userHomePage = PageGenerator.openUserHomePage(driver);
		
		firstName = "Automation";
		lastName = "FC";
		emailAddress = randEmail();
		password = "123456987";
	}
	public void TC01_Register_User_At_User_Page(){
		userLoginPage = userHomePage.clickToMyAccountPage();
		
		userRegisterPage = userLoginPage.clickToCreateACCButton();
		userRegisterPage.enterToFirstNameTextbox(firstName);
		userRegisterPage.enterToLastNameTextbox(lastName);
		userRegisterPage.enterToEmailAddressTextbox(emailAddress);
		userRegisterPage.enterToPasswordTextbox(password);
		userRegisterPage.enterToConfirmPasswordTextbox(password);
		
		userDashboardPage = userRegisterPage.clickToRegisterButton();
		Assert.assertTrue(userDashboardPage.isUserRegisteredSuccessMessageDisplayed());
	}
	
	public void TC02_Search_User_At_Admin_Page(){
		adminHomePage = userDashboardPage.openAdminPage();
		adminHomePage.enterToUserNameTextbox("User01");
		adminHomePage.enterToPasswordTextbox("guru99com");
		
		adminManagerCustomerPage = adminHomePage.clickToLoginButton();
		adminManagerCustomerPage.enterToTextboxAtColumnName(emailAddress);
		adminManagerCustomerPage.clickSearchButton();
		Assert.assertTrue(adminManagerCustomerPage.isLoadingIconDisappear());
		Assert.assertTrue(adminManagerCustomerPage.isUserInforDisplayedInTable(emailAddress));
		adminManagerCustomerPage.closePopupWindown();
	}
	
}
