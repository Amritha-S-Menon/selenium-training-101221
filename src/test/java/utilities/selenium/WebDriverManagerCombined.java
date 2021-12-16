package utilities.selenium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class WebDriverManagerCombined {

	private WebDriver driver;
	private DesiredCapabilities cap;

	// grid or local
	public WebDriver launchBrowser(String execEnv, String browserName) {
		// For grid execution
		if (execEnv.equalsIgnoreCase("grid")) {
			if (browserName.equalsIgnoreCase("ff"))
				cap = DesiredCapabilities.firefox();
			else if (browserName.equalsIgnoreCase("edge"))
				cap = DesiredCapabilities.edge();
			else if (browserName.equalsIgnoreCase("chrome"))
				cap = DesiredCapabilities.chrome();
			else
				Assert.fail("FAIL | Invalid browser name passed. Valid values are edge, chrome or ff");
			
			try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444"), cap);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//Local execution
		else if (execEnv.equalsIgnoreCase("local")) {
			if (browserName.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/msedgedriver.exe");
				driver = new EdgeDriver();
			} else if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("ff")) {
				System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			} else {
				Assert.fail("FAIL | Invalid browser name passed. Valid values are edge, chrome or ff");
			}
		} 
		// If execution environment is neither grid or local; failing the test
		else
			Assert.fail("FAIL | Choose execution preference either grid or local");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
}