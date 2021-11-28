package pageObject.alada;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.alada.loginPageUI;

public class LoginPageObject extends BasePage{
	private WebDriver driver;
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void enterToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, loginPageUI.EMAIL_TEXTBOX);
		sendkeyToELement(driver, loginPageUI.EMAIL_TEXTBOX, emailAddress);
		//input[@id='txtLoginUsername']
		//input[@id='txtLoginPassword']
		//form[@id='frmLogin']//button[text()='ĐĂNG NHẬP']
		
	}
	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, loginPageUI.PASSWORD_TEXTBOX);
		sendkeyToELement(driver, loginPageUI.PASSWORD_TEXTBOX, password);
		
	}
	public void clickLoginButton() {
		waitForElementClickable(driver, loginPageUI.LOGIN_BUTTON);
		clickToELement(driver, loginPageUI.LOGIN_BUTTON);
		
	}
	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, loginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, loginPageUI.EMAIL_ERROR_MESSAGE);
	}
	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, loginPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, loginPageUI.PASSWORD_ERROR_MESSAGE);
	}
	public String getErrorMessageAtLoginForm() {
		waitForElementVisible(driver, loginPageUI.LOGIN_FORM_ERROR_MESSAGE);
		return getElementText(driver, loginPageUI.LOGIN_FORM_ERROR_MESSAGE);
	}

}
