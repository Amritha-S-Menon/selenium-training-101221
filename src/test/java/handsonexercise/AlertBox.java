package handsonexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.selenium.WebDriverManager;

public class AlertBox {

	private WebDriver driver;
	private WebDriverManager webDrvMgr;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() {
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("chrome");
		wait = new WebDriverWait(driver, 120);
		driver.get("http://demo.seleniumeasy.com/javascript-alert-box-demo.html");
	}

	@Test
	public void alertBoxTest() throws InterruptedException {
		driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
		driver.switchTo().alert().accept();
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
	
	@Test
	public void jsConfirmBoxTest() throws InterruptedException {
		driver.findElement(By.xpath("//p[@id='confirm-demo']//..//button[@class='btn btn-default btn-lg']")).click();
		driver.switchTo().alert().dismiss();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}