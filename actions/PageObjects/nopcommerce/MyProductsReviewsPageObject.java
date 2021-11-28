package PageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import PageUIs.nopcommerce.MyProductReviewsPageUI;
import commons.BasePage;

public class MyProductsReviewsPageObject extends BasePage {
	WebDriver driver;
	public MyProductsReviewsPageObject(WebDriver _driver) {
		driver = _driver;
		
	}
}
