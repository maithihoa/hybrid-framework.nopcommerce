package pageFactoryNopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PageUIs.nopcommerce.LoginPageUI;
import PageUIs.nopcommerce.RegisterPageUI;

public class RegisterPageObject extends BasePageFactory {

		private WebDriver driver;
		
	public RegisterPageObject(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="gender-male")
	private WebElement genderMaleRadio;
	@FindBy(id="FirstName")
	private WebElement firstNameTextbox;
	@FindBy(id="LastName")
	private WebElement lastNameTextbox;
	@FindBy(name="DateOfBirthDay")
	private WebElement dateOfBirthDay;
	@FindBy(name="DateOfBirthMonth")
	private WebElement dateOfBirthMonth;
	@FindBy(name="DateOfBirthYear")
	private WebElement dateOfBirthYear;
	@FindBy(id="Email")
	private WebElement emailTextbox;
	@FindBy(id="Company")
	private WebElement companyTextbox;
	@FindBy(id="Password")
	private WebElement passwordTextbox;
	@FindBy(id="ConfirmPassword")
	private WebElement confirmPasswordTextbox;
	@FindBy(id="register-button")
	private WebElement registerButton;
	@FindBy(xpath="//div[@class='result' and text()='Your registration completed']")
	private WebElement registerSuccessMessage;
	@FindBy(css="a[class='ico-logout']")
	private WebElement logoutLink;
	
	public void clickToGenderMaleRadio() {
		waitForELementClickAble(genderMaleRadio);
		clickToElement(genderMaleRadio);
		
	}

	public void enterToFirstNameTextbox(String firstName) {
		waitForElementVisible(firstNameTextbox);
		sendkeyToELement(firstNameTextbox, firstName);
		
	}

	public void enterToLastNameTextbox(String lastName) {
		waitForElementVisible(lastNameTextbox);
		sendkeyToELement(lastNameTextbox, lastName);
		
	}

	public void selectDayDropdown(String day) {
		waitForElementVisible(dateOfBirthDay);
		selectItemInDefaultDropdown(dateOfBirthDay,day);
		
	}

	public void selectMonthDropdown(String month) {
		waitForElementVisible( dateOfBirthMonth);
		selectItemInDefaultDropdown(dateOfBirthMonth,month);
		
	}

	public void selectYearDropdown(String year) {
		waitForElementVisible(dateOfBirthYear);
		selectItemInDefaultDropdown(dateOfBirthYear,year);
		
	}

	public void enterToEmailTextbox(String email) {
		waitForElementVisible(emailTextbox);
		sendkeyToELement(emailTextbox, email);
		
	}

	public void enterToCompanyTextbox(String company) {
		waitForElementVisible(companyTextbox);
		sendkeyToELement(companyTextbox, company);
		
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(passwordTextbox);
		sendkeyToELement(passwordTextbox, password);
		
	}

	public void enterToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(confirmPasswordTextbox);
		sendkeyToELement(confirmPasswordTextbox, confirmPassword);
		
	}

	public void clickToRegisterButton() {
		waitForELementClickAble(registerButton);
		clickToElement(registerButton);
		
	}

	public boolean isRegisterSuccessMessageDisplay() {
		waitForELementClickAble(registerSuccessMessage);
		return isElementDisplayed(registerSuccessMessage);
	}

	public void clickToLogout() {
		waitForELementClickAble(logoutLink);
		clickToElement(logoutLink);
		
	}
	
}
