package pageObject.alada;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.alada.homePageUI;

public class HomePageObject extends BasePage{
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isMyCourseDisplayed() {
		waitForElementVisible(driver, homePageUI.MY_COURSE_LINK);
		return isElementDisplay(driver, homePageUI.MY_COURSE_LINK);
	}
}
