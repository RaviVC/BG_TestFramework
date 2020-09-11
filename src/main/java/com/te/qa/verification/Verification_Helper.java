package com.te.qa.verification;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.te.qa.log4j.Log4j_Helper;

public class Verification_Helper {
	
	private WebDriver driver;
	private Logger logger = LogManager.getLogger(Log4j_Helper.class);
	
	public Verification_Helper(WebDriver driver) {
		this.driver=driver;
	}
	
public boolean isDisplayed(WebElement element){
		
		try {
			element.isDisplayed();
			logger.info("element is displayed .. "+ element.getText());
			return true;
		} catch (Exception e) {
			logger.error("element is not displayed .. "+ e.getCause());
			return false;
		}
	}
	
	public boolean isNotDisplayed(WebElement element){
		
		try {
			element.isDisplayed();
			logger.info("element is present .. "+ element.getText());
			return false;
		} catch (Exception e) {
			logger.error("element is not present .. "+ e.getCause());
			return true;
		}
	}
	
	public String getText(WebElement element){
		if(null==element){
			logger.info("WebElement is null .. ");
			return null;
		}
		boolean status = isDisplayed(element);
		if(status){
			logger.info("element text is .."+ element.getText());
			return element.getText();
		}else{
			return null;
		}
	}
	
	public String getTitle(){
		logger.info("page title is .. " + driver.getTitle());
		return driver.getTitle();
	}

	
	
}
