package com.jquery;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import HomePageObjectJquery.HomePageObjectJquery;
import commons.BaseTest;
import commons.PageGenerator;
import pageUI.jquery.HomePageUIJquery;

public class Level09_Data_Table extends BaseTest {
	WebDriver driver;
	HomePageObjectJquery homePage;
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void BeforeClass(String browserName, String url) {
		driver = getBrowserName(browserName,url);
		homePage = PageGenerator.getHomePageJquery(driver);
		
	}
	
	@Test
	public void TC_01_DataTable() {
		//Phân trang => Chuyển trang xong phải verify được là đã chuyển thành công
		homePage.openPagingPageByName("15");
		Assert.assertTrue(homePage.isPageActiveByName("15"));
		homePage.openPagingPageByName("10");
		Assert.assertTrue(homePage.isPageActiveByName("10"));
		
		homePage.openPagingPageByName("24");
		Assert.assertTrue(homePage.isPageActiveByName("24"));
		
		homePage.openPagingPageByName("1");
		Assert.assertTrue(homePage.isPageActiveByName("1"));
	}
	
	public void TC_03_Verify_Row() throws InterruptedException {	
		homePage.enterToHeaderTextboxByName("Females", "15999");
		homePage.enterToHeaderTextboxByName("Country", "Angola");
		homePage.enterToHeaderTextboxByName("Males", "1205");
		homePage.enterToHeaderTextboxByName("Total", "1873");
		
		homePage.refreshCurrentPage(driver);
		homePage.enterToHeaderTextboxByName("Country", "Afghanistan");
		Assert.assertTrue(homePage.isRowValuesDisplayed("384187","Afghanistan","407124","791312"));
		System.out.println(HomePageUIJquery.ROW_BY_ALL_VALUES);
		
		homePage.refreshCurrentPage(driver);
		homePage.enterToHeaderTextboxByName("Total", "1504");
		Assert.assertTrue(homePage.isRowValuesDisplayed("750","Aruba","756","1504"));
	}
	
	public void TC_04_Delete_Edit_Row() {
		homePage.refreshCurrentPage(driver);
		homePage.rowActionByCountryAndName("Afghanistan","remove");
		homePage.rowActionByCountryAndName("Armenia","remove");
		homePage.rowActionByCountryAndName("Australia","remove");
		homePage.rowActionByCountryAndName("Angola","edit");
		homePage.rowActionByCountryAndName("Aruba","edit");
	}

	public void TC_05_Editable() {
		homePage.openPageUrl(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		homePage.enterToTextboxAtColumnNameAndRowNumber("Order Placed","3","1234577");
		homePage.enterToTextboxAtColumnNameAndRowNumber("Company","1","Humax Vina");
		homePage.enterToTextboxAtColumnNameAndRowNumber("Contact Person","2","Automation");
	}
	@Test
	public void TC_06_Edit_Button() {
		homePage.openPageUrl(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		homePage.chooseToDropDownListColumnAndRowNumber("2","4","Malaysia");
		homePage.clickButtonByColumnAndRowNumber("2","insert");
		homePage.clickButtonByColumnAndRowNumber("1","remove");
		homePage.clickButtonByColumnAndRowNumber("2","moveUp");
		homePage.clickButtonByColumnAndRowNumber("2","moveDown");
		
	}
}
