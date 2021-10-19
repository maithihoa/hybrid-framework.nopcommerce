package commons;



import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.nopcommerce.AddressesPageObject;
import PageObjects.nopcommerce.BackInStockSubScriptionPageObject;
import PageObjects.nopcommerce.ChangePasswordPageObject;
import PageObjects.nopcommerce.CustomerInfoPageObject;
import PageObjects.nopcommerce.DownloadableProductPageObject;
import PageObjects.nopcommerce.MyProductsReviewsPageObject;
import PageObjects.nopcommerce.OrdersPageObject;
import PageObjects.nopcommerce.PageGenerator;
import PageObjects.nopcommerce.RewardsPointsPageObject;
import PageUIs.nopcommerce.AddressesPageUI;
import PageUIs.nopcommerce.BasePageUI;
import PageUIs.nopcommerce.CustomerInfoPageUI;
import PageUIs.nopcommerce.MyProductReviewsPageUI;
import PageUIs.nopcommerce.OrdersPageUI;

public class BasePage {
	private  WebDriver driver;
	public static BasePage getBasePage() {
		return new BasePage();
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
	
	public void switchToWindowWi(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow:allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				driver.close();
			}
		}
	}
	
	public By getByXpath(String locator) {
		return By.xpath(locator);
	}
	
	public WebElement getWebElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}
	
	public List<WebElement> getWebElements(WebDriver driver, String locator){
		return driver.findElements(getByXpath(locator));
	}
	
	public void clickToELement (WebDriver driver, String locator) {
		waitForElementClickable(driver, locator).click();
	}
	
	public void sendkeyToELement (WebDriver driver, String locator, String value) {
		getWebElement(driver, locator).clear();
		getWebElement(driver, locator).sendKeys(value);
	}
	
	public void selectItemInDefaultDropdown(WebDriver driver, String locator, String itemText) {
		select = new Select(getWebElement(driver, locator));
		select.selectByVisibleText(itemText);
	}
	
	public boolean isDropDownMultiple(WebDriver driver, String locator) {
		select = new Select(getWebElement(driver, locator));
		return select.isMultiple();
	}
	
	public String getFirstSelectedItemInDefaultDropdown(WebDriver driver, String locator) {
		select = new Select(getWebElement(driver, locator));
		return select.getFirstSelectedOption().getText();
	}
	
	public void selectItemInCustomDropdown(WebDriver driver, String parentLocation,String childItemLocator, String expectedItem) {
		getWebElement(driver, parentLocation);
		SleepInSecond(1);
		
		explicitWait = new WebDriverWait (driver, longTimeout);
		List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));
				for(WebElement item:allItems) {
					if (item.getText().trim().equals(expectedItem)) {
						jsExecutor = (JavascriptExecutor) driver;
						jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
						SleepInSecond(1);
						
						item.click();
						SleepInSecond(1);
						break;
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
	
	public String getAttributeValue(WebDriver driver, String locator, String attributeName) {
		return getWebElement(driver,locator).getAttribute(attributeName);
	}
	
	public String getElementText(WebDriver driver, String locator) {
		return getWebElement(driver,locator).getText();
	}
	
	public String getCSSValue(WebDriver driver, String locator, String propertyName) {
		return getWebElement(driver,locator).getCssValue(propertyName);
	}
	
	public int getElementSize(WebDriver driver, String locator, String propertyName ) {
		return getWebElements(driver,locator).size();
	}
	
	public void checkToCheckbox(WebDriver driver, String locator) {
		if (!getWebElement(driver,locator).isSelected()) {
			waitForElementClickable(driver,locator).click();
		}
	}
	public void checkToCheckboxRadio(WebDriver driver, String locator) {
			waitForElementClickable(driver,locator).click();
	}
	public void unCheckToCheckbox(WebDriver driver, String locator) {
		if (getWebElement(driver,locator).isSelected()) {
			waitForElementClickable(driver,locator).click();
		}
	}
	
	public boolean isElementDisplay(WebDriver driver, String locator) {
		return waitForElementVisible(driver,locator).isDisplayed();
	}
	
	public boolean isElementEnable(WebDriver driver, String locator) {
		return waitForElementVisible(driver,locator).isEnabled();
	}
	
	public boolean isElementSelected(WebDriver driver, String locator) {
		return waitForElementVisible(driver,locator).isSelected();
	}
	
	public void switchToFrame(WebDriver driver, String locator) {
		driver.switchTo().frame(getWebElement(driver,locator));
	}
	
	public void switchToDefaultPage(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void doubleClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.doubleClick(getWebElement(driver,locator)).perform();
	}
	
	public void moveMouseToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.moveToElement(getWebElement(driver,locator)).perform();
	}
	
	public void rightClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.contextClick(getWebElement(driver,locator)).perform();
	}
	
	public void dragAndDrop(WebDriver driver, String sourceLocator, String targetLocator) {
		action = new Actions(driver);
		action.dragAndDrop(getWebElement(driver,sourceLocator), getWebElement(driver,targetLocator)).perform();
	}
	
	public void sendkeyBoardToElement(WebDriver driver, String locator, Keys key) {
		action = new Actions(driver);
		action.sendKeys(getWebElement(driver,locator), key).perform();
	}
	
	public String convertRGBAToHexa(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}
	
	public void uploadToElement(WebDriver driver, String locator, String filePath) {
		getWebElement(driver,locator).sendKeys(filePath);
	}
	
	public Object executeForBrowser(String javaScript) {
		return jsExecutor.executeScript(javaScript);
	}
	
	public String getInnerText() {
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}
	
	public boolean areExpectedTextInInnerText(String textExpected) {
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
		return textActual.equals(textExpected);
	}
	
	public void scrollToBottomPage() {
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	public void navigateToUrlByJS(String url) {
		jsExecutor.executeScript("window.location = '" + url + "'");
	}
	
	public void highlightElement(WebDriver driver, String locator) {
		WebElement element = getWebElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		SleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}
	
	public void clickToElementByJS(WebDriver driver, String locator) {
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locator));
	}
	
	public void scrollToElement(WebDriver driver, String locator) {
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver,locator));
	}
	
	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getWebElement(driver,locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locator));
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof"
	+"arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver,locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	
	public WebElement waitForElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}
	
	public WebElement waitForElementClickable(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}
	
	public boolean waitForElementInvisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
	}
	public AddressesPageObject clickAddressesPage(WebDriver driver) {
		waitForElementInvisible(driver,BasePageUI.ADDRESSES_PAGE_LINK);
		clickToELement(driver, BasePageUI.ADDRESSES_PAGE_LINK);
		SleepInSecond(3);
		return PageGenerator.getAddressesPageObject(driver);
	}
	public DownloadableProductPageObject getDownloadProductsPage(WebDriver driver) {
		waitForElementInvisible(driver,BasePageUI.DOWNLOADABLE_PRODUCTS_PAGE_LINK);
		clickToELement(driver, BasePageUI.DOWNLOADABLE_PRODUCTS_PAGE_LINK);
		SleepInSecond(3);
		return PageGenerator.getDownloadableProductPageObject(driver);
	}
	public MyProductsReviewsPageObject clickMyProductReviewPage(WebDriver driver) {
		waitForElementInvisible(driver,BasePageUI.MY_PRODUCT_REVIEWS_PAGE_LINK);
		clickToELement(driver, BasePageUI.MY_PRODUCT_REVIEWS_PAGE_LINK);
		SleepInSecond(3);
		return PageGenerator.getMyProductsReviewsPageObject(driver);
	}
	public ChangePasswordPageObject clickChangePasswordPage(WebDriver driver) {
		waitForElementInvisible(driver,BasePageUI.CHANGE_PASSWORD_PAGE_LINK);
		clickToELement(driver, BasePageUI.CHANGE_PASSWORD_PAGE_LINK);
		SleepInSecond(3);
		return PageGenerator.getChangePasswordPageObject(driver);
	}
	public BackInStockSubScriptionPageObject getBackInStockSubScriptionPage(WebDriver driver) {
		waitForElementInvisible(driver,BasePageUI.BACK_IN_STOCK_SUBSCRIPTION_PAGE_LINK);
		clickToELement(driver, BasePageUI.BACK_IN_STOCK_SUBSCRIPTION_PAGE_LINK);
		SleepInSecond(3);
		return PageGenerator.getBackInStockSubScriptionPageObject(driver);
	}
	public RewardsPointsPageObject clickRewardsPoints(WebDriver driver) {
		waitForElementInvisible(driver,BasePageUI.CHANGE_PASSWORD_PAGE_LINK);
		clickToELement(driver, BasePageUI.CHANGE_PASSWORD_PAGE_LINK);
		SleepInSecond(3);
		return PageGenerator.getRewardsPointsPageObject(driver);
	}
	public OrdersPageObject getOrderPage(WebDriver driver) {
		waitForElementInvisible(driver,BasePageUI.ORDER_PAGE_LINK);
		clickToELement(driver, BasePageUI.ORDER_PAGE_LINK);
		SleepInSecond(3);
		return PageGenerator.getOrdersPageObject(driver);
	}	
	public CustomerInfoPageObject clickCustomerInforPage(WebDriver driver) {
		waitForElementInvisible(driver,BasePageUI.CUSTOMER_INFO_PAGE_LINK);
		clickToELement(driver, BasePageUI.CUSTOMER_INFO_PAGE_LINK);
		SleepInSecond(3);
		return PageGenerator.getCustomerInfoPageObject(driver);
	}

	private Alert alert;
	private Select select;
	private Actions action;
	private long longTimeout = 30;
	private long shortTimeOut = 5;
	private WebDriverWait explicitWait;
	private JavascriptExecutor jsExecutor;
	
}
