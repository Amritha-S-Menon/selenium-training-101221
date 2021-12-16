package grid;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.selenium.WebDriverManagerCombined;

public class GridExampleWithWebDriverManager {
	
	WebDriver driver;
	WebDriverManagerCombined webDrvMgr;
	
	@Parameters({"executionEnv","browser"})
	@BeforeClass
	public void setUp(@Optional("local") String executionEnv, @Optional("chrome") String browser ){
		webDrvMgr = new WebDriverManagerCombined();
		driver = webDrvMgr.launchBrowser(executionEnv,browser );
	}
	
	@Test
	public void runTestInGrid() throws InterruptedException {
		driver.get("https://amazon.in");
		Thread.sleep(10000);
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
}
