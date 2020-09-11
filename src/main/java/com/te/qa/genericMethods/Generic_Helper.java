package com.te.qa.genericMethods;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
import com.te.qa.resources.Resource_Helper;

public class Generic_Helper  {
	
	public static Keys keys = null;
	public static WebDriver driver = null;
	public static Actions builder = null;
	private static JavascriptExecutor jse = null;
	private static Select select = null;
	public static WebDriverWait wait = null; 
	
	public static void pressKeyDown(WebElement element) {
		element.sendKeys(keys.DOWN);
	}
	
	public static void pressKeyUP(WebElement element) {
		element.sendKeys(keys.UP);
	}
	
	public static void pressKeyEnter(WebElement element) {
		element.sendKeys(Keys.ENTER);
	}
	
	public static void moveToTab(WebElement element) {
		element.sendKeys(Keys.chord(Keys.ALT,Keys.TAB));
	}
	
	public static void clickAllLinksInPage() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total number of links is " + links.size());
		
		for(int i =0; i<=links.size();i ++) {
			System.out.println("Links present in an application" + links.get(i).getText());
			links.get(i).click();
			driver.getCurrentUrl();
		}
	}
	
	public static void navigateForward() {
		driver.navigate().forward();
	}
	
	public static void navigateBackward() {
		driver.navigate().back();
	}
	
	public static void refresh() {
		driver.navigate().refresh();
	}
	
	public static void implicitWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	
	public static void pageLoadTimeOut(int seconds) {
		driver.manage().timeouts().pageLoadTimeout(seconds, TimeUnit.SECONDS);
	}
	
	public static void clearInputTextField(WebElement element) {
		element.clear();
	}
	
	public static void clickOnWebElement(WebElement element) {
		try {
			boolean elementIsClickable = element.isEnabled();
			while(elementIsClickable) {
				element.click();
			}
		} catch (Exception e) {
			System.out.println(element + "element is not enabled" );
			e.getMessage();
		}
	}
	
	public static void clickMultipleElements(WebElement someElement, WebElement someOtherElement) {
		builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).click(someElement).click(someOtherElement).keyUp(Keys.CONTROL).build().perform();
	}
	
	public static boolean checkAlert_Accept() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertName = alert.getText();
			System.out.println(alertName);
			alert.accept();
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}
	
	public static boolean checkAlert_Dismiss() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertName = alert.getText();
			System.out.println(alertName);
			alert.dismiss();
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}
	
	public static String generateRandomNumber(){
	
	   long currentTime = System.currentTimeMillis();

       Random r = new Random(currentTime);
       int Low = 10000000;
       int High = 900000000;
       int R = r.nextInt(High - Low) + Low;
       return Integer.toString(R + 12)+"3";
	}
	
	public void scroll_Vertical(int scrollValue){
		try {
			jse.executeScript("scroll(0," + scrollValue + ")");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void threadSleepDelay(long milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.getMessage();
		}
	}
	
	public static void checkTheCheckbox(WebElement checkbox) {
		boolean checkstatus;
		checkstatus = checkbox.isSelected();
		if(checkstatus==true) {
			System.out.println("Checkbox is already checked");
		}else {
			checkbox.click();
			System.out.println("checked checkbox");
		}
	}
	
	public static void checkTheRadiobutton(WebElement radiobutton) {
		boolean checkstatus;
		checkstatus = radiobutton.isSelected();
		if(checkstatus==true) {
			System.out.println("radiobutton is already checked");
		}else {
			radiobutton.click();
			System.out.println("checked radiobutton");
		}
	}
	
	public static void uncheckTheCheckbox(WebElement checkbox) {
		boolean checkstatus;
		checkstatus = checkbox.isSelected();
		if(checkstatus==true) {
			checkbox.click();
			System.out.println("Checkbox unchecked");
		}else {
			System.out.println("checkbox is checked");
		}
	}
	
	public static void uncheckTheRadiobutton(WebElement radiobutton) {
		boolean checkstatus;
		checkstatus = radiobutton.isSelected();
		if (checkstatus == true) {
			radiobutton.click();
			System.out.println("radiobutton is unchecked");
		} else {
			radiobutton.click();
			
			System.out.println("radiobutton is already checked");
		}
	}
	
	public static void dragAndDrop(WebElement fromWebElement, WebElement toWebELement) {
		builder = new Actions(driver);
		Action dragndrop = builder.clickAndHold(fromWebElement).moveToElement(toWebELement).release(toWebELement).build();
		dragndrop.perform();
	}
	
	public static void doubleClickOnElement(WebElement doubleClickOnElement) {
		builder = new Actions(driver);
		builder.doubleClick(doubleClickOnElement).perform();
		threadSleepDelay(2000);
	}
	
	public static void hoverOverElement(WebElement hoverToElement) {
		builder = new Actions(driver);
		builder.moveToElement(hoverToElement).perform();
		threadSleepDelay(2000);
	}
	
	public static String getToolTip(WebElement toolTipofWebElement) throws InterruptedException {
		String tooltip = toolTipofWebElement.getAttribute("title");
		System.out.println("Tool text" + tooltip);
		return tooltip;
	}
	
	public static void clearSearchInputField(WebElement element) {
		element.clear();
	}

	public static void searchInputFiled(WebElement element, String SearchInputvalue) {
		element.sendKeys(SearchInputvalue);
		element.sendKeys(keys.ENTER);		
	}
	
	public static void InputTextField(WebElement element, String InputTextvalue) {
		element.sendKeys(InputTextvalue);
		element.sendKeys(keys.ENTER);		
	}
	
	public static void selectElementByName(WebElement element, String elementToBeselected) {
		select = new Select(element);
		select.selectByVisibleText(elementToBeselected);
	}
	
	public static void selectElementByValue(WebElement element, String elementToBeselected) {
		select = new Select(element);
		select.selectByValue(elementToBeselected);
	}
	
	public static void selectElementByIndex(WebElement element, int integerValue) {
		select = new Select(element);
		select.selectByIndex(integerValue);
	}
	
	public static void clickcheckboxfromlist(String element, String checkboxtobeselected) {
		List<WebElement> checkboxlist = driver.findElements(By.xpath(element));
		for(int i=0;i<=checkboxlist.size();i++) {
			List<WebElement> list = checkboxlist.get(i).findElements(By.tagName("label"));
			for(WebElement cb: list) {
				if(checkboxtobeselected==cb.getText()) {
					cb.click();
					break;
				}
			}	
		}
	}
	
	public static void takeScreenShot() {
		
		TakesScreenshot scrshot = ((TakesScreenshot) driver);
		File SrcFile = scrshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		File DestFile = new File(
				System.getProperty("user.dir") + "\\Screenshots\\ScreenshotImage" + date.getTime() + ".png");
		try {
			Files.copy(SrcFile, DestFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Screeshot taken");
		driver.close();
	}
	
	public static WebDriverWait explicitWait() {
		return wait = new WebDriverWait(driver, 90);
	}
	
	public static void clickUsingJavaScriptExecutor(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()",element);
	}
	
	public static void sendKeysUsingJavaScriptExecutor(WebElement element, String text) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].value = arguments[1]",element,text);
	}
	
	public static void handleBootStrapDropDown(String xpathExpression ) {
		List<WebElement> dropdownmenu = driver.findElements(By.xpath(xpathExpression));
		for(WebElement element:dropdownmenu) {
			String innerHTML = element.getAttribute("innerHTML");
			if(innerHTML.contentEquals("javaScript")) {
				element.click();
			}
		}
	}
	
	public static void handleWebElementNotClickable(WebElement element,String xpathExpression) {
		builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath(xpathExpression))).click().build().perform();
	}
	
	public static void hiddenWebElements(String xpath) {
		List<WebElement> webelement = driver.findElements(By.xpath(xpath));
		System.out.println(webelement.size());
		for(int i=0;i<webelement.size();i++) {
			int x = webelement.get(i).getLocation().getX();
			if(x!=0) {
				
				webelement.get(i).click();
				break;
			}
		}
	}
	
	public static void handleCalendar(String xpathExpression, String Selectdate) {
		List<WebElement> dates = driver.findElements(By.xpath(xpathExpression));
		int totaldateCount = dates.size();
		for (int i = 0; i < totaldateCount; i++) {
			String date = dates.get(i).getText();
			if(date.equals(Selectdate)) {
				dates.get(i).click();
				break;
			}
		}	
	}
		
	public static void handleScrollInsideWebElement(WebDriver driver, String CSS_Selector, String VisibleText){
		EventFiringWebDriver firingwebdriver = new EventFiringWebDriver(driver);
		firingwebdriver.executeScript("document.querySelector(CSS_Selector).scrollTop=500");
	}
	
	public static String handleAuthenticationPopUP(String TE_URL, String Authentication_URL) {
		String targetURL = null;
		return targetURL = TE_URL.replace(TE_URL, Authentication_URL);
	}

}
