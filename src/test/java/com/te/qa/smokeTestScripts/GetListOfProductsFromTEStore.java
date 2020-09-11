package com.te.qa.smokeTestScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.te.qa.testBase.BaseTest;

public class GetListOfProductsFromTEStore extends BaseTest{
	
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
	public void clickOnTEStore() {
		test = extent.createTest("clickOnTEStore");
		threadsleepdelay(3000);
		boolean elementStatus = storepage.testore.isDisplayed();
		if(elementStatus==true) {
			storepage.testore.click();
			System.out.println(driver.getTitle());
			test.log(Status.INFO, "TE Store is displayed and clicked ");
		}else {
			test.log(Status.INFO, "TE Store is not displayed and clicked ");
			System.out.println();
		}
	}
	
	@Test(priority = 2)
	public void getListOfProductsFromTEStore() {
		boolean elementStatus = storepage.TEStoreProductsText.isDisplayed();
		if(elementStatus==true) {
			
			List<WebElement> StoreProdList = driver.findElements(By.xpath("//div[@class='product-grid-content editorial-parsys']"));
			
			for(int i = 0; i<StoreProdList.size();i++) {
				System.out.println("****************** Store Products list are **************************");
				System.out.println(StoreProdList.get(i).getText());
			}
		}
	}
	
	

	

}
