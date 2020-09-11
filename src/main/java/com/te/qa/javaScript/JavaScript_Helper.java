package com.te.qa.javaScript;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.te.qa.resources.Resource_Helper;

public class JavaScript_Helper {
	
	public static WebDriver driver = null;
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", Resource_Helper.getResourcePath("\\Drivers\\chromedriver.exe"));
		driver = new ChromeDriver();	
		
		driver.get("https://login.yahoo.com/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('persistent').click()");
	}

}
