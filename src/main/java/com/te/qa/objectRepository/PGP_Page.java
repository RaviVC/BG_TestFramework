package com.te.qa.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PGP_Page {

	@FindBy(how=How.XPATH,using="//div[@class='view-all']//a")
	public WebElement viewAllConnectors;

}
