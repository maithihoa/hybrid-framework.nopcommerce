package HomePageObjectJquery;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.jquery.HomePageUploadUI;

public class HomeUploadPageObject extends BasePage{
	private WebDriver driver;

	public HomeUploadPageObject (WebDriver driver) {
		this.driver = driver;
	}

	public boolean isLoadedFilesDisplay(String fileName) {
		waitForElementVisible(driver,HomePageUploadUI.FILE_NAME_LOADED_TEXT,fileName);
		return isElementDisplay(driver,HomePageUploadUI.FILE_NAME_LOADED_TEXT,fileName);
	}

	public void UploadFiles(String fileName1,String fileName2,String fileName3) {
		UploadMultipleFiles(driver,HomePageUploadUI.ADD_FILE_BUTTON,fileName1,fileName2,fileName3);
		sleepInSecond(1);
		
	}

	public void clickToStartButton(String buttonOfFilename) {
		waitForElementClickable(driver,HomePageUploadUI.CLICK_START_BUTTON,buttonOfFilename);
		clickToELement(driver,HomePageUploadUI.CLICK_START_BUTTON,buttonOfFilename);
		sleepInSecond(2);
	}

	public boolean isUploadFileSuccessful(String fileName) {
		waitForElementVisible(driver,HomePageUploadUI.UPLOAD_FILE_NAME_WITH_LOADED_TEXT,fileName);
		return isElementDisplay(driver,HomePageUploadUI.UPLOAD_FILE_NAME_WITH_LOADED_TEXT,fileName);
	}


}
