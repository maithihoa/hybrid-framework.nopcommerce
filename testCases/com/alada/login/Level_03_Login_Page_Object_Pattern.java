package com.alada.login;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;
import pageObject.alada.HomePageObject;
import pageObject.alada.LoginPageObject;

public class Level_03_Login_Page_Object_Pattern extends BasePage {
	WebDriver driver;
	LoginPageObject loginPage;
	HomePageObject homePage;
	String ProjectPath = System.getProperty("user.dir");
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", ProjectPath + "/browserDriver/geckodriver.exe");
		driver = new FirefoxDriver();
		//1 - Mở Url lên
		openPageUrl(driver, "https://alada.vn/tai-khoan/dang-nhap.html");
		loginPage = new LoginPageObject(driver);
		
		}
	@Test
	public void TC_01_Login_With_Empty_Email_Password() {
		loginPage.enterToEmailTextbox("");
		loginPage.enterToPasswordTextbox("");
		loginPage.clickLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(),"Vui lòng nhập email");
		Assert.assertEquals(loginPage.getErrorMessageAtPasswordTextbox(),"Vui lòng nhập mật khẩu");
		
	}
	
	@Test
	public void TC_02_Login_With_Invalid_Email() {
		//Invalid
		loginPage.enterToEmailTextbox("automation@#$%");
		loginPage.enterToPasswordTextbox("123456");
		loginPage.clickLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(),"Vui lòng nhập email");
		
		//Invalid
		loginPage.enterToEmailTextbox("1234567");
		loginPage.enterToPasswordTextbox("123456");
		loginPage.clickLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(),"Vui lòng nhập email");
		
	}
	
	@Test
	public void TC_03_Login_With_Email_Not_Register() {
		loginPage.enterToEmailTextbox("automation" + randEmail());
		loginPage.enterToPasswordTextbox("123456");
		loginPage.clickLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageAtLoginForm(),"Email này chưa được đăng ký.");
		
	}
	@Test
	public void TC_04_Login_With_Invalid_Password() {
		//Invalid Password
		loginPage.enterToEmailTextbox("automationfc.vn@hotmail.com");
		loginPage.enterToPasswordTextbox("123");
		loginPage.clickLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageAtLoginForm(),"Mật Khẩu sai.");
		
		//Incorrect password
		loginPage.enterToEmailTextbox("automationfc.vn@hotmail.com");
		loginPage.enterToPasswordTextbox("12345689");
		loginPage.clickLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessageAtLoginForm(),"Mật Khẩu sai.");
	}
	@Test
	public void TC_05_Login_With_Valid_Email_Password() {
		loginPage.enterToEmailTextbox("automationfc.vn@hotmail.com");
		loginPage.enterToPasswordTextbox("123456");
		loginPage.clickLoginButton();
		homePage = new HomePageObject(driver);
		
		Assert.assertTrue(homePage.isMyCourseDisplayed());
		
	}
	public String randEmail() {
		Random rand = new Random();
		return "hoamt" + rand.nextInt() + "@gmail.com";
	}
}
