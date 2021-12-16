package handsonexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utilities.selenium.WebDriverManager;

public class InputBox {

	private WebDriver driver;
	private WebDriverManager webDrvMgr;
	WebDriverWait wait;
	SoftAssert sf;

	@BeforeClass
	public void setUp() {
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("chrome");
		wait = new WebDriverWait(driver, 120);
		driver.get("http://demo.seleniumeasy.com/basic-first-form-demo.html");
	}

	@Test
	public void testPreReq() {
		String expected = "This is a test";
		WebElement oMsgTextBox = driver.findElement(By.id("user-message"));
		oMsgTextBox.clear();
		oMsgTextBox.sendKeys(expected);
		driver.findElement(By.xpath("//button[@class='btn btn-default'][text()='Show Message']")).click();
		String actual = driver.findElement(By.id("display")).getText().trim();
		Assert.assertEquals(actual, expected);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}