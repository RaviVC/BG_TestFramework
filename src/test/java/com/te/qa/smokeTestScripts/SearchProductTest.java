package com.te.qa.smokeTestScripts;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.te.qa.testBase.BaseTest;


public class SearchProductTest extends BaseTest {
	
	@Parameters("Environment")
	@Test(priority=0)
	public void launch(String Environment) {
		
		  test = extent.createTest("Launch TE Application");
		  launchApp(CONFIG.getProperty("TE_URL"), Environment);
		  System.out.println(driver.getTitle());
		  threadsleepdelay(5000);
		  checkAlert_Dismiss();
	}
	
	@Test
	public void searchProduct() {
		test = extent.createTest("searchProduct");
		boolean elementStatus = homepage.searchInputField.isDisplayed();
		if(elementStatus==true) {
			homepage.searchInputField.clear();
			homepage.searchInputField.sendKeys("Antennas");
			threadsleepdelay(2000);
			homepage.searchButton.click();
			threadsleepdelay(3000);
			String expectedTitle = driver.getTitle();
			Assert.assertEquals("Antenna Solutions & Technologies | TE Connectivity", expectedTitle);
			test.log(Status.INFO, "searchInputField is displayed and searchProduct entered");
			
		}else {
			test.log(Status.INFO, "searchInputField is not displayed");
		}
	}
}
