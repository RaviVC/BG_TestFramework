package com.te.qa.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PDP_Page {
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Add to Cart')]")
	public WebElement addToCart ;

}
