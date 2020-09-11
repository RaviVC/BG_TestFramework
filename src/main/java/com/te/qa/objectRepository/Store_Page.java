package com.te.qa.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Store_Page {
	@FindBy(how=How.XPATH,using="//div[@id='testorelink']//span[contains(text(),'Shop TE')]")
	public WebElement testore;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"te-page\"]/div[3]/div/div/div[2]/div/div/div[2]/div[1]/div/div/div/div/a/div[2]/p")
	public WebElement storeantennas;
	
	@FindBy(how=How.XPATH,using="//h2[contains(text(),'Buy Direct from the TE Store')]")
	public WebElement TEStoreProductsText;
	
	@FindBy(how=How.XPATH,using="//div[@class='product-grid-content editorial-parsys']")
	public WebElement TEStoreProducts;
	
	
	
	
	
	
	
	
}
