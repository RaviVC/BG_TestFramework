package com.te.qa.utils;

public class ExcelUtilsDemo {

	public static void main(String[] args) {
		String projectPath = System.getProperty("user.dir");
		ExcelUtils excel = new ExcelUtils(projectPath+"\\Excel\\ExcelData.xlsx","Sheet1");
		System.out.println(excel.getRowCount());
		System.out.println(excel.getCellDataString(1, 0));
	}
}
