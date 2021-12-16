package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class Annotations3 {
	
  @Test
  public void testOne() {
	  System.out.println("Annotations3_testOne");
  }
  
  @Test
  public void testTwo() {
	  System.out.println("Annotations3_testTwo");
  }
  
  @Test
  public void testThree() {
	  System.out.println("Annotations3_testThree");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Annotations3_beforeMethod");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Annotations3_afterMethod");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("Annotations3_beforeClass");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("Annotations3_afterClass");
  }
}