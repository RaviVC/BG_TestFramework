package com.te.qa.seleniumAPI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.te.qa.resources.Resource_Helper;

public class ScrollWithinWebElement {
	
	public static WebDriver driver;
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", Resource_Helper.getResourcePath("\\Drivers\\chromedriver.exe"));
		driver = new ChromeDriver();
	}

}
