package handsonexercise.pom.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePagePO {
	
	WebDriver driver;
	
	public HomePagePO(WebDriver driver){
		this.driver = driver;
	}
	
	private By searchBar = By.id("twotabsearchtextbox");
	private By submitBtn = By.id("nav-search-submit-button");
	
	private void enterValueInSearchBar(String searchParam){
		driver.findElement(searchBar).clear();
		driver.findElement(searchBar).sendKeys(searchParam);
	}
	
	private void clickSearchBtn(){
		driver.findElement(submitBtn).click();
	}
	
	public void searchForProduct(String searchParam){
		enterValueInSearchBar(searchParam);
		clickSearchBtn();
	}
}
