package PageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import PageUIs.nopcommerce.OrdersPageUI;
import PageUIs.nopcommerce.RewardsPointsPageUI;
import commons.BasePage;

public class OrdersPageObject extends BasePage{
	WebDriver driver;
	public OrdersPageObject(WebDriver _driver) {
		driver = _driver;
		
	}

}
