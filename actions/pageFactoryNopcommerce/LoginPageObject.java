package pageFactoryNopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject extends BasePageFactory {

		private WebDriver driver;
		
	public LoginPageObject(WebDriver _driver) {
		super(_driver);
		PageFactory.initElements(_driver, this);
	}
	@FindBy(how = How.ID, using = "Email")
	private WebElement emailTextbox;
	
	
	@FindBy(how = How.ID, using = "Password")
	private WebElement passwordTextbox;
	
	
	@FindBy(how = How.XPATH, using = "//button[text()='Log in']")
	private WebElement loginButton;
	
	public void enterToEmailTextbox(String emailAddress) {
		waitForElementVisible( emailTextbox);
		sendkeyToELement(emailTextbox, emailAddress);
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible( passwordTextbox);
		sendkeyToELement(passwordTextbox, password);
		
	}

	public void clickToLoginButton() {
		waitForElementVisible( loginButton);
		clickToElement(loginButton);
		
	}
}
