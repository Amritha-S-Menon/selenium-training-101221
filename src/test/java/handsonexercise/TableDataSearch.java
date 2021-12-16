package handsonexercise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.selenium.WebDriverManager;

public class TableDataSearch {

	private WebDriver driver;
	private WebDriverManager webDrvMgr;
	WebDriverWait wait;
	SoftAssert sf;

	@BeforeClass
	public void setUp() {
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("chrome");
		wait = new WebDriverWait(driver, 120);
		driver.get("https://demo.seleniumeasy.com/table-search-filter-demo.html");
	}
	
	@BeforeMethod
	public void testPreReq(){
		sf = new SoftAssert();
	}

	@Test
	public void tableDataSearchTest() {
		String expected = "in";
		WebElement oSearchParamField = driver.findElement(By.id("task-table-filter"));
		oSearchParamField.clear();
		oSearchParamField.sendKeys(expected);
		
		List<WebElement> listTotalRows = driver.findElements(By.xpath("//table[@id='task-table']/tbody/tr"));
		for(WebElement oElem: listTotalRows){
			String attribStyle = oElem.getAttribute("style");
			if(!attribStyle.equalsIgnoreCase("display: none;")){
				String actual = oElem.getText();
				sf.assertTrue(actual.contains(expected), "FAIL | Actual " +actual+ " didn't contain expected " +expected);
			}
		}
		sf.assertAll();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}