package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class BaseTest {

		private WebDriver driver;
		String ProjectPath = System.getProperty("user.dir");
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
				System.setProperty("webdriver.chrome.driver", ProjectPath + "\\browserDriver\\chromedriver1.exe");
				driver = new ChromeDriver();
				break;
			case FIREFOX:
				System.setProperty("webdriver.gecko.driver", ProjectPath + "\\browserDriver\\geckodriver.exe");
				driver = new FirefoxDriver();
				break;
			case EDGE:
				System.setProperty("webdriver.edge.driver", ProjectPath + "\\browserDriver\\msedgedriver.exe");
				driver = new EdgeDriver();
				break;
			case COCCOC:
				System.setProperty("webdriver.chrome.driver", ProjectPath + "\\browserDriver\\chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.setBinary("C:\\Program Files (x86)\\CocCoc\\Browser\\Application\\browser.exe");
				driver = new ChromeDriver(options);
				break;
			case OPERA:
				System.setProperty("webdriver.opera.driver", ProjectPath + "\\browserDriver\\operadriver.exe");
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
}
