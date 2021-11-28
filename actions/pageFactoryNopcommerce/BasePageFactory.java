package pageFactoryNopcommerce;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageFactory {
	private WebDriver driver;
	
	public BasePageFactory(WebDriver driver) {
		this.driver = driver;
	}
	
	//Action: sendkeys, select, click... return void
	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}
	// Verify: getTitle, getUrl, Get Attribute, text, css, display ....then return value
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}
	
	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}
	
	public Alert waitForAlertPresent(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void acceptAlert (WebDriver driver) {
		alert = waitForAlertPresent(driver);
		alert.accept();
	}
	
	public void cancelAlert (WebDriver driver) {
		alert = waitForAlertPresent(driver);
		alert.dismiss();
	}
	
	public void getTextAlert (WebDriver driver) {
		alert = waitForAlertPresent(driver);
		alert.getText();
	}
	
	public void sendkeyAlert (WebDriver driver, String value) {
		alert = waitForAlertPresent(driver);
		alert.sendKeys(value);
	}
	
	public void switchToWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow:allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}
	
	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow:allWindows) {
			driver.switchTo().window(runWindow);
			String currentWindow = driver.getTitle();
			if (!currentWindow.equals(title)) {
				break;
			}
		}
	}
	
	public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow:allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				driver.close();
			}
		}
	}
	
	public void SleepInSecond(long time) {
		try{
			Thread.sleep(time + 1000);
		} catch (InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public void clickToElement(WebElement element) {
		waitForELementClickAble(element).click();

	}
	
	public WebElement waitForELementClickAble (WebElement element) {
		explicitWait = new WebDriverWait (driver, longTimeout);
		return explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void sendkeyToELement (WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
	public String getElementText(WebElement element) {
		return element.getText();
	}
	public boolean isElementDisplayed( WebElement element) {
		return waitForElementVisible(element).isDisplayed();
	}
	public WebElement waitForElementVisible( WebElement element) {
		explicitWait = new WebDriverWait (driver, longTimeout);
		return explicitWait.until(ExpectedConditions.visibilityOf(element));
	}
	public boolean isElementSelected( WebElement element) {
		return element.isSelected();
	}
	public void selectItemInDefaultDropdown( WebElement element, String itemText) {
		select = new Select(element);
		select.selectByVisibleText(itemText);
	}
	public String getFirstSelectedItemInDefaultDropdown(WebElement element) {
		select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}
	public String getAttributeValue(WebElement element, String attributeName) {
		return element.getAttribute(attributeName);
	}
	
	private Alert alert;
	private Select select;
	private long longTimeout = 30;
	private WebDriverWait explicitWait;
	
	
}
