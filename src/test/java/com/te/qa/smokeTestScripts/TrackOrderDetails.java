package com.te.qa.smokeTestScripts;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.te.qa.testBase.BaseTest;

public class TrackOrderDetails extends BaseTest {
	
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
	public void clickTrackOnOrder() {
		test = extent.createTest("clickTrackOnOrder");
		boolean elementStatus = homepage.trackUrOrder.isDisplayed();
		if(elementStatus==true) {
			homepage.trackUrOrder.click();
		}else {
			test.log(Status.INFO, "track ur order displayed");
		}
	}

	@Test(priority = 2)
	public void enterEmailAddress() {
		test = extent.createTest("enterEmailAddress");
		boolean elementStatus = searchOrderPage.emailAddress.isDisplayed();
		if(elementStatus==true) {
			searchOrderPage.emailAddress.sendKeys("ravivc197@gmail.com");
		}else {
			test.log(Status.INFO, "enterEmailAddress field not displayed");
		}
	}
	
	@Test(priority = 3)
	public void enterorderNo() {
		test = extent.createTest("enterorderNo");
		boolean elementStatus = searchOrderPage.orderNo.isDisplayed();
		if(elementStatus==true) {
			searchOrderPage.orderNo.sendKeys("321654");
		}else {
			test.log(Status.INFO, "enterorderNo field not displayed");
		}
	}
	
	@Test(priority = 4)
	public void viewOrderDetails() {
		test = extent.createTest("viewOrderDetails");
		boolean elementStatus = searchOrderPage.viewOrderDetails.isDisplayed();
		if(elementStatus==true) {
			searchOrderPage.viewOrderDetails.click();
		}else {
			test.log(Status.INFO, "viewOrderDetails button not displayed");
		}
	}

}
