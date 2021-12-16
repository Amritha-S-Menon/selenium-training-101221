package handsonexercise.pom.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import handsonexercise.pom.pageobjects.AlertPO;
import utilities.selenium.WebDriverManager;

public class AlertBoxTests {

	private WebDriver driver;
	private WebDriverManager webDrvMgr;
	WebDriverWait wait;
	AlertPO altpo;

	@BeforeClass
	public void setUp() {
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("chrome");
		wait = new WebDriverWait(driver, 120);
		altpo = new AlertPO(driver);
		driver.get("http://demo.seleniumeasy.com/javascript-alert-box-demo.html");
	}

	@Test
	public void alertBoxTest() throws InterruptedException {
		altpo.clickBtnToOpenAlert();
		altpo.acceptAlert();
		
		Thread.sleep(1000);
		boolean doesAlertExist = false;
		//Alert should not exist
		try{
			driver.switchTo().alert();
			doesAlertExist = true;
		} catch(Exception ex){
			//do nothing
		}
		Assert.assertFalse(doesAlertExist);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}