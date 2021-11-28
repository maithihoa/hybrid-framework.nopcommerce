package pageFactoryNopcommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class MyAccountPageObject extends BasePageFactory {
private WebDriver driver;
	public MyAccountPageObject(WebDriver _driver) {
		super(_driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "gender-male")
	private WebElement genderMaleRadio;
	
	
	@FindBy(how = How.ID, using = "FirstName")
	private WebElement firstNameTextbox;
	
	
	@FindBy(how = How.ID, using = "LastName")
	private WebElement lastNameTextbox;
	
	
	@FindBy(how = How.NAME, using = "DateOfBirthDay")
	private WebElement DayDropdown;
	
	
	@FindBy(how = How.NAME, using = "DateOfBirthMonth")
	private WebElement monthDropdown;
	
	
	@FindBy(how = How.NAME, using = "DateOfBirthYear")
	private WebElement yearDropdown;
	
	
	@FindBy(how = How.ID, using = "Email")
	private WebElement emailTextbox;
	
	
	@FindBy(how = How.ID, using = "Company")
	private WebElement companyTextbox;
	
	public boolean isGenderMaleRadioSelected() {
		waitForElementVisible(genderMaleRadio);
		return isElementSelected(genderMaleRadio);
	}

	public String getFirstNameTextboxValue() {
		waitForElementVisible(firstNameTextbox);
		return getAttributeValue(firstNameTextbox,"value");
	}

	public String getLastNameTextboxValue() {
		waitForElementVisible(lastNameTextbox);
		return getAttributeValue(lastNameTextbox, "value");
	}

	public String getEmailTextboxValue() {
		waitForElementVisible( emailTextbox);
		return getAttributeValue(emailTextbox,"value");
	}

	public String getCompanyNameTextboxValue() {
		waitForElementVisible(companyTextbox);
		return getAttributeValue(companyTextbox,"value");
	}

	public String getDateDropdownValue() {
		waitForElementVisible(DayDropdown);
		return getFirstSelectedItemInDefaultDropdown(DayDropdown);
	}

	public String getMonthDropdownValue() {
		waitForElementVisible(monthDropdown);
		return getFirstSelectedItemInDefaultDropdown(monthDropdown);
	}

	public String getYearDropdownValue() {
		waitForElementVisible(yearDropdown);
		return getFirstSelectedItemInDefaultDropdown(yearDropdown);
	}
	
}
