package com.te.qa.seleniumAPI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;


import com.te.qa.log4j.Log4j_Helper;

public class AlertHelper {
	
	private WebDriver driver;
	private Logger logger = LogManager.getLogger(Log4j_Helper.class);
	
	public AlertHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	public Alert getAlert(){
		logger.info("alert test .."+ driver.switchTo().alert().getText());
		return driver.switchTo().alert();
	}
	
	public void acceptAlert(){
		getAlert().accept();
		logger.info("accept alert .. ");
	}
	
	public void dismissAlert(){
		getAlert().dismiss();
		logger.info("dismiss alert .. ");
	}
	
	public String getAlertText(){
		String text = getAlert().getText();
		logger.info("Alert text is " + text);
		return text;
	}
	
	public boolean isAlertPresent(){
		try {
			driver.switchTo().alert();
			logger.info("Alert is present");
			return true;
		} catch (Exception e) {
			logger.info(e.getCause());
			return false;
		}
	}
	
	public boolean acceptAlertIfPresent(){
		if(isAlertPresent()){
			acceptAlert();
			return true;
		}else{
			return false;
		}
	}
	
	public boolean dismissAlertIfPresent(){
		if(isAlertPresent()){
			dismissAlert();
			return true;
		}else{
			logger.info("Alert is not present");
			return false;
		}
	}
	
	public void acceptPrompt(String text){
		if(isAlertPresent()){
			Alert alert = getAlert();
			alert.sendKeys(text);
			alert.accept();
			logger.info("Accept alert is done");
		}
	}

}
