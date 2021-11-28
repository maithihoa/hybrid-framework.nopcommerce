package com.Facebook.register;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commons.BaseTest;

public class Level_12_Register_Login_Assert_verify extends BaseTest{
	WebDriver driver;
	String ProjectLocation = System.getProperty("user.dir");
	Boolean status=true;
	WebDriverWait expcitWait;
	int longTimeOut = 15;
	int shortTimeOut = 5;
	@BeforeTest
	public void BeforeTest() {
		System.setProperty("webdriver.gecko.driver", ProjectLocation + "/browserDriver/geckodriver.exe");
		driver = new FirefoxDriver();
		expcitWait = new WebDriverWait(driver,10);
		
	}
	@Test
	public void TC_01_Verify() {
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		sleepInSecond(2);
		driver.findElement(By.name("reg_email__")).sendKeys("hoamt.rtbed@gmail.com");
		status = isElementInvisible("reg_email_confirmation__");
		
		//fail lan 1
		verifyFalse(status);
		sleepInSecond(2);

		driver.get("https://shopee.vn/");
		sleepInSecond(2);
		driver.findElement(By.xpath("//div[@class='shopee-popup__close-btn']")).click();
		status = isElementInvisible("//div[@class='shopee-popup__close-btn']/preceding-sibling::a");
		
		//fail lan 2
		verifyFalse(status);
		System.out.println("Element display is: "+ status);

		driver.get("https://shopee.vn/");
		driver.findElement(By.xpath("//div[@class='shopee-popup__close-btn']")).click();
		
		status = isElementInvisible("//div[@class='shopee-popup__close-btn']/preceding-sibling::a");
		verifyTrue(status);
		System.out.println("Element display is: "+ status);
		
	}
	
	@Test
	public void TC_02_Verify() {
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		sleepInSecond(2);
		driver.findElement(By.name("reg_email__")).sendKeys("hoamt.rtbed@gmail.com");
		status = isElementInvisible("reg_email_confirmation__");

		//fail lan 3
		verifyFalse(status);
		sleepInSecond(2);

		driver.get("https://shopee.vn/");
		sleepInSecond(2);
		driver.findElement(By.xpath("//div[@class='shopee-popup__close-btn']")).click();
		status = isElementInvisible("//div[@class='shopee-popup__close-btn']/preceding-sibling::a");
		verifyTrue(status);
		System.out.println("Element display is: "+ status);

		driver.get("https://shopee.vn/");
		driver.findElement(By.xpath("//div[@class='shopee-popup__close-btn']")).click();
		
		status = isElementInvisible("//div[@class='shopee-popup__close-btn']/preceding-sibling::a");
		
		//fail lan 4
		verifyFalse(status);
		System.out.println("Element display is: "+ status);
		
	}
	
	public void overideTimeout(long Timeout) {
		driver.manage().timeouts().implicitlyWait(Timeout, TimeUnit.SECONDS);
	}
	// truong hop 1+2: Element display + co trong DOM
	public boolean isElementDisplay1And2(String locator) {
		try {
			WebElement  element = driver.findElement(By.xpath(locator));
			return element.isDisplayed();
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	//Truong hop 2+3 : Element khong display
	public boolean isElementDisplay2And3(String locator) {
		try {
			overideTimeout(shortTimeOut);
			WebElement  element = driver.findElement(By.xpath(locator));
			return element.isDisplayed();
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			overideTimeout(longTimeOut);
		}
	}
	//Truong hop 1 +2+3
	public boolean isElementInvisible(String locator) {
		overideTimeout(shortTimeOut);
		List<WebElement> elements= driver.findElements(By.xpath(locator));
		overideTimeout(longTimeOut);
		//th 3
		if(elements.size()==0) {
			System.out.println("Element not found");
			return true;
		}//th 2
		else if((elements.size()>0) && !elements.get(0).isDisplayed()){
			System.out.println("Element in DOM but not diplay on UI");
			return true;
		}//th 1
		else {
			System.out.println("Element in DOM and displays");
			return false;
		}
		
	}
	public void waitElementInvisible (String locator) {
		try {
			//set timeout ngan de chay cho nhanh
			overideTimeout(shortTimeOut);
			expcitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			//set lai timeout de chay cac step khac on dinh
			overideTimeout(longTimeOut);
		}
	}
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	public void sleepInSecond(long time) {
		try{
			Thread.sleep(time + 1000);
		} catch (InterruptedException e){
			e.printStackTrace();
		}
	}
}
