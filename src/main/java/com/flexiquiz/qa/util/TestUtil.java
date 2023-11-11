package com.flexiquiz.qa.util;

/*import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;*/
import java.time.Duration;

/*import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;*/
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flexiquiz.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	//static Workbook book;
	//static Sheet sheet;
	//public static String TESTDATA_SHEET_PATH = "your_excel_datasheet_path";
	
	
	
	public static void switchToFrame(WebElement frameName) {
		driver.switchTo().frame(frameName);
	}
	
	public static void waitUntilElementVissible(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	
	//Method to get Data from Excel Sheet.
	/*public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0; i<sheet.getLastRowNum(); i++) {
			for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}
		}
		return data;
	}*/
	
}
