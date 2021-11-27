package PageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import PageUIs.nopcommerce.LoginPageUI;
import commons.BasePage;
import commons.PageGenerator;

public class LoginPageObject extends BasePage {

		private WebDriver driver;
		
	public LoginPageObject(WebDriver _driver) {
		driver = _driver;
	}
	public void enterToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToELement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToELement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public HomePageObject clickToLoginButton() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToELement(driver, LoginPageUI.LOGIN_BUTTON);
		if(driver.toString().contains("chrome") || driver.toString().contains("edge")){
			sleepInSecond(3);
		}
		return PageGenerator.getHomePage(driver);
		
	}
	
}
