package grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GridExample {
	
	WebDriver driver;
	
	@Test
	public void runTestInGrid() throws MalformedURLException{
		DesiredCapabilities capabilities = DesiredCapabilities.edge();
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		driver.manage().window().maximize();
		driver.get("https://amazon.in");
		driver.quit();
	}
}
