package com.te.qa.seleniumAPI;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WindowHelper {
	
	private WebDriver driver;
	
	public WindowHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	public void switchToParentWindow(){
		driver.switchTo().defaultContent();
	}
	
	public void switchToWindow(int index){
		Set<String> windows = driver.getWindowHandles();
		int i=1;
		for(String window : windows){
			if(i==index){
				driver.switchTo().window(window);
			}
			else{
				i++;
			}
		}
	}
		
	public void closeAllTabsAndSwitchToMainWindow(){
		 Set<String> windows = driver.getWindowHandles();
		 String mainwindow = driver.getWindowHandle();
		 
		 for(String window : windows){
			 if(!window.equalsIgnoreCase(mainwindow)){
				 driver.close();
			 }
			 driver.switchTo().window(mainwindow);
		 }
	}
	
	public void navigateBack(){
		driver.navigate().back();
	}
	
	public void navigateForward(){
		driver.navigate().forward();
	}

}
