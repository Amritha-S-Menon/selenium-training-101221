package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.selenium.WebDriverManager;

public class CrossBrowser {

	WebDriver driver;
	WebDriverManager webDrvMgr;

	@Parameters({ "browser" })
	@BeforeClass
	public void setUp(@Optional("chrome") String browser) {
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser(browser);
	}

	@Test
	public void navigateToGoogleTest() throws InterruptedException {
		driver.get("http://www.google.co.in");
		Thread.sleep(20000);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}