package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

		private WebDriver driver;
		String ProjectPath = System.getProperty("user.dir");
		protected final Log log;
		//constructor
		protected BaseTest() {
			log = LogFactory.getLog(getClass());
		}
		private enum Browser{
			CHROME,FIREFOX,EDGE,COCCOC,OPERA
		}
		protected WebDriver getBrowserName(String browserName, String url) {
			Browser browser = Browser.valueOf(browserName.toUpperCase());
//			if(browser == Browser.CHROME){
//				System.setProperty("webdriver.chrome.driver", ProjectPath + "\\browserDriver\\chromedriver.exe");
//				driver = new ChromeDriver();
//			} else if(browser == Browser.FIREFOX) {
//				System.setProperty("webdriver.gecko.driver", ProjectPath + "\\browserDriver\\geckodriver.exe");
//				driver = new FirefoxDriver();
//			} else if (browser == Browser.EDGE){
//				System.setProperty("webdriver.edge.driver", ProjectPath + "\\browserDriver\\msedgedriver.exe");
//				driver = new EdgeDriver();
//			} else {
//				throw new RuntimeException("Browser name is not correct");
//			}
//			
			switch(browser) {
			case CHROME:
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case FIREFOX:
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case EDGE:
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			case COCCOC:
				WebDriverManager.chromedriver().driverVersion("92.0.4515.107").setup();
				ChromeOptions options = new ChromeOptions();
				options.setBinary("C:\\Program Files (x86)\\CocCoc\\Browser\\Application\\browser.exe");
				driver = new ChromeDriver(options);
				break;
			case OPERA:
				WebDriverManager.operadriver().setup();
				driver = new OperaDriver();
				break;
			default:
				throw new RuntimeException("Browser name is not correct");
			}
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			return driver;
	}
		protected String randEmail() {
			Random rand = new Random();
			return "hoamt" + rand.nextInt() + "@gmail.com";
		}
		private boolean checkTrue(boolean condition) {
			boolean pass = true;
			try {
				if (condition == false) {
					log.info(" -------------------------- PASSED -------------------------- ");
				} else {
					log.info(" -------------------------- FAILED -------------------------- ");
				}
				Assert.assertFalse(condition);
			} catch (Throwable e) {
				pass = false;
				VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
				Reporter.getCurrentTestResult().setThrowable(e);
			}
			return pass;
		}

		protected boolean verifyTrue(boolean condition) {
			return checkTrue(condition);
		}

		private boolean checkFailed(boolean condition) {
			boolean pass = true;
			try {
				if (condition == false) {
					log.info(" -------------------------- PASSED -------------------------- ");
				} else {
					log.info(" -------------------------- FAILED -------------------------- ");
				}
				Assert.assertFalse(condition);
			} catch (Throwable e) {
				pass = false;
				VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
				Reporter.getCurrentTestResult().setThrowable(e);
			}
			return pass;
		}

		protected boolean verifyFalse(boolean condition) {
			return checkFailed(condition);
		}

		private boolean checkEquals(Object actual, Object expected) {
			boolean pass = true;
			try {
				Assert.assertEquals(actual, expected);
				log.info(" -------------------------- PASSED -------------------------- ");
			} catch (Throwable e) {
				pass = false;
				log.info(" -------------------------- FAILED -------------------------- ");
				VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
				Reporter.getCurrentTestResult().setThrowable(e);
			}
			return pass;
		}

		protected boolean verifyEquals(Object actual, Object expected) {
			return checkEquals(actual, expected);
		}
}
