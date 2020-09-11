package com.greatPro.qa.testScripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.te.qa.resources.Resource_Helper;
import com.te.qa.testBase.BaseTest;



public class GreatPro_CheckADACompplianceDetailedReport extends BaseTest {

	static WebDriver driver = null;

	String[][] requireddata = new String[200][200];;
	String[] a;

	public String excelread(int row, int col) {
		File file = new File("ADAComplaince_DetailedReport.xlsx"); // creating a new file instance
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // obtaining bytes from the file
			// creating Workbook instance that refers to .xlsx file
		XSSFWorkbook wb = null;
		try {
			wb = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet = wb.getSheet("ADAComplaince_DetailedReport");
		String resu = sheet.getRow(row).getCell(col).getStringCellValue();
		System.out.println("reading value " + resu);
		return resu;
	}

	public int excelrowCount() {
		File file = new File("ADAComplaince_DetailedReport.xlsx"); // creating a new file instance
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} 
			// creating Workbook instance that refers to .xlsx file
		XSSFWorkbook wb = null;
		try {
			wb = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		XSSFSheet sheet = wb.getSheetAt(0);
		int resu = sheet.getLastRowNum();
		return resu;
	}

	public void excelwrite() {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("ADAComplaince_DetailedReport1");
		for (int i = 0; i < a.length; i++) {
			Row row = sheet.createRow(i);
			row.createCell(0).setCellValue(a[i]);
			row.createCell(1).setCellValue(requireddata[i][0]);
			row.createCell(2).setCellValue(requireddata[i][1]);
			row.createCell(3).setCellValue(requireddata[i][2]);
			row.createCell(4).setCellValue(requireddata[i][3]);
			row.createCell(5).setCellValue(requireddata[i][4]);
			row.createCell(6).setCellValue(requireddata[i][5]);
			row.createCell(7).setCellValue(requireddata[i][6]);
			row.createCell(8).setCellValue(requireddata[i][7]);
			row.createCell(9).setCellValue(requireddata[i][8]);
			

		}

		try (FileOutputStream outputStream = new FileOutputStream("ADAComplaince_DetailedReport1.xlsx")) {
			workbook.write(outputStream);
			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void navigateEachURl(String url, int i) {
		driver.navigate().to(url);
		driver.manage().window().maximize();
		threadSleepWait(5000);
		try {
			Runtime.getRuntime().exec("C:\\Development\\ADA\\Wave\\WaveTestScript1.exe");
		} catch (IOException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}

		threadSleepWait(5000);
		driver.switchTo().frame("wave_sidebar_container");
		threadSleepWait(2000);
		driver.findElement(By.xpath("//li[@id='detailstab']")).click();
		threadSleepWait(2000);

		String Missingalternativetext = driver.findElement(By.xpath("//label[@for='toggle_type_alt_missing']")).getText();
		String Linkedimagemissingalternativetext = driver.findElement(By.xpath("//label[@for='toggle_type_alt_link_missing']")).getText();
		String Missingformlabel = driver.findElement(By.xpath("//label[@for='toggle_type_label_missing']")).getText();
		String Documentlanguagemissing = driver.findElement(By.xpath("//label[@for='toggle_type_language_missing']")).getText();
		String Emptylink = driver.findElement(By.xpath("//label[@for='toggle_type_link_empty']")).getText();
		String Orphanedformlabel = driver.findElement(By.xpath("//label[@for='toggle_type_label_orphaned']")).getText();
		String Redundantlink = driver.findElement(By.xpath("//label[@for='toggle_type_link_redundant']")).getText();
		//String Linkedimagewithalternativetext = driver.findElement(By.xpath("//label[@for='toggle_type_alt_link']")).getText();
		String StructuralElements = driver.findElement(By.xpath("//label[@for='toggle_group_structure']")).getText();
		String ContrastErrors = driver.findElement(By.xpath("//label[@for='toggle_type_contrast']")).getText();
		
		
//		System.out.println(ContrastErrors);
//		System.out.println(StructuralElements);
//		System.out.println(Redundantlink);

		requireddata[i][0] = Missingalternativetext;
		requireddata[i][1] = Linkedimagemissingalternativetext;
		requireddata[i][2] = Missingformlabel;
		requireddata[i][3] = Documentlanguagemissing;
		requireddata[i][4] = Emptylink;
		requireddata[i][5] = Orphanedformlabel;
		requireddata[i][6] = Redundantlink;
		//requireddata[i][7] = Linkedimagewithalternativetext;
		requireddata[i][7] = StructuralElements;
		requireddata[i][8] = ContrastErrors;

	}

	public void projectengine() {
		a = new String[excelrowCount()];
		//for (int i = 1; i < excelrowCount(); i++) {
			for (int i = 4; i < 10; i++) {
			a[i] = excelread(i, 0);
			System.out.println("URL IS " + a[i]);
			navigateEachURl(a[i], i);
		}
	}

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver", Resource_Helper.getResourcePath("\\Drivers\\chromedriver.exe"));
		ChromeOptions chromeoptions = new ChromeOptions();
		chromeoptions
				.addExtensions(new File(Resource_Helper.getResourcePath("\\Config\\WAVE-Evaluation-Tool_v3.0.5.crx")));
		DesiredCapabilities desriedcapabalities = DesiredCapabilities.chrome();
		desriedcapabalities.setCapability(ChromeOptions.CAPABILITY, chromeoptions);

		driver = new ChromeDriver(chromeoptions);
		driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		driver.get("https://www.greatpro.org/live-webinars/");

		List<WebElement> links = driver.findElements(By.tagName("a"));
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("ADAComplaince_DetailedReport");
		int rowCount = 0;
		int columnCount = 0;
		Row row = sheet.createRow(rowCount);
		row.createCell(columnCount).setCellValue("URLS");
		row.createCell(columnCount + 1).setCellValue("Level A");
		row.createCell(columnCount + 2).setCellValue("Level AA");
		
		for (WebElement urls : links) {

			row = sheet.createRow(rowCount + 1);

			try {
				String l = urls.getAttribute("href");
				if (l.startsWith("http") && l != null) {

					row.createCell(0).setCellValue(l);
					++rowCount;

				}
			} catch (NullPointerException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
			}
		}
		FileOutputStream outputStream = new FileOutputStream("ADAComplaince_DetailedReport.xlsx");
		workbook.write(outputStream);
		outputStream.close();

//		System.out.println(workbook.getSheet("ADAComplainceReport").getLastRowNum());
//		int w=workbook.getSheet("ADAComplainceReport").getLastRowNum();
		GreatPro_CheckADACompplianceDetailedReport gp = new GreatPro_CheckADACompplianceDetailedReport();

		gp.projectengine();
		gp.excelwrite();

	}
}
