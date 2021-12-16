package testng.assertion;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert {
	
	@Test
	public void hardAssertTest(){
		
		//Create an employee
		//First name, last name, email address. phone number, department.....
		
		//Firstname = Mehul
		//Last name = Agarwal
		//email = mehul@gmail.com
		//phone number = 9876543210
		//department = testing
		
		//Assert
		
		Assert.assertEquals("Mehul", "Mehul");
		Assert.assertEquals("Agarwal", "Agarwal");
		Assert.assertEquals("mehul@gmail.com", "mehul@gmail.com");
		Assert.assertEquals("9876543210", "9876543210");
		Assert.assertEquals("", "testing");
	}
}
