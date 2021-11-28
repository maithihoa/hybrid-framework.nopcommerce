package PageObjectLiveGuru99;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.LiveGuru99.AdminManagerCustomerPageUI;

public class AdminManagerCustomerPageObject extends BasePage{
	private WebDriver driver;
	
	public AdminManagerCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToTextboxAtColumnName(String email) {
		String ColumnPossition = String.valueOf(getElementSize(driver, AdminManagerCustomerPageUI.COLUMN_NAME_POSITION)+1);
		waitForElementClickable(driver, AdminManagerCustomerPageUI.TEXTBOX_BY_COLUMN_POSITION,ColumnPossition);
		sendkeyToELement(driver, AdminManagerCustomerPageUI.TEXTBOX_BY_COLUMN_POSITION,email);
		sleepInSecond(1);
	}

	public AdminManagerCustomerPageObject clickSearchButton() {
		waitForElementVisible(driver,AdminManagerCustomerPageUI.CLICK_SEARCH_BUTTON);
		clickToELement(driver, AdminManagerCustomerPageUI.CLICK_SEARCH_BUTTON);
		sleepInSecond(1);
		return PageGenerator.openAdminManagerCustomerPage(driver);
	}

	public boolean isLoadingIconDisappear() {
		waitForElementVisible(driver,AdminManagerCustomerPageUI.LOADING_ICON);
		return isElementDisplay(driver,AdminManagerCustomerPageUI.LOADING_ICON);
	}

	public boolean isUserInforDisplayedInTable(String email) {
		waitForElementVisible(driver,AdminManagerCustomerPageUI.FULLNAME_AND_EMAIL_IN_TABLE, email);
		return isElementDisplay(driver,AdminManagerCustomerPageUI.FULLNAME_AND_EMAIL_IN_TABLE, email);
	}

	public void closePopupWindown() {
		waitForElementVisible(driver,AdminManagerCustomerPageUI.CLOSE_POPUP_WINDOW);
		clickToELement(driver,AdminManagerCustomerPageUI.CLOSE_POPUP_WINDOW);
	}

}
