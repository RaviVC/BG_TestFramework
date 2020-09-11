package com.te.qa.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchOrder_Page {
	
	@FindBy(how=How.XPATH,using="//input[@name='emailAddress']")
	public WebElement emailAddress;
	
	@FindBy(how=How.XPATH,using="//input[@name='orderdata']")
	public WebElement orderNo;
	
	@FindBy(how=How.XPATH,using="//a[@class='btn-block-11 btn-clr-13 view-order']")
	public WebElement viewOrderDetails;

}
