package com.te.qa.smokeTestScripts;

import java.util.Set;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.te.qa.testBase.BaseTest;

public class VerifyLiveChat extends BaseTest {
	
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
	public void ClickOnLiveChat() {
		test = extent.createTest("Launch TE Application");
		
		boolean elementStatus = homepage.liveChat.isDisplayed();
		if(elementStatus==true) {
			homepage.liveChat.click();
			//switchWindow("Start Live Chat - TE");
			Set<String> handles = driver.getWindowHandles();
			if (!handles.isEmpty())
				for (String win : handles) {
					if (driver.switchTo().window(win).getTitle().equals("Start Live Chat - TE")) {
						
					} else {
						driver.switchTo().window(win);
					}
				}
			threadsleepdelay(10000);
			homepage.sendEmailRequest.click();
		}
	}
	
	
	
}
