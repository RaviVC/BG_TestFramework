package com.te.qa.autoIT;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AutoIT_Helper {
	@Test
	public static void test() throws IOException, InterruptedException{
		System.setProperty("webdriver.chrome.exe", "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://tinyupload.com/");
		driver.findElement(By.name("uploaded_file")).click();
		
		Runtime.getRuntime().exec("F:\\Automation_Softwares\\AutoIT\\FileUploadScript.exe");
		Thread.sleep(3000);
		driver.close();
	}
	
	public void executeAutoITScript(WebDriver driver,String ScriptPath, String URL) {
		
		
		
	}
}
