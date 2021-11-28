package PageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import PageUIs.nopcommerce.AddressesPageUI;
import commons.BasePage;

public class AddressesPageObject extends BasePage{
	WebDriver driver;
	public AddressesPageObject(WebDriver _driver) {
		driver = _driver;
		
	}

}
