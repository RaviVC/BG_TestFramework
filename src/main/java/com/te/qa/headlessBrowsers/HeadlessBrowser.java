package com.te.qa.headlessBrowsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import com.te.qa.resources.Resource_Helper;

public class HeadlessBrowser {
	
	WebDriver driver = null;
	
	@Test
	public void test() {
		System.setProperty("webdriver.chrome.driver", Resource_Helper.getResourcePath("\\Drivers\\chromedriver.exe"));
		ChromeOptions options = new ChromeOptions();
		options.addArguments("Headless");
		driver = new ChromeDriver(options);
		
		driver.get("https://www.google.com/");
		driver.getTitle();
	}

}
