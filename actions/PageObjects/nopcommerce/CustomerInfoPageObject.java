package PageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import PageUIs.nopcommerce.ChangePasswordPageUI;
import PageUIs.nopcommerce.CustomerInfoPageUI;
import PageUIs.nopcommerce.DownloadablePageUI;
import PageUIs.nopcommerce.MyProductReviewsPageUI;
import PageUIs.nopcommerce.OrdersPageUI;
import PageUIs.nopcommerce.RewardsPointsPageUI;
import commons.BasePage;

public class CustomerInfoPageObject extends BasePage {
	WebDriver driver;
	
	public CustomerInfoPageObject(WebDriver _driver) {
		driver = _driver;
	}
	public boolean isGenderMaleRadioSelected() {
		waitForElementVisible(driver,CustomerInfoPageUI.GENDER_MALE_RADIO);
		return isElementSelected(driver,CustomerInfoPageUI.GENDER_MALE_RADIO);
	}

	public String getFirstNameTextboxValue() {
		waitForElementVisible(driver,CustomerInfoPageUI.FIRSTNAME_TEXTBOX);
		return getAttributeValue(driver,CustomerInfoPageUI.FIRSTNAME_TEXTBOX,"value");
	}

	public String getLastNameTextboxValue() {
		waitForElementVisible(driver,CustomerInfoPageUI.LASTNAME_TEXTBOX);
		return getAttributeValue(driver,CustomerInfoPageUI.LASTNAME_TEXTBOX,"value");
	}

	public String getEmailTextboxValue() {
		waitForElementVisible(driver,CustomerInfoPageUI.EMAIL_TEXTBOX);
		return getAttributeValue(driver,CustomerInfoPageUI.EMAIL_TEXTBOX,"value");
	}

	public String getCompanyNameTextboxValue() {
		waitForElementVisible(driver,CustomerInfoPageUI.COMPANY_TEXTBOX);
		return getAttributeValue(driver,CustomerInfoPageUI.COMPANY_TEXTBOX,"value");
	}

	public String getDateDropdownValue() {
		waitForElementVisible(driver,CustomerInfoPageUI.DAY_DROPDOWN);
		return getFirstSelectedItemInDefaultDropdown(driver,CustomerInfoPageUI.DAY_DROPDOWN);
	}

	public String getMonthDropdownValue() {
		waitForElementVisible(driver,CustomerInfoPageUI.MONTH_DROPDOWN);
		return getFirstSelectedItemInDefaultDropdown(driver,CustomerInfoPageUI.MONTH_DROPDOWN);
	}

	public String getYearDropdownValue() {
		waitForElementVisible(driver,CustomerInfoPageUI.YEAR_DROPDOWN);
		return getFirstSelectedItemInDefaultDropdown(driver,CustomerInfoPageUI.YEAR_DROPDOWN);
	}

}
