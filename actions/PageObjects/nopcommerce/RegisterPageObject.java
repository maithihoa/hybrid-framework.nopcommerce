package PageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import PageUIs.nopcommerce.RegisterPageUI;
import commons.BasePage;

public class RegisterPageObject extends BasePage{
	private WebDriver driver;
	
	public RegisterPageObject(WebDriver _driver) {
		driver = _driver;
	}
	public void clickToGenderMaleRadio() {
		waitForElementClickable(driver, RegisterPageUI.GENDER_MALE_RADIO);
		clickToELement(driver, RegisterPageUI.GENDER_MALE_RADIO);
		
	}

	public void enterToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToELement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
		
	}

	public void enterToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
		sendkeyToELement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastName);
		
	}

	public void selectDayDropdown(String day) {
		waitForElementVisible(driver, RegisterPageUI.DAY_DROPDOWN);
		selectItemInDefaultDropdown(driver,RegisterPageUI.DAY_DROPDOWN,day);
		
	}

	public void selectMonthDropdown(String month) {
		waitForElementVisible(driver, RegisterPageUI.MONTH_DROPDOWN);
		selectItemInDefaultDropdown(driver,RegisterPageUI.MONTH_DROPDOWN,month);
		
	}

	public void selectYearDropdown(String year) {
		waitForElementVisible(driver, RegisterPageUI.YEAR_DROPDOWN);
		selectItemInDefaultDropdown(driver,RegisterPageUI.YEAR_DROPDOWN,year);
		
	}

	public void enterToEmailTextbox(String email) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToELement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
		
	}

	public void enterToCompanyTextbox(String company) {
		waitForElementVisible(driver, RegisterPageUI.COMPANY_TEXTBOX);
		sendkeyToELement(driver, RegisterPageUI.COMPANY_TEXTBOX, company);
		
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToELement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public void enterToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToELement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
		
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToELement(driver, RegisterPageUI.REGISTER_BUTTON);
		
	}

	public boolean isRegisterSuccessMessageDisplay() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return isElementDisplay(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	public void clickToLogout() {
		waitForElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToELement(driver, RegisterPageUI.LOGOUT_LINK);
		
	}
	
}
