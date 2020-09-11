package com.te.qa.testScripts;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.te.qa.objectRepository.Home_Page;
import com.te.qa.testBase.BaseTest;
import com.te.qa.utils.ExcelDataProvider;

public class ValidateAddToCart extends BaseTest{
	
	
	@Parameters("Environment")
	@Test(priority=0)
	public void launch(String Environment) {
		
		  test = extent.createTest("Launch TE Application");
		  launchApp(CONFIG.getProperty("TE_URL"), Environment);
		  System.out.println(driver.getTitle());
		  threadsleepdelay(5000);
		  checkAlert_Dismiss();
	}
	
	@Test(priority=1)
	public void clickOnProductsTab() {
		test = extent.createTest("clickOnProductsTab");
		boolean elementStatus = homepage.productsTab.isDisplayed();
		if(elementStatus==true) {
			homepage.productsTab.click();
			threadsleepdelay(3000);
			test.log(Status.INFO, "Products tab is displayed");
		}else {
			test.log(Status.FAIL,"Products tab is not displayed");
		}
	}
	
	@Test(priority=2)
	public void clickOnConnectors() {
		test = extent.createTest("clickOnConnectors");
		boolean elementStatus = homepage.connectors.isDisplayed();
		if(elementStatus==true) {
			homepage.connectors.click();
			test.log(Status.INFO, "connectors is displayed");
		}else {
			test.log(Status.FAIL,"connectors is not displayed");
		}
	}
	
	@Test(priority=3)
	public void clickOnViewAllConnectors() {
		test = extent.createTest("clickOnViewAllConnectors");
		scroll_Vertical(700);
		boolean elementStatus = pgppage.viewAllConnectors.isDisplayed();
		System.out.println(elementStatus);
		if(elementStatus==true) {
			pgppage.viewAllConnectors.click();
			test.log(Status.INFO, "viewAllConnectors is displayed");
		}else {
			test.log(Status.FAIL,"viewAllConnectors is not displayed");
		}
	}
	
	@Test(priority=4)
	public void clickOnFirstProductInPLP() {
		test = extent.createTest("clickOnFirstProductInPLP");
		boolean elementStatus = plppage.firstProduct_PLP.isDisplayed();
		if(elementStatus==true) {
			plppage.firstProduct_PLP.click();
			test.log(Status.INFO, "firstProduct_PLP is displayed");
		}else {
			test.log(Status.FAIL,"firstProduct_PLP is not displayed");
		}
	}
	
	@Test(priority=5)
	public void clickOnFirstProductInMDP() {
		test = extent.createTest("clickOnFirstProductInMDP");
		boolean elementStatus = mdppage.firstProduct_MDP.isDisplayed();
		if(elementStatus==true) {
			mdppage.firstProduct_MDP.click();
			test.log(Status.INFO, "firstProduct_MDP is displayed");
		}else {
			test.log(Status.FAIL,"firstProduct_MDP is not displayed");
		}
	}
	
	@Test(priority=6)
	public void clickOnAddToCart() {
		test = extent.createTest("clickOnAddToCart");
		boolean elementStatus = pdppage.addToCart.isDisplayed();
		if(elementStatus==true) {
			pdppage.addToCart.click();
			test.log(Status.INFO, "addToCart is displayed");
		}else {
			test.log(Status.FAIL,"addToCart is not displayed");
		}
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Test(priority=1)
//	public void clickTEStore() {
//		storepage.testore.click();
//		threadsleepdelay(3000);
//		storepage.storeantennas.click();
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Test(dataProvider = "test1Data")
//	public void excelTest(String username, String password) {
//		test = extent.createTest("Excel test");
//		System.out.println(username);
//		System.out.println(password);
//	}
//	
//	
//	
//	@DataProvider(name = "test1Data")
//	public Object[][] getData(){
//		ExcelDataProvider exceldata = new ExcelDataProvider();
//		String excelpath = System.getProperty("user.dir")+"\\Excel\\ExcelData.xlsx";
//		Object data[][] = exceldata.testData(excelpath, "sheet1");
//		return data;
//	}
//	
	

}
