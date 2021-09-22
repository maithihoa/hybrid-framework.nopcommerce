package PageObject;

import org.openqa.selenium.WebDriver;

import PageUI.LoginPageUI;
import commons.BasePage;

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

	public void clickToLoginButton() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToELement(driver, LoginPageUI.LOGIN_BUTTON);
		
	}
	
}
