package com.te.qa.resources;

public class Resource_Helper {
	
	public static String getResourcePath(String path) {
		
		String filePath = System.getProperty("user.dir").toString() + path;
		System.out.println(filePath);
		return filePath;
	}
	
	public static void main(String[] args) {
		getResourcePath("\\Excel\\ExcelData.xlsx");
	}
}
