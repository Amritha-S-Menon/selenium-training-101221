package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

public class Helper {
	
	Workbook workbook;
	Sheet iSheet;
	Row oRow;
	
	public String readFromExcel(String fpath, String sheetName, int rowNum, int colNum) {
		String cellValue = null;
		try{
			FileInputStream iFile = new FileInputStream(new File(fpath));
			DataFormatter df = new DataFormatter();
			String fileExtension = FilenameUtils.getExtension(fpath);
			
			if(fileExtension.equalsIgnoreCase("xls"))
				workbook = new HSSFWorkbook(iFile);
			else if(fileExtension.equalsIgnoreCase("xlsx"))
				workbook = new XSSFWorkbook(iFile);
			else
				Assert.fail("FAIL | Valid extensions are xls or xlsx");
			
			iSheet = workbook.getSheet(sheetName);
			oRow = iSheet.getRow(rowNum-1);
			cellValue = df.formatCellValue(oRow.getCell(colNum-1));
			workbook.close();
		}catch(IOException ioex){
			ioex.printStackTrace();
			Assert.fail("FAIL | Unable to read from file");
		}
		return cellValue;
	}
}

