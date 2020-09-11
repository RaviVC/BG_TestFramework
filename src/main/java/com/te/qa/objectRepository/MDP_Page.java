package com.te.qa.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MDP_Page {
	
	@FindBy(how=How.XPATH,using="//tr[1]//td[1]//span[1]//span[1]//div[1]//div[2]//ul[1]//li[1]//h2[1]//a[1]//span[1]")
	public WebElement firstProduct_MDP ;

}
