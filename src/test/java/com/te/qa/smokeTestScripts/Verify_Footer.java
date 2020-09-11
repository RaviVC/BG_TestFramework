package com.te.qa.smokeTestScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.te.qa.testBase.BaseTest;

public class Verify_Footer extends BaseTest {

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
	public void getFooterMenu() {

		test = extent.createTest("getFooterMenu");
		boolean elemenStatus = homepage.footerMenu.isDisplayed();
		System.out.println(elemenStatus);
		List<WebElement> footerList = driver.findElements(By.xpath("//ul[@class='footer-menu wrapper']"));
		for (int i = 0; i < footerList.size(); i++) {
			String footerText = footerList.get(i).getText();
			System.out.println(footerText);
			if (footerText.equalsIgnoreCase("Distributors")) {
				System.out.println("Distributors found");
				threadsleepdelay(3000);
				footerList.get(i).click();
				break;
			}else {
				System.out.println("Distributors not found");
			}
		}

	}

}
