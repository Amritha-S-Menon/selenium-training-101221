package handsonexercise;

import org.testng.annotations.Test;

import utilities.Helper;

public class ExcelInteraction {
	
	@Test
	public void readFromExcelTest(){
		Helper helper = new Helper();
		String fpath = "src/test/resources/TestExcel.xls";
		String sheetName = "login";
		int rowNum = 2, colNum = 3;
		String cellValue = helper.readFromExcel(fpath, sheetName, rowNum, colNum);
		System.out.println(cellValue);
		
	}

}
