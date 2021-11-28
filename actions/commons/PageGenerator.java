package commons;

import org.openqa.selenium.WebDriver;

import HomePageObjectJquery.HomePageObjectJquery;
import HomePageObjectJquery.HomeUploadPageObject;
import PageObjects.nopcommerce.AddressesPageObject;
import PageObjects.nopcommerce.BackInStockSubScriptionPageObject;
import PageObjects.nopcommerce.ChangePasswordPageObject;
import PageObjects.nopcommerce.CustomerInfoPageObject;
import PageObjects.nopcommerce.DownloadableProductPageObject;
import PageObjects.nopcommerce.HomePageObject;
import PageObjects.nopcommerce.LoginPageObject;
import PageObjects.nopcommerce.MyProductsReviewsPageObject;
import PageObjects.nopcommerce.OrdersPageObject;
import PageObjects.nopcommerce.RegisterPageObject;
import PageObjects.nopcommerce.RewardsPointsPageObject;

public class PageGenerator {
	private WebDriver driver;
	public PageGenerator(WebDriver _driver) {
		driver = _driver;
	}
	//Nhiệm vụ của trang này là quản lý việc khởi tạo các page object class
	//Tránh khởi tạo ở nhiều chỗ khác nhau
	//che giấu việc khởi tạo nhiều lần ở các page khác thông qua việc new nhiều lần ở nhiều nơi
	//mỗi page chỉ có 1 hàm để gọi khởi tạo
	public static HomeUploadPageObject getHomeUploadPage(WebDriver driver) {
		return new HomeUploadPageObject(driver);
	}
	public static HomePageObjectJquery getHomePageJquery(WebDriver driver) {
		return new HomePageObjectJquery(driver);
	}
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	public static LoginPageObject getLoginPageObject(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	public static CustomerInfoPageObject getCustomerInfoPageObject(WebDriver driver) {
		return new CustomerInfoPageObject(driver);
	}
	public static RegisterPageObject getRegisterPageObject(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	public static MyProductsReviewsPageObject getMyProductsReviewsPageObject(WebDriver driver) {
		return new MyProductsReviewsPageObject(driver);
	}
//	public static MyAccountPageObject getMyAccountPageObject() {
//		return new MyAccountPageObject();
//	}
	public static AddressesPageObject getAddressesPageObject(WebDriver driver) {
		return new AddressesPageObject(driver);
	}
	public static DownloadableProductPageObject getDownloadableProductPageObject(WebDriver driver) {
		return new DownloadableProductPageObject(driver);
	}
	public static BackInStockSubScriptionPageObject getBackInStockSubScriptionPageObject(WebDriver driver) {
		return new BackInStockSubScriptionPageObject(driver);
	}
	public static RewardsPointsPageObject getRewardsPointsPageObject(WebDriver driver) {
		return new RewardsPointsPageObject(driver);
	}
	public static ChangePasswordPageObject getChangePasswordPageObject(WebDriver driver) {
		return new ChangePasswordPageObject(driver);
	}
	public static OrdersPageObject getOrdersPageObject(WebDriver driver) {
		return new OrdersPageObject(driver);
	}

}
