package com.w2a.APITestingFramework.utilities;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;

import com.w2a.APITestingFramework.setUp.BaseTest;


public class dataUtil extends BaseTest {

	@DataProvider(name = "data")
	public Object[][] getData(Method m) {
		
		System.out.println(config.getProperty("testDataSheet"));
		int rowCount = excel.getRowCount(config.getProperty("testDataSheet"));
		
		System.out.println("Total row is " + rowCount);
		String testName = m.getName();
		// Find the test case start row
		int testCaseRowNum = 1;
		for (testCaseRowNum = 1; testCaseRowNum <= rowCount; testCaseRowNum++) {
			String testCaseName = excel.getCellData(config.getProperty("testDataSheet"), 0, testCaseRowNum);
			if (testCaseName.equalsIgnoreCase(testName))
				break;
		}
		System.out.println("Test case found at row num " + testCaseRowNum);
		// Checking total rows in testcase

		int dataStartRow = testCaseRowNum + 2;
		int testRow = 0;
		while (!excel.getCellData(config.getProperty("testDataSheet"), 0, dataStartRow + testRow).equals("")) {
			testRow++;
		}

		System.out.println("Total rows od data are " + testRow);

		// Checking total cols in test case

		int colStartColNum = testCaseRowNum + 1;
		int testCols = 0;
		while (!excel.getCellData(config.getProperty("testDataSheet"), testCols, colStartColNum).equals("")) {
			testCols++;
		}

		System.out.println("Total cols are " + testCols);

		// printing data
		Object[][] data = new Object[testRow][1];
		int i = 0;
		for (int rNum = dataStartRow; rNum < (dataStartRow + testRow); rNum++) {
			Hashtable<String, String> table = new Hashtable<String, String>();

			for (int cNum = 0; cNum < testCols; cNum++) {
				// System.out.println(excel.getCellData(Constants.DATA_SHEET, cNum, rNum));
				// data[rNum-dataStartRow][cNum] = excel.getCellData(Constants.DATA_SHEET, cNum,
				// rNum);
				String testData = excel.getCellData(config.getProperty("testDataSheet"), cNum, rNum);
				String colName = excel.getCellData(config.getProperty("testDataSheet"), cNum, colStartColNum);
				table.put(colName, testData);
			}

			data[i][0] = table;
			i++;
		}

		return data;

		
		
		
		

	}

}


/*System.out.println("SheetName " + m.getName());
String sheetName = m.getName();
int rowCount = excel.getRowCount(sheetName);
int colCount = excel.getColumnCount(sheetName);
System.out.println("Total row count" + rowCount + "Total col count" + colCount);

Object[][] data = new Object[rowCount - 1][colCount];

/*
 * data[0][0]=excel.getCellData(sheetName, 0, 2);
 * data[0][1]=excel.getCellData(sheetName, 1, 2);
 * data[0][2]=excel.getCellData(sheetName, 2, 2);
 * 
 * data[1][0]=excel.getCellData(sheetName, 0, 3);
 * data[1][1]=excel.getCellData(sheetName, 1, 3);
 * data[1][2]=excel.getCellData(sheetName, 2, 3);
 */

/*for (int rowNum = 2; rowNum <= rowCount; rowNum++) {

	for (int colNum = 0; colNum < colCount; colNum++) {

		data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);

	}
}

return data;*/
