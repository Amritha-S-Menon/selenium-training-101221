package handsonexercise.pom.pageobjects;

import java.util.LinkedList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPO {

	WebDriver driver;

	public SearchResultsPO(WebDriver driver) {
		this.driver = driver;
	}

	By searchResults = By.cssSelector("span.a-size-medium.a-color-base.a-text-normal");

	public List<String> getListOfProdNames() {
		List<String> searchResultProdNames = new LinkedList<String>();
		List<WebElement> oList = driver.findElements(searchResults);
		for (WebElement oelem : oList) {
			String prodName = oelem.getText();
			searchResultProdNames.add(prodName);
		}
		return searchResultProdNames;
	}
}
