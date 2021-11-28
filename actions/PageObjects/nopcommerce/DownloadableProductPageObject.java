package PageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import PageUIs.nopcommerce.DownloadablePageUI;
import commons.BasePage;

public class DownloadableProductPageObject extends BasePage{
	WebDriver driver;
	public DownloadableProductPageObject(WebDriver _driver) {
		driver = _driver;
		
	}
}
