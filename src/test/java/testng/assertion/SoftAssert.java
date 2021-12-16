package testng.assertion;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SoftAssert {
	
	org.testng.asserts.SoftAssert sf;
	
	@BeforeMethod
	public void setUp(){
		sf = new org.testng.asserts.SoftAssert();
	}
	
	@Test(priority = 1)
	public void createEmployee(){		
		sf.assertEquals("Mehul", "Mehul");
		sf.assertEquals("Agarwal", "Agarwal");
		sf.assertEquals("mehul@gmail.com", "mehul@gmail.com");
		sf.assertEquals("", "9876543210");
		sf.assertEquals("", "testing");
		sf.assertAll();
	}
	
	@Test (priority = 2)
	public void updateEmployee(){
		//Steps will come here
		sf.assertTrue(true);
		sf.assertAll();
	}

}
