package testng.dataprovider;

import org.testng.annotations.Test;

public class DPClass {

	@Test(dataProvider = "data-provider", dataProviderClass =DataProviderClass.class )
	public void dataProviderTest(String input) {
		System.out.println("Name is " + input);
	}

	@Test(dataProvider = "data-provider-1" , dataProviderClass =DataProviderClass.class)
	public void dpMethod1Test(int num1, int num2){
		int sum = num1 + num2;
		System.out.println("Sum of " +num1+ " and " +num2+ " is " +sum);
	}

}
