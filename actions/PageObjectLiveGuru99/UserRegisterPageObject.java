package PageObjectLiveGuru99;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.LiveGuru99.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {
	private WebDriver driver;
	
	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void enterToFirstNameTextbox(String value) {
		waitForElementClickable(driver,UserRegisterPageUI.FRIST_NAME_TEXTBOX);
		sendkeyToELement(driver, UserRegisterPageUI.FRIST_NAME_TEXTBOX,value);
		sleepInSecond(1);
	}

	public void enterToLastNameTextbox(String value) {
		waitForElementClickable(driver,UserRegisterPageUI.LAST_NAME_TEXTBOX);
		sendkeyToELement(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX,value);
		sleepInSecond(1);
		
	}

	public void enterToEmailAddressTextbox(String value) {
		waitForElementClickable(driver,UserRegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToELement(driver, UserRegisterPageUI.EMAIL_TEXTBOX,value);
		sleepInSecond(1);
		
	}

	public void enterToPasswordTextbox(String value) {
		waitForElementClickable(driver,UserRegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToELement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX,value);
		sleepInSecond(1);
		
	}

	public void enterToConfirmPasswordTextbox(String value) {
		waitForElementClickable(driver,UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToELement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX,value);
		sleepInSecond(1);
		
	}
	public UserDashboardPageObject clickToRegisterButton() {
		waitForElementVisible(driver,UserRegisterPageUI.REGISTER_BUTTON);
		clickToELement(driver, UserRegisterPageUI.REGISTER_BUTTON);
		sleepInSecond(1);
		return PageGenerator.openUserDashboardPage(driver);
	}

}
