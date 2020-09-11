package com.te.qa.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Home_Page {
	
	@FindBy(how=How.XPATH,using="//input[@id='search-input']")
	public WebElement searchInputField;
	
	@FindBy(how=How.XPATH,using="//input[@value='Search by part # or keyword']")
	public WebElement searchIcon;
	
	@FindBy(how=How.XPATH,using="//a[@id='link-menu-top-1']")
	public WebElement productsTab;
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'Connectors')]")
	public WebElement connectors;
	
	@FindBy(how=How.XPATH,using="//input[@value='Search by part # or keyword']")
	public WebElement searchButton ;
	
	@FindBy(how=How.XPATH,using="//a[@id='te-logo']")
	public WebElement homePageButton;
	
	@FindBy(how=How.XPATH,using="//ul[@class='menu-list']")
	public WebElement productsMenu;
	
	@FindBy(how=How.XPATH,using="//a[@id='link-menu-top-2']")
	public WebElement ISMenu;
	
	@FindBy(how=How.XPATH,using="//h2[contains(text(),'Browse Most Viewed Products')]")
	public WebElement browseMostViewedProducts;
	
	@FindBy(how=How.XPATH,using="//ul[@class='footer-menu wrapper']")
	public WebElement footerMenu;
	
	@FindBy(how=How.XPATH,using="//a[@class='track-order guest-user-commerce show-track-order']")
	public WebElement trackUrOrder;
	
	@FindBy(how=How.XPATH,using="//span[@class='header-livechat']")
	public WebElement liveChat;
	
	@FindBy(how=How.XPATH,using="//div[@id='noAgentMsPIC']//a[@class='btn-block-11 btn-clr-13 login-button'][contains(text(),'SEND EMAIL REQUEST')]")
	public WebElement sendEmailRequest;
	
	
	public void SearchPartNumber(String PartNumber) {
		searchInputField.sendKeys(PartNumber);
		searchIcon.click();
	}
	
	public void SearchPartName(String PartName) {
		searchInputField.sendKeys(PartName);
		searchIcon.click();
	}

}
