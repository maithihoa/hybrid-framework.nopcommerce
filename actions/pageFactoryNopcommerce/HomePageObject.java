package pageFactoryNopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageObject extends BasePageFactory {
	private WebDriver driver;
	WebDriverWait explicitWait;
	
	public HomePageObject (WebDriver driver) {
		super (driver);
		//Init Elements
		PageFactory.initElements(driver, this);
	}
	//Page object: locator
	@FindBy(how = How.XPATH, using = "//a[@class='ico-register']")
	private WebElement registerLink;
	
	
	@FindBy(how = How.CSS, using = "a[class='ico-login']")
	private WebElement loginLink;
	
	
	@FindBy(how = How.XPATH, using = "//a[@class='ico-account']")
	private WebElement myAccountLink;
	
	
	// Page UI: action
	public void clickToRegisterLink() {
		explicitWait.until(ExpectedConditions.elementToBeClickable(registerLink));
		clickToElement(registerLink);
	}

	public void clickToLoginLink() {
		explicitWait.until(ExpectedConditions.elementToBeClickable(loginLink));
		clickToElement(loginLink);
	}

	public void clickToMyAccountLink() {
		explicitWait.until(ExpectedConditions.elementToBeClickable(myAccountLink));
		clickToElement(myAccountLink);
	}
}
