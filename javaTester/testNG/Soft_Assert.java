package testNG;
	import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class Soft_Assert {
		WebDriver driver;
		SoftAssert soft;

		@BeforeClass
		public void beforeClass() {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			soft = new SoftAssert();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
		}

		@Test
		public void TC_01_Login_Empty_Email_Password() {
			System.out.println("Step 01 - Input to email textbox");
			driver.findElement(By.id("Email")).sendKeys("");

			System.out.println("Step 02 - Input to password textbox");
			driver.findElement(By.id("Password")).sendKeys("");
			
			System.out.println("Step 03 - Click to Login button");
			driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();

			// First Pass (5)
			System.out.println("Step 05 - Verify error message displayed");
			soft.assertEquals(driver.findElement(By.xpath("//span[@id='Email-error']")).getText(), "Please enter your email");

			// Second Fail (10)
			System.out.println("Step 10 - Verify error message displayed");
			soft.assertEquals(driver.findElement(By.id("Email-error")).getText(), "This is a required field");

			// Pass (45)
			System.out.println("Step 45 - Verify .....");
			soft.assertTrue(isElementDisplay("//button[@class='button-1 login-button']"));

			// Third Fail (50)
			System.out.println("Step 50 - Verify .....");
			soft.assertTrue(isElementDisplay("//button[@id='send_failed_not_found']"));

			// Pass (65)
			System.out.println("Step 65 - Verify .....");
			soft.assertTrue(isElementDisplay("//button[@class='button-1 register-button']"));

			// Fourth Fail (76)
			System.out.println("Step 76 - Verify .....");
			soft.assertTrue(isElementDisplay("//button[@id='send_failed_not_found']"));
			
			//Bat buoc phai co buoc nay thi moi chay qua het tat ca cac tc
			soft.assertAll();
		}

		@AfterClass
		public void afterClass() {
			driver.quit();
		}
		public boolean isElementDisplay(String locator) {
			try {
				WebElement element = driver.findElement(By.xpath(locator));
				return element.isDisplayed();
			}catch (Exception e){
				System.out.println("Exception = "+ e.getMessage());
				return false;
			}
		}

}
