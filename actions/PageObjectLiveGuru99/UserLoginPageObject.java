package PageObjectLiveGuru99;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.LiveGuru99.UserLoginPageUI;

public class UserLoginPageObject extends BasePage{
	private WebDriver driver;
	
	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public UserRegisterPageObject clickToCreateACCButton() {
		waitForElementVisible(driver,UserLoginPageUI.CREATE_AN_ACCOUNT_BUTTON);
		clickToELement(driver, UserLoginPageUI.CREATE_AN_ACCOUNT_BUTTON);
		sleepInSecond(1);
		return PageGenerator.openUserRegisterPage(driver);
	}

}
