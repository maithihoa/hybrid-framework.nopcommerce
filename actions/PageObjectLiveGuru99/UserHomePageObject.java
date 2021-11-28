package PageObjectLiveGuru99;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.LiveGuru99.UserHomePageUI;

public class UserHomePageObject extends BasePage{
	private WebDriver driver;
	
	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	public UserLoginPageObject clickToMyAccountPage() {
		waitForElementVisible(driver,UserHomePageUI.CLICK_TO_MYACCOUNT_LINK);
		clickToELement(driver, UserHomePageUI.CLICK_TO_MYACCOUNT_LINK);
		sleepInSecond(1);
		return PageGenerator.openUserLoginPage(driver);
	}

}
