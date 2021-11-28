package HomePageObjectJquery;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.jquery.HomePageUIJquery;

public class HomePageObjectJquery extends BasePage {
	private WebDriver driver;
	
	public HomePageObjectJquery (WebDriver driver) {
		this.driver = driver;
	}
	public void openPagingPageByName(String values) {
		waitForElementClickable(driver, HomePageUIJquery.PAGE_NAME_LINK, values);
		clickToELement(driver, HomePageUIJquery.PAGE_NAME_LINK, values);
		sleepInSecond(2);
	}

	public boolean isPageActiveByName(String values) {
		waitForElementClickable(driver, HomePageUIJquery.PAGE_NAME_LINK, values);
		return isElementDisplay(driver,HomePageUIJquery.PAGE_NAME_LINK,values);
	}
	public void enterToHeaderTextboxByName(String headerName, String values) {
		waitForElementClickable(driver, HomePageUIJquery.SEND_HEADER_TEXTBOX_BY_NAME, headerName);
		sendkeyToELement(driver, HomePageUIJquery.SEND_HEADER_TEXTBOX_BY_NAME,values,headerName);
		sendkeyBoardToElement(driver, HomePageUIJquery.SEND_HEADER_TEXTBOX_BY_NAME, Keys.ENTER, headerName);
		sleepInSecond(3);
	}
	public boolean isRowValuesDisplayed(String Females, String Country, String Males, String Total) {
		waitForElementVisible(driver, HomePageUIJquery.ROW_BY_ALL_VALUES, Females,Country,Males,Total);
		return isElementDisplay(driver,HomePageUIJquery.ROW_BY_ALL_VALUES, Females,Country,Males,Total);
	}
	public void rowActionByCountryAndName(String Country, String Action) {
		waitForElementClickable(driver, HomePageUIJquery.ROW_DELETE_BY_COUNTRY_AND_NAME, Country, Action);
		clickToELement(driver, HomePageUIJquery.ROW_DELETE_BY_COUNTRY_AND_NAME,Country, Action);
		sleepInSecond(3);
	}
	public void enterToTextboxAtColumnNameAndRowNumber(String columnNumberBrothers, String row, String valueInput) {
		//get the number of Brothers of Actual column
		waitForElementVisible(driver,HomePageUIJquery.COLUMN_NUMBER_INDEX,columnNumberBrothers);
		String columnNumberActual = String.valueOf(getElementSize(driver,HomePageUIJquery.COLUMN_NUMBER_INDEX,columnNumberBrothers)+1) ;
		
		//sendkeys to Actual
		waitForElementVisible(driver,HomePageUIJquery.COLUMN_NAME_AND_ROW_NUMBER,row,columnNumberActual);
		sendkeyToELement(driver,HomePageUIJquery.COLUMN_NAME_AND_ROW_NUMBER, valueInput,row,columnNumberActual);
		
	}
	public void chooseToDropDownListColumnAndRowNumber(String rowNumber, String columnNumber, String value) {
		waitForElementVisible(driver,HomePageUIJquery.SELECT_DROP_DOWN_BY_COLUMN_NAME_AND_ROW_NUMBER,rowNumber,columnNumber,value);
		clickToELement(driver,HomePageUIJquery.SELECT_DROP_DOWN_BY_COLUMN_NAME_AND_ROW_NUMBER,rowNumber,columnNumber,value);
	}
	public void clickButtonByColumnAndRowNumber(String rowNumber, String value) {
		waitForElementClickable(driver,HomePageUIJquery.SELECT_BUTTON_BY_COLUMN_NAME_AND_ROW_NUMBER,rowNumber,value);
		clickToELement(driver,HomePageUIJquery.SELECT_BUTTON_BY_COLUMN_NAME_AND_ROW_NUMBER,rowNumber,value);
		sleepInSecond(1);	
	}
}


