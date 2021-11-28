package com.jquery;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import HomePageObjectJquery.HomeUploadPageObject;
import commons.BaseTest;
import commons.PageGenerator;

public class Upload_File_Jquery extends BaseTest{
	private WebDriver driver;
	HomeUploadPageObject homePage;
	String dellName = "dell.png";
	String thinkpadName = "thinkpad.png";
	String desktopName = "desktop.png";
	String ProjectLocation = System.getProperty("user.dir");
	@Parameters({"browser","url"})
	@BeforeTest
	public void Beforetest (String browser, String url) {
		driver = getBrowserName(browser, url);
		homePage = PageGenerator.getHomeUploadPage(driver);
	}
	@Test
	public void Upload_3_File() {
		homePage.refreshCurrentPage(driver);
		
		homePage.UploadFiles(dellName,thinkpadName,desktopName);
		Assert.assertTrue(homePage.isLoadedFilesDisplay(dellName));
		Assert.assertTrue(homePage.isLoadedFilesDisplay(thinkpadName));
		Assert.assertTrue(homePage.isLoadedFilesDisplay(desktopName));
		
		homePage.clickToStartButton(dellName);
		homePage.clickToStartButton(thinkpadName);
		homePage.clickToStartButton(desktopName);
		
		Assert.assertTrue(homePage.isUploadFileSuccessful(dellName));
		Assert.assertTrue(homePage.isUploadFileSuccessful(thinkpadName));
		Assert.assertTrue(homePage.isUploadFileSuccessful(desktopName));
	}
}
