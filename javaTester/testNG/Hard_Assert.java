package testNG;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class Hard_Assert {
		WebDriver driver;

		@BeforeClass
		public void beforeClass() {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
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
			driver.findElement(By.xpath("//button[@class='button-1 login-button']"));

			// First Pass (5)
			System.out.println("Step 05 - Verify error message displayed");
			Assert.assertEquals(driver.findElement(By.id("Email-error")).getText(), "This is a required field.");

			// Second Fail (10)
			System.out.println("Step 10 - Verify error message displayed");
			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getText(), "This is a required field");

			// Pass (45)
			System.out.println("Step 45 - Verify .....");
			Assert.assertTrue(driver.findElement(By.xpath("//button[@class='button-1 login-button']")).isDisplayed());

			// Third Fail (50)
			System.out.println("Step 50 - Verify .....");
			Assert.assertTrue(driver.findElement(By.xpath("//button[@id='send_failed_not_found']")).isDisplayed());

			// Pass (65)
			System.out.println("Step 65 - Verify .....");
			Assert.assertTrue(driver.findElement(By.xpath("//button[@class='button-1 register-button']")).isDisplayed());

			// Fourth Fail (76)
			System.out.println("Step 76 - Verify .....");
			Assert.assertTrue(driver.findElement(By.xpath("//button[@id='send_failed_not_found']")).isDisplayed());
		}

		@AfterClass
		public void afterClass() {
			driver.quit();
		}

}
