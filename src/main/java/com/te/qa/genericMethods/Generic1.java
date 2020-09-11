package com.te.qa.genericMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import com.aventstack.extentreports.Status;
import com.google.common.io.Files;
import com.te.qa.resources.Resource_Helper;
import com.te.qa.testBase.BaseTest;

public class Generic1 extends BaseTest {
	
	public static Properties CONFIG = null;
	public static WebDriver driver = null;
	public static Process warning = null;
	public static Alert alert = null;
	public static JavascriptExecutor jse = null;
	
	public String configure(String browser) {
		CONFIG = new Properties();
		try {
			FileInputStream fis = new FileInputStream(Resource_Helper.getResourcePath("\\Config\\config.properties"));
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("web.chrome.driver", Resource_Helper.getResourcePath("\\Drivers\\chromedriver.exe"));
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("ff")) {
			System.setProperty("web.chrome.driver", Resource_Helper.getResourcePath("\\Drivers\\iedriver.exe"));
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("ie")) {
			System.setProperty("web.chrome.driver", Resource_Helper.getResourcePath("\\Drivers\\chromedriver.exe"));
			driver = new ChromeDriver();
		}
		return browser;
	}
	
	public void launchApp(String URL, String Env) {
		
		String targetURL = null;
		
		if(Env.equalsIgnoreCase("qa")) {
			targetURL = URL.replace("www.te.com", "www-qa.te.com");
		}else if(Env.equalsIgnoreCase("stage")) {
			targetURL = URL.replace("www.te.com", "www-stage.te.com");
		}else if(Env.equalsIgnoreCase("prod")) {
			targetURL = URL.replaceAll("www-te.com", "www.te.com");
		}
		
		driver.get(targetURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	public static void clickOnWebElement(WebElement element) {
		boolean elementStatus;
		elementStatus = element.isDisplayed();
		if(elementStatus==true) {
			element.click();
			test.log(Status.INFO, "Element is displayed and clicked");
		}else {
			test.log(Status.FAIL, "Element is not displayed");
		}
	}
	
	public static void sendKeysInInputTextField(WebElement element, String textToBeEntered) {
		boolean elementstatus;
		elementstatus = element.isDisplayed();
		if(elementstatus==true) {
			element.sendKeys(textToBeEntered);
			test.log(Status.INFO, "Element is displayed and tet entered");
		}else {
			test.log(Status.FAIL, "Element is not displayed");
		}
	}
	
	public static void switchToWindow(int index) {
		String WindowID = null;
		Set<String> windowIDS = driver.getWindowHandles();
		Iterator<String> iter = windowIDS.iterator();
		for(int i=0;i<=index;i++) {
			WindowID = iter.next();
		}
		driver.switchTo().window(WindowID);
	}
	
	public static boolean switchWindow(String title) {
		
		Set<String> handles = driver.getWindowHandles();
		if(!handles.isEmpty()) {
			for(String win:handles) {
				if(driver.switchTo().window(win).getTitle().equals(title)) {
					return true;
				}else {
					driver.switchTo().window(win);
				}
			}
		}
		return false;
	}
	
	public static void handleSSLCertificate(String URL) {
		ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		driver = new ChromeDriver(options);
		driver.get(URL);
	}
	
	public static void getScreenshot() {
		TakesScreenshot scrshot = (TakesScreenshot) driver;
		File scrFile = scrshot.getScreenshotAs(OutputType.FILE);
		
		Date date = new Date();
		File destFile = new File(System.getProperty(Resource_Helper.getResourcePath("\\Screenshots\\Screenshotimages")));
		try {
			Files.copy(scrFile, destFile);
		} catch (IOException e) {
			e.getMessage();
		}
		System.out.println("screenshot taken");
		driver.close();
	}
	
	public static void handleCalendar(String xpathExpression, String calendarValue) {
		List<WebElement> calendarList = driver.findElements(By.xpath(xpathExpression));
		int size = calendarList.size();
		for(int i=0;i<size;i++) {
			String date = calendarList.get(i).getText();
			if(calendarValue.equalsIgnoreCase(date)) {
				calendarList.get(i).click();
				break;
			}
		}
	}
	
	public static void handleCalender(String xpathExpression, String calendarvalue) {
		List<WebElement> dates = driver.findElements(By.xpath(xpathExpression));
		for(WebElement calDate:dates) {
			if(calDate.equals(calendarvalue)) {
				calDate.click();
				break;
			}
		}
	}
	
	public static Process executeAutoITScript(String path) {
		try {
			warning = Runtime.getRuntime().exec(path);
		} catch (IOException e) {
			e.getMessage();	
		}
		return warning;
	}
	
	public static void clickCheckBoxFromList(String xpathExpression, String checkboxtobeselected) {
		List<WebElement> checkboxlist = driver.findElements(By.xpath(xpathExpression));
		int size = checkboxlist.size();
		for(int i=0;i<size;i++) {
			String checkboxvalue = checkboxlist.get(i).getText();
			if(checkboxtobeselected.equalsIgnoreCase(checkboxvalue)) {
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
	
	public void scroll_Vertical(int scrollvalue) {
		try {
			jse.executeScript("scroll(0,"+scrollvalue+")");
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public static void threadSleepDelay(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.getMessage();
		}
	}
	
	public static void checkTheCheckBox(WebElement element) {
		boolean checkelementStatus;
		checkelementStatus = element.isSelected();
		if(checkelementStatus==true) {
			System.out.println("Element is already selected");
		}else {
			element.click();
		}
	}
	
	public static void uncheckTheCheckBox(WebElement element) {
		boolean checkelementStatus;
		checkelementStatus = element.isSelected();
		if(checkelementStatus==true) {
			element.click();
		}else {
			System.out.println("element is already unchecked");
		}
	}
	
	public static String randomNumer() {
		long currentTime = System.currentTimeMillis();
		Random random = new Random(currentTime);
		int high = 10000000;
		int low =  99999999;
		int r = random.nextInt(high-low)+low;
		return Integer.toString(r);
	}
	
	public static void SwitchToFrame(int frameIndex) {
		driver.switchTo().frame(frameIndex);
	}
	
	
	
	
	
}
