package com.te.qa.seleniumAPI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameHelper {
	
	private WebDriver driver;
	
	public FrameHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	public void SwitchToFrame(int frameIndex){
		driver.switchTo().frame(frameIndex);
	}
	
	public void SwitchToFrame(String frameName){
		driver.switchTo().frame(frameName);
	}
	
	public void SwitchToFrame(WebElement element){
		driver.switchTo().frame(element);
	}
}
