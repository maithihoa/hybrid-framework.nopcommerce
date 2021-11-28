package PageObjectLiveGuru99;

import org.openqa.selenium.WebDriver;

public class PageGenerator {
	public static AdminHomePageObject openAdminHomePage(WebDriver driver) {
		return new AdminHomePageObject(driver);
	}
	public static AdminManagerCustomerPageObject openAdminManagerCustomerPage(WebDriver driver) {
		return new AdminManagerCustomerPageObject(driver);
	}
	public static UserDashboardPageObject openUserDashboardPage(WebDriver driver) {
		return new UserDashboardPageObject(driver);
	}
	public static UserRegisterPageObject openUserRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}
	public static UserLoginPageObject openUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}
	public static UserHomePageObject openUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}
}
