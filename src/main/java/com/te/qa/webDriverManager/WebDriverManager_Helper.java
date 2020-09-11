package com.te.qa.webDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManager_Helper {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www-stage.te.com/usa-en/home.html");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//Other Drivers 
	/*WebDriverManager.firefoxdriver().setup();
	WebDriverManager.edgedriver().setup();
	WebDriverManager.operadriver().setup();
	WebDriverManager.phantomjs().setup();
	WebDriverManager.iedriver().setup();
	WebDriverManager.chromiumdriver().setup();
*/
}
