package PageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import PageUIs.nopcommerce.HomePageUI;
import commons.BasePage;
import commons.PageGenerator;

public class HomePageObject extends BasePage{
	private WebDriver driver;
	
	public HomePageObject(WebDriver _driver) {
		driver = _driver;
		
	}
	// cho hàm trả về kiểu class, giống như trả về int, string như bt
	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToELement(driver, HomePageUI.REGISTER_LINK);
		// che giấu được việc khởi tạo đối tượng
		//2. return new RegisterPageObject(driver);
		return PageGenerator.getRegisterPageObject(driver);
	}

	public LoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToELement(driver, HomePageUI.LOGIN_LINK);
		return PageGenerator.getLoginPageObject(driver);
	}

	public CustomerInfoPageObject clickToMyAccountLink() {
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToELement(driver, HomePageUI.MY_ACCOUNT_LINK);
		if(driver.toString().contains("chrome") || driver.toString().contains("edge")){
			sleepInSecond(3);
		}
		return PageGenerator.getCustomerInfoPageObject(driver);
		
	}
	
}
