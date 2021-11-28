package classAndObject;

public class TestCase extends HomePageObject{
	public static void main(String[] args) {
		HomePageObject homePage = getHomePage();
		
		homePage.clickToPaymentButton();
	}
}
