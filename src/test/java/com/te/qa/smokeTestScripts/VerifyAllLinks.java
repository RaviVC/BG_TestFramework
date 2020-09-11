package com.te.qa.smokeTestScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.te.qa.testBase.BaseTest;

public class VerifyAllLinks extends BaseTest {
	
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
	public void verifyAndListLinks() {
		test = extent.createTest("Launch TE Application");
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for(WebElement listlinks:links) {
			System.out.println(listlinks.getAttribute("href"));
		}
	}
	

}
