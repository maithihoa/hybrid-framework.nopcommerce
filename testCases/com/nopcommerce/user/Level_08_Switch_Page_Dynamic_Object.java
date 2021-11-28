package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.nopcommerce.AddressesPageObject;
import PageObjects.nopcommerce.BackInStockSubScriptionPageObject;
import PageObjects.nopcommerce.ChangePasswordPageObject;
import PageObjects.nopcommerce.MyProductsReviewsPageObject;
import PageObjects.nopcommerce.HomePageObject;
import PageObjects.nopcommerce.LoginPageObject;
import PageObjects.nopcommerce.CustomerInfoPageObject;
import PageObjects.nopcommerce.OrdersPageObject;
import PageObjects.nopcommerce.DownloadableProductPageObject;
import PageObjects.nopcommerce.RegisterPageObject;
import PageObjects.nopcommerce.RewardsPointsPageObject;
import commons.BaseTest;
import commons.PageGenerator;

public class Level_08_Switch_Page_Dynamic_Object extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	CustomerInfoPageObject customerInforPage;
	MyProductsReviewsPageObject myProductsReviewPage;
	OrdersPageObject ordersPage;
	BackInStockSubScriptionPageObject backInStockSubScriptionPage;
	RewardsPointsPageObject rewardsPointsPage;
	ChangePasswordPageObject changePasswordPage;
	AddressesPageObject addressesPage;
	DownloadableProductPageObject downloadableProductsPage;

	String ProjectPath = System.getProperty("user.dir");
	String firstName, lastName, day, month, year, emailAddress, companyName, password;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserName(browserName, url);

		// 3
		homePage = new HomePageObject(driver);

		firstName = "Automation";
		lastName = "FC";
		day = "20";
		month = "March";
		year = "1987";
		emailAddress = randEmail();
		companyName = "Humax";
		password = "123456987";
	}

	@Test
	public void TC_01_Register() {
		// 2 Đang từ homepage thì click vào register link -> navigate tới register page
		registerPage = homePage.clickToRegisterLink();

		// registerPage.clickToGenderMaleRadio();
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

		// đang từ regsiter sẽ click vào logout link -> navigate về homepage

		homePage = registerPage.clickToLogout();
	}

	@Test
	public void TC_02_Login() {
		// 4 Đang từ HomePage click vào login link -> Navigate tới login
		loginPage = homePage.clickToLoginLink();

		loginPage.enterToEmailTextbox(emailAddress);
		loginPage.enterToPasswordTextbox(password);

		// 5 Đang từ lgoin click login button => navigate tới Homepage
		homePage = loginPage.clickToLoginButton();

	}

	@Test
	public void TC_03_My_Account() {
		// 6 Đang từ homepage click My account link => navigate tới My account page

		customerInforPage = homePage.clickToMyAccountLink();
		// Chỗ này khi tạo đâu có select gender đâu? nên verify là false chứ
		Assert.assertFalse(customerInforPage.isGenderMaleRadioSelected());
		Assert.assertEquals(customerInforPage.getFirstNameTextboxValue(), firstName);
		Assert.assertEquals(customerInforPage.getLastNameTextboxValue(), lastName);
		Assert.assertEquals(customerInforPage.getEmailTextboxValue(), emailAddress);
		Assert.assertEquals(customerInforPage.getCompanyNameTextboxValue(), companyName);

		Assert.assertEquals(customerInforPage.getDateDropdownValue(), day);
		Assert.assertEquals(customerInforPage.getMonthDropdownValue(), month);
		Assert.assertEquals(customerInforPage.getYearDropdownValue(), year);

	}

	@Test
	public void TC_05_Switch_Page_Common() {
		// swith tu customer Infor -> addresses
		customerInforPage.OpenSiderBarPageByName(driver, "Addresses");
		addressesPage = PageGenerator.getAddressesPageObject(driver);
		
		// addresses -> orders
		addressesPage.OpenSiderBarPageByName(driver, "Addresses");
		ordersPage = PageGenerator.getOrdersPageObject(driver);
		
		// orders -> download products
		ordersPage.OpenSiderBarPageByName(driver, "Orders");
		downloadableProductsPage = PageGenerator.getDownloadableProductPageObject(driver);
		
		// product -> back in stock subscription
		downloadableProductsPage.OpenSiderBarPageByName(driver, "Downloadable products");
		backInStockSubScriptionPage = PageGenerator.getBackInStockSubScriptionPageObject(driver);
		
		// back in stock... -> rewards points
		backInStockSubScriptionPage.OpenSiderBarPageByName(driver, "Back in stock subscriptions");
		rewardsPointsPage = PageGenerator.getRewardsPointsPageObject(driver);
		
		// reward points -> change password
		rewardsPointsPage.OpenSiderBarPageByName(driver, "Reward points");
		changePasswordPage = PageGenerator.getChangePasswordPageObject(driver);
		
		// change password -> my product reviews
		changePasswordPage.OpenSiderBarPageByName(driver, "Change password");
		myProductsReviewPage = PageGenerator.getMyProductsReviewsPageObject(driver);
		
		// my product reviews -> customer infor page
		myProductsReviewPage.OpenSiderBarPageByName(driver, "My product reviews");
		customerInforPage = PageGenerator.getCustomerInfoPageObject(driver);
	}

	@AfterTest
	public void afterclass() {
		driver.quit();
	}

}
