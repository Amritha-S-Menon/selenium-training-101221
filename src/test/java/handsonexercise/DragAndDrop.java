package handsonexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.selenium.WebDriverManager;
import utilities.selenium.WebDriverUtilities;

public class DragAndDrop {

	private WebDriver driver;
	private WebDriverManager webDrvMgr;
	WebDriverWait wait;
	WebDriverUtilities webDrvUtil;

	@BeforeClass
	public void setUp() {
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("chrome");
		wait = new WebDriverWait(driver, 120);
		webDrvUtil = new WebDriverUtilities(driver);
		driver.get("https://demoqa.com/droppable/");
	}

	@Test
	public void dragAndDropTest() {
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).build().perform();

		String actual = target.getText().trim();
		Assert.assertEquals(actual, "Dropped!");
	}
	

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}