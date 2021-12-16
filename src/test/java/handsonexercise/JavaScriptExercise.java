package handsonexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.selenium.WebDriverManager;

public class JavaScriptExercise {

	private WebDriver driver;
	private WebDriverManager webDrvMgr;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() {
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("chrome");
		wait = new WebDriverWait(driver, 120);
		driver.get("https://demoqa.com/automation-practice-form");
	}

	@Test
	public void javaScriptTest() throws InterruptedException {
		WebElement oElem = driver.findElement(By.id("uploadPicture"));
		wait.until(ExpectedConditions.elementToBeClickable(oElem));
		Thread.sleep(10000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)"	, oElem);
		Thread.sleep(10000);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
