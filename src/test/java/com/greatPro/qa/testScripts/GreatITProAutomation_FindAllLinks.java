package com.greatPro.qa.testScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.te.qa.testBase.BaseTest;

public class GreatITProAutomation_FindAllLinks extends BaseTest {
	int acount;
	
	@Test
	public void findTextLinks() {
		
		launchApp("https://www.greatpro.org/topics", "prod");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		for(WebElement element: links) {
			System.out.println(element.getAttribute("href"));
		}	
			
	}
		
}

