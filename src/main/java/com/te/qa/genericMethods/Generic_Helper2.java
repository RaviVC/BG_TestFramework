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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class Generic_Helper2 {
	
	public static Keys keys = null;
	public static WebDriver driver = null;
	public static Alert alert;
	public static JavascriptExecutor jse = null;
	public static Actions actions = null;
	public static Select select = null;
	public static WebDriverWait wait = null;
	
	public static void pressKeyUP(WebElement element) {
		element.sendKeys(Keys.UP);
	}
	
	public static void pressKeyDown(WebElement element) {
		element.sendKeys(Keys.DOWN);
	}
	
	public static void pressArrowUP(WebElement element) {
		element.sendKeys(Keys.ARROW_UP);
	}

	public static void pressArrowDown(WebElement element) {
		element.sendKeys(Keys.ARROW_DOWN);
	}
	
	public static void pressArrowRight(WebElement element) {
		element.sendKeys(Keys.ARROW_RIGHT);
	}
	
	public static void pressArrowLeft(WebElement element) {
		element.sendKeys(keys.ARROW_LEFT);
	}
	
	public static void pressPageUP(WebElement element) {
		element.sendKeys(keys.PAGE_UP);
	}
	
	public static void pressBackspace(WebElement element) {
		element.sendKeys(keys.BACK_SPACE);
	}
	
	public static void pressEscape(WebElement element) {
		element.sendKeys(keys.ESCAPE);
	}
	
	public static void pressCancel(WebElement element) {
		element.sendKeys(keys.CANCEL);
	}
	
	public static void pressEnter(WebElement element) {
		element.sendKeys(keys.ENTER);
	}
	
	public static void pressTab(WebElement element) {
		element.sendKeys(keys.TAB);
	}
	
	public static void pressAltTab(WebElement element) {
		element.sendKeys(keys.chord(keys.ALT,keys.TAB));
	}
	
	public static void clickAllLinksInPage(WebElement element) {
		List<WebElement> links = driver.findElements(By.tagName("a"));
			for(WebElement pageLinks:links) {
				System.out.println(pageLinks.getText());
				pageLinks.click();
			}
	}
	
	public static void clickAllLinks(WebElement element) {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		int linksSize = links.size();
		System.out.println(links.size());
		
		for(int i=0; i<=linksSize; i++) {
			System.out.println(links.get(i).getText());
			links.get(i).click();
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
	
	public static void implicitwait() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public static void pageLoadTimeOut() {
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	public static void clickOnWebElement(WebElement element) {
		boolean elementStatus = element.isEnabled();
		if(elementStatus==true) {
			element.click();
		}else {
			System.out.println("Element is not enabled");
		}
	}
	
	public static boolean checkAlert_Accept() {
		
		try {
			driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}
	
	public static boolean checkAlert_Dismiss() {
		try {
			driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.dismiss();
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}
	
	public static String generateRandomNumber() {
		
		long currentTime = System.currentTimeMillis();
		
		Random r = new Random(currentTime);
		
		int low = 10000000;
		int high = 900000000;
		int R = r.nextInt(high-low)+low;
		return Integer.toString(R+12)+"3";
	}
	
	public static void scroll_vertical(int scrollValue) {
		
		try {
			jse.executeScript("scroll,(0,"+scrollValue+")");
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public static void threadSleepDelay(long milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {	
			e.getMessage();
		}
	}
	
	public static void checkThecheckbox(WebElement checkbox) {
		boolean checkstatus;
		checkstatus = checkbox.isSelected();
		if(checkstatus==true) {
			System.out.println("checkbox is already selected");
		}else {
			checkbox.click();
		}
	}
	
	public static void uncheckTheCheckbox(WebElement checkbox) {
		boolean checkstatus;
		checkstatus = checkbox.isSelected();
		if(checkstatus==true) {
			checkbox.click();
		}else {
			System.out.println("checkbox is already selected");
		}
	}
	
	public static void checkTheRadiobutton(WebElement radiobutton) {
		boolean radiobuttonStatus;
		radiobuttonStatus = radiobutton.isSelected();
		if(radiobuttonStatus==true) {
			System.out.println("Radiobutton is already selected");
		}else {
			radiobutton.click();
		}
	}
	
	public static void uncheckTheRadioButton(WebElement radiobutton) {
		boolean radiobuttonStatus;
		radiobuttonStatus = radiobutton.isSelected();
		if(radiobuttonStatus==true) {
			radiobutton.click();
		}else {
			System.out.println("Radio button is already selected");
		}
	}
	
	public static void dragAndDrop(WebElement fromElement, WebElement toElement) {
		Actions dragndrop = actions.clickAndHold(fromElement).moveToElement(toElement).release();
		dragndrop.build().perform();
	}
	
	public static void doubleClickOnWebElement(WebElement element) {
		actions = new Actions(driver);
		actions.doubleClick(element).build().perform();
	}
	
	public static void hoverOverElement(WebElement targetElement) {
		actions = new Actions(driver);
		actions.moveToElement(targetElement).build().perform();
	}
	
	public static void searchInput(String searchText, WebElement element) {
		element.sendKeys(searchText);
		element.sendKeys(keys.ENTER);
	}
	
	public static void clearSearchInputField(WebElement element) {
		element.clear();
	}
	
	public static void selectByName(WebElement element, String visibleText) {
		select = new Select(element);
		select.selectByVisibleText(visibleText);
	}
	
	public static void selectByIndex(WebElement element, int count) {
		select = new Select(element);
		select.selectByIndex(count);
	}
	
	public static void selectByValue(WebElement element, String value) {
		select = new Select(element);
		select.selectByValue(value);
	}
	
	public static void checkboxtobeselected(String element, String checkboxValue) {
		List<WebElement> checkboxlist = driver.findElements(By.xpath(element));
		int size = checkboxlist.size();
		for(int i=0;i<size;i++) {
			List<WebElement> list = checkboxlist.get(i).findElements(By.tagName("label"));
			for(WebElement cb:list) {
				if(checkboxValue==cb.getText()) {
					cb.click();
				}
			}
		}
	}
	
	public static void radioButtonToBeSelected(String element, String radioButtonToBeSelected) {
		List<WebElement> radiobuttonlist = driver.findElements(By.xpath(element));
		int size = radiobuttonlist.size();
		for(int i=0;i<size;i++) {
			List<WebElement> list = radiobuttonlist.get(i).findElements(By.tagName("label"));
			for(WebElement rb:list) {
				if(radioButtonToBeSelected==rb.getText()) {
					rb.click();
					break;
				}
			}
		}
	}
	
	public static void takeScreenShot() {
		TakesScreenshot scrshot = (TakesScreenshot) driver;
		File scrFile = scrshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		File destfile = new File(System.getProperty("user.dir")+"\\ExtentReport\\ScreenShotImages"+date.getTime()+".png");
		try {
			Files.copy(scrFile, destfile);
		} catch (IOException e) {
			e.getMessage();
		}
		System.out.println("screenshot taken");
		driver.close();
	}
	
	public static WebDriverWait explicitWait(int seconds) {
		return wait = new WebDriverWait(driver, 30);
	}
	
	public static void clickUisngJavaScriptExecutor(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click", element);
	}
	
	public static void sendkeysJavaScriptExecutor(WebElement element, String text) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].value = arguments[1]", element,text);
	}
	
	public static void handleWebElementNotClickable(WebElement element) {
		actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
	}
	
	public static void handleCalendar(String xpathExpression, String calendarElementToBeSelected) {
		List<WebElement> dates = driver.findElements(By.xpath(xpathExpression));
		int size = dates.size();
		for(int i=0;i<size;i++) {
			String date = dates.get(i).getText();
			if(date.equalsIgnoreCase(calendarElementToBeSelected)) {
				dates.get(i).click();
				break;
			}
		}
	}
	
	public static void handleScrollInsideWebElement(WebDriver driver, String CSS_Selector) {
		EventFiringWebDriver firingdriver = new EventFiringWebDriver(driver);
		firingdriver.executeScript("document.querySelector(CSS_Selector).scrollTop=500");
	}
	
	public static void switchToFrame(String frameElement) {
		driver.switchTo().frame(frameElement);
	}
	
	
	
}


