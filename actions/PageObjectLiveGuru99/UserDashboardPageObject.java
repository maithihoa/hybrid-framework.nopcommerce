package PageObjectLiveGuru99;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.LiveGuru99.UserDashboardPageUI;

public class UserDashboardPageObject extends BasePage{
	private WebDriver driver;
	
	public UserDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isUserRegisteredSuccessMessageDisplayed() {
		waitForElementVisible(driver,UserDashboardPageUI.USER_REGISTER_SUCCESS_MESSAGE);
		return isElementDisplay(driver,UserDashboardPageUI.USER_REGISTER_SUCCESS_MESSAGE);
	}

	public AdminHomePageObject openAdminPage() {
		waitForElementVisible(driver,UserDashboardPageUI.USER_REGISTER_SUCCESS_MESSAGE);
		clickToELement(driver, UserDashboardPageUI.USER_REGISTER_SUCCESS_MESSAGE);
		sleepInSecond(1);
		return PageGenerator.openAdminHomePage(driver);
	}

}
