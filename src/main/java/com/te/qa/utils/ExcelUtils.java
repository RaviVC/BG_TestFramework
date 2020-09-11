package com.te.qa.utils;

import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.te.qa.resources.Resource_Helper;

public class ExcelUtils {
	
	static String projectPath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public ExcelUtils(String excelPath, String sheetName) {
		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		getCellDataString(0, 0);
	}

	public static int getRowCount() {

		int rowcount = 0;
		try {
			rowcount = sheet.getPhysicalNumberOfRows();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return rowcount;
	}

	public static int getColCount() {

		int colcount = 0;
		try {
			colcount = sheet.getRow(0).getPhysicalNumberOfCells();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return colcount;
	}

	public static String getCellDataString(int rowNum, int colNum) {

		String cellData = null;
		try {
			cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
		return cellData;
	}

	public static void getCellDataNumber(int rowNum, int colNum) {
		try {
			
			double cellData = sheet.getRow(rowNum).getCell(rowNum).getNumericCellValue();
			//System.out.println(cellData);
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

}
