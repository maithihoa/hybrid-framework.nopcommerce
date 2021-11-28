package classAndObject;

public class HomePageObject {
	public static HomePageObject getHomePage() {
		return new HomePageObject();
	}	
	public void clickToPaymentButton() {
		System.out.println("call click to payment...");
	}
	public static void clickToLogin() {
		System.out.println("call login...");
	}
}
