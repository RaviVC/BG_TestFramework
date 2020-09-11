package com.te.qa.smokeTestScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.te.qa.testBase.BaseTest;

public class GetAllProductsList extends BaseTest {

	@Parameters("Environment")
	@Test(priority = 0)
	public void launch(String Environment) {

		test = extent.createTest("Launch TE Application");
		launchApp(CONFIG.getProperty("TE_URL"), Environment);
		System.out.println(driver.getTitle());
		threadsleepdelay(5000);
		checkAlert_Dismiss();
	}

	 
	
	@Test(priority = 1)
	public void clickOnProductsTab() {
		test = extent.createTest("clickOnProductsTab");
		boolean elementStatus = homepage.productsTab.isDisplayed();
		if (elementStatus == true) {
			homepage.productsTab.click();
			threadsleepdelay(3000);
			test.log(Status.INFO, "Products tab is displayed");
		} else {
			test.log(Status.FAIL, "Products tab is not displayed");
		}
	}

	//Products list
	@Test(priority = 2)
	public void getAll_Products() {
		test = extent.createTest("getAllProducts");
		List<WebElement> productMenu = driver.findElements(By.xpath("//div[@id='menu-top-1']"));

		for (int i = 0; i < productMenu.size(); i++) {
			System.out.println(productMenu.get(i).getText());
		}
		
		ReturnToHomePage();
	}

	// Industries and solutions list 
	@Test(priority = 3)
	public void getAll_IndustriesAndSolutions() {
		test = extent.createTest("getAll_IndustriesAndSolutions");
		homepage.ISMenu.click();
		threadsleepdelay(2000);
		List<WebElement> ISMenu = driver.findElements(By.xpath("//div[@id='menu-top-2']"));
		for (int i = 0; i < ISMenu.size(); i++) {
			System.out.println(ISMenu.get(i).getText());
		}
		ReturnToHomePage();
	}
	
	@Test(priority = 4)
	public void getAll_browseMostViewedProducts() {
		test = extent.createTest("getAll_browseMostViewedProducts");
		
		boolean elementStatus = homepage.browseMostViewedProducts.isDisplayed();
		if(elementStatus==true) {
			List<WebElement> featuredConnectors = driver.findElements(By.xpath("//div[@class='fp-cab-list ng-scope']"));
			for(int i=0;i<featuredConnectors.size();i++) {
				System.out.println("List of most browsed viewed products is");
				System.out.println(featuredConnectors.get(i).getText());
			}
		}
	}
}
