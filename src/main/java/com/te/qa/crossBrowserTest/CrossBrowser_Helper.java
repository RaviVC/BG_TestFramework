package com.te.qa.crossBrowserTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.te.qa.resources.Resource_Helper;

import net.bytebuddy.implementation.attribute.AnnotationAppender.Target.OnField;

public class CrossBrowser_Helper {
	
	public WebDriver driver = null;
	
	@Parameters("browserName")
	@BeforeTest
	public void setup(String browserName) {
		
		System.out.println("Browser Name is " + browserName);
		System.out.println("ThreadID is" + Thread.currentThread().getId());
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", Resource_Helper.getResourcePath("\\Drivers\\chromedriver.exe"));
			driver = new ChromeDriver();	
		}else if(browserName.equalsIgnoreCase("ff")){
			System.setProperty("webdriver.chrome.driver", Resource_Helper.getResourcePath("\\Drivers\\chromedriver.exe"));
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.chrome.driver", Resource_Helper.getResourcePath("\\Drivers\\chromedriver.exe"));
			driver = new ChromeDriver();
		}
	}
	
	@Test
	public void test() {
		System.out.println("Test run successfully");
		driver.get("https://www.google.com/");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
