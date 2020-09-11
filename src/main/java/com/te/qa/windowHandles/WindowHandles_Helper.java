package com.te.qa.windowHandles;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.te.qa.resources.Resource_Helper;

public class WindowHandles_Helper {
	
	static WebDriver driver = null;
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", Resource_Helper.getResourcePath("\\Drivers\\chromedriver.exe"));
		driver = new ChromeDriver();	
		
		driver.get("");
		driver.findElement(By.xpath("")).click();
		switchtoWindow(2);
		driver.close();
		switchtoWindow(1);
	}
	
	public static void switchtoWindow(int index) {
		String windowID = null;
		Set<String> windowIDs = driver.getWindowHandles();
		Iterator<String> iterator = windowIDs.iterator();
		
		for(int i=1;i<=index;i++) {
			windowID = iterator.next();
		}
		driver.switchTo().window(windowID);
	}

}
