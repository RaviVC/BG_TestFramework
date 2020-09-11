package com.te.qa.genericMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
import com.te.qa.resources.Resource_Helper;

public class Generic2 {
	
	public static Properties CONFIG = null;
	public static WebDriver driver = null;
	public static Process warning = null;
	public static Alert alert = null;
	public static JavascriptExecutor jse = null;
	public static WebDriverWait wait = null;
	public static Select select = null;
	public static Actions actions = null;
	
	public String configure(String browser) {
		try {
			CONFIG = new Properties();
			FileInputStream fis = new FileInputStream(Resource_Helper.getResourcePath("\\Config\\config.properties"));
			CONFIG.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("web.chrome.driver", Resource_Helper.getResourcePath("\\Drivers\\chromedriver.exe"));
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("IE")) {
			System.setProperty("web.chrome.driver", Resource_Helper.getResourcePath("\\Drivers\\chromedriver.exe"));
			driver = new InternetExplorerDriver();
		}else if(browser.equalsIgnoreCase("FF")) {
			System.setProperty("web.chrome.driver", Resource_Helper.getResourcePath("\\Drivers\\chromedriver.exe"));
			driver = new InternetExplorerDriver();
		}
		return browser;
	}
	
	public void launchApp(String URL, String Env) {
		String targetURL = null;
		
		if(Env.equalsIgnoreCase("QA")) {
			targetURL=URL.replaceAll("www.te.com", "www-qa.te.com");
		}else if (Env.equalsIgnoreCase("Stage")) {
			targetURL = URL.replaceAll("www.te.com", "www-stage.te.com");
		}else if(Env.equalsIgnoreCase("PROD")) {
			targetURL=URL.replaceAll("www.te.com", "www.te.com");
		}
		
		driver.get(targetURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	public static boolean clickOnWebElement(WebElement element) {
		boolean checkelementstatus;
		checkelementstatus=element.isDisplayed();
		if(checkelementstatus==true) {
			element.click();
		}else {
			System.out.println("Webelement is not displayed");
		}
		return checkelementstatus;
	}
	
	public static void switchToWindow(int index) {
		String windowID=null;
		Set<String> windowIDS = driver.getWindowHandles();
		Iterator<String> iter = windowIDS.iterator();
		for(int i=0;i<index;i++) {
			windowID = iter.next();
		}
		driver.switchTo().window(windowID);
	}
	
	public static boolean switchWindow(String title) {
		Set<String> handles = driver.getWindowHandles();
		if(!handles.isEmpty()) {
			for(String win:handles) {
				if(driver.switchTo().window(win).getTitle().equals(title)){
					return true;
				}else {
					driver.switchTo().window(win);
				}
			}
		}
		return false;
	}
	
	public static void handleSSLCertificate(String url) {
		ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		driver = new ChromeDriver(options);
		driver.get(url);
	}
	
	public static void takeScreenshot() {
		TakesScreenshot scrshot = (TakesScreenshot) driver;
		File scrFile = scrshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		File destFile = new File(System.getProperty(Resource_Helper.getResourcePath("\\Screenshots\\Screenshotimages"+date.getTime()+".png")));
		try {
			Files.copy(scrFile, destFile);
		} catch (IOException e) {
			e.getMessage();
		}
		System.out.println("screenshot taken");
		driver.close();
	}
	
	public static void handleCalendar(String xpathExpression, String calendarvaluetobeselected) {
		List<WebElement> calendarlist = driver.findElements(By.xpath(xpathExpression));
		int size = calendarlist.size();
		for(int i=0;i<size;i++) {
			String date = calendarlist.get(i).getText();
			if(calendarvaluetobeselected.equalsIgnoreCase(date)) {
				calendarlist.get(i).click();
			}
		}
	}
	
	public static Process executeAutoITScript(String path) {
		try {
			warning = Runtime.getRuntime().exec(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return warning;
	}
	
	public void handleCheckBoxFromList(String xpathExpression,String checkBoxValue) {
		List<WebElement> checkboxlist = driver.findElements(By.xpath(xpathExpression));
		int size = checkboxlist.size();
		for(int i=0;i<size;i++) {
			String list = checkboxlist.get(i).getText();
			if(checkBoxValue.equalsIgnoreCase(list)) {
				checkboxlist.get(i).click();
				break;
			}
		}
	}
	
	public static boolean checkAlert_Accept() {
		try {
			alert = driver.switchTo().alert();
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
			alert = driver.switchTo().alert();
			String alertName = alert.getText();
			System.out.println(alertName);
			alert.dismiss();
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}
	
	public static void scrollVertical(int scrollvalue) {
		try {
			jse.executeScript("scroll(0,"+scrollvalue+")");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void threadSleepDelay(long delay) {
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.getMessage();
		}
	}
	
	public static void checkTheCheckBox(WebElement element) {
		boolean checkelementstatus = element.isSelected();
		if(checkelementstatus==true) {
			System.out.println("ELement is already selected");
		}else {
			element.click();
			System.out.println("Element is checked");
		}
	}
	
	public static void uncheckTheCheckBox(WebElement element) {
		boolean checkelementstatus = element.isSelected();
		if(checkelementstatus==true) {
			element.click();
		}else {
			System.out.println("Already unchecked");
		}
	}
	
	public String generateRandomNumber() {
		long currentTime = System.currentTimeMillis();
		Random r = new Random(currentTime);
		int high = 10000000;
		int low =  9999999;
		int R = (high-low)+low;
		return Integer.toString(R+1);
	}
	
	public static void switchToFrame(int frameIndex) {
		driver.switchTo().frame(frameIndex);
	}
	
	public static void switchToFrame(String ID) {
		driver.switchTo().frame(ID);
	}
	
	public static void switchToFrame(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	
	public static void explicitWait(int seconds,WebElement element) {
		wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void selectElementByVisibleText(WebElement element,String elementToBeSelected) {
		select = new Select(element);
		select.selectByVisibleText(elementToBeSelected);
	}
	
	public static void selectElementByIndex(WebElement element,int elementToBeSelected) {
		select = new Select(element);
		select.selectByIndex(elementToBeSelected);
	}
	
	public static void selectElementByValue(WebElement element, String elementToBeSelected) {
		select = new Select(element);
		select.selectByValue(elementToBeSelected);
	}
	
	public static void dragAndDrop(WebElement fromElement,WebElement toElement ) {
		actions = new Actions(driver);
		actions.clickAndHold(fromElement).moveToElement(toElement).release().build().perform();
	}
	
	public static void doubleCliclOnWebElement(WebElement element) {
		actions = new Actions(driver);
		actions.doubleClick().build().perform();
	}
	
	public static void hoverOverElement(WebElement element) {
		actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}
	
	
	
	
}
	
	
	

