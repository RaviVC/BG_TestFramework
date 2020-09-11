package com.te.qa.utils;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {

	@Test(dataProvider = "test1Data")
	public void test1(String username, String password) {
		System.out.println("The username is -> " + username);
		System.out.println("The password is -> " + password);
	}

	@DataProvider(name = "test1Data")
	public Object[][] getData() {
		String excelpath = System.getProperty("user.dir") + "\\Excel\\ExcelData.xlsx";
		Object data[][] = testData(excelpath, "sheet1");
		return data;
	}

	public static Object[][] testData(String ExcelPath, String SheetName) {

		ExcelUtils excel = new ExcelUtils(ExcelPath, SheetName);
		int colcount = excel.getColCount();
		int rowcount = excel.getRowCount();
		Object data[][] = new Object[rowcount - 1][colcount];

		for (int i = 1; i < rowcount; i++) {
			for (int j = 0; j < colcount; j++) {
				String cellData = excel.getCellDataString(i, j);
				System.out.println(cellData);
				data[i - 1][j] = cellData;
			}
			System.out.println();
		}
		return data;
	}
}
