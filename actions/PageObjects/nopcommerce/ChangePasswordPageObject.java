package PageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import PageUIs.nopcommerce.ChangePasswordPageUI;
import commons.BasePage;

public class ChangePasswordPageObject extends BasePage {
	WebDriver driver;
	public ChangePasswordPageObject(WebDriver _driver) {
		driver = _driver;
		
	}
}
