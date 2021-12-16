package handsonexercise.pom.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPO {
	
	public AlertPO(WebDriver driver){
		this.driver = driver;
	}
	
	WebDriver driver;
	
	//Locators go here
	By btnToOpenAlert = By.xpath("//button[@class='btn btn-default']");
	
	//Methods to take action on webElement will go here	
	public void clickBtnToOpenAlert(){
		driver.findElement(btnToOpenAlert).click();
	}
	
	public void acceptAlert(){
		driver.switchTo().alert().accept();
	}
	


}
