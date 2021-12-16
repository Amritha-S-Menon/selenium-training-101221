package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.testng.Assert;

public class DataProvider {
	
	public static String getTestData(String propFile, String propName) {
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
		} catch (IOException ioex) {
			ioex.printStackTrace();
			Assert.fail("FAIL | IO Exeption thrown. Please check that file path is correct");
		}
		return prop.getProperty(propName);
	}

}
