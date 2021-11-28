package PageObjectLiveGuru99;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.LiveGuru99.AdminHomePageUI;

public class AdminHomePageObject extends BasePage {
	private WebDriver driver;
	
	public AdminHomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void enterToUserNameTextbox(String value) {
		waitForElementClickable(driver,AdminHomePageUI.USERNAME_TEXTBOX);
		sendkeyToELement(driver, AdminHomePageUI.USERNAME_TEXTBOX,value);
		sleepInSecond(1);
	}

	public void enterToPasswordTextbox(String value) {
		waitForElementClickable(driver,AdminHomePageUI.PASSWORD_TEXTBOX);
		sendkeyToELement(driver, AdminHomePageUI.PASSWORD_TEXTBOX,value);
		sleepInSecond(1);
	}
	public AdminManagerCustomerPageObject clickToLoginButton() {
		waitForElementVisible(driver,AdminHomePageUI.PASSWORD_TEXTBOX);
		clickToELement(driver, AdminHomePageUI.PASSWORD_TEXTBOX);
		sleepInSecond(1);
		return PageGenerator.openAdminManagerCustomerPage(driver);
	}

}
