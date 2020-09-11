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
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
import com.te.qa.resources.Resource_Helper;

public class GenericMethods {
	
	public static Keys keys = null;
	public static WebDriver driver = null;
	public static WebDriverWait wait = null;
	public static Actions actions = null;
	public static Alert alert = null;
	public static JavascriptExecutor jse = null;
	public static Select select = null;
	public static Properties CONFIG;
	public static Process warning;

	public String configure(String Browser) {

		try {
			CONFIG = new Properties();
			FileInputStream fis = new FileInputStream(Resource_Helper.getResourcePath("\\Config\\config.properties"));
			CONFIG.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (Browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					Resource_Helper.getResourcePath(CONFIG.getProperty("ChromeDriver_Path")));
			driver = new ChromeDriver();
		} else if (Browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.chrome.driver",
					Resource_Helper.getResourcePath(CONFIG.getProperty("IEDriver_Path")));
			driver = new InternetExplorerDriver();
		} else if (Browser.equalsIgnoreCase("ff")) {
			System.setProperty("webdriver.chrome.driver",
					Resource_Helper.getResourcePath(CONFIG.getProperty("FFDriver_Path")));
			driver = new FirefoxDriver();
		}
		return Browser;
	}

	public void launchApp(String URL, String Environment) {
		String targetURL = null;

		if (Environment.equalsIgnoreCase("dev")) {
			targetURL = URL.replace("www.te.com", "www-dev.te.com");
		} else if (Environment.equalsIgnoreCase("qa")) {
			targetURL = URL.replace("www.te.com", "www-qa.te.com");
		} else if (Environment.equalsIgnoreCase("stage")) {
			targetURL = URL.replace("www.te.com", "www-stage.te.com");
		} else if (Environment.equalsIgnoreCase("prod")) {
			targetURL = URL.replace("https://www.greatpro.org/", "https://www.greatpro.org/");
		}

		driver.get(targetURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
	}
	
	public static void clickOnWebElement(WebElement element) {
		try {
			boolean elementStatus = element.isEnabled();
			while (elementStatus) {
				element.click();
			}
		} catch (Exception e) {
			System.out.println("Element is not enabled");
			e.getMessage();
		}
	}
	
	public static void switchToWindow(int index) {
		// Index 1 - Main window Index 2 - Child window

		String windowID = null;
		Set<String> windowIDs = driver.getWindowHandles();
		Iterator<String> iter = windowIDs.iterator();

		for (int i = 1; i <= index; i++) {
			windowID = iter.next();
		}
		driver.switchTo().window(windowID);
	}
	
	public static boolean switchWindow(String title) {
		Set<String> handles = driver.getWindowHandles();
		if (!handles.isEmpty())
			for (String win : handles) {
				if (driver.switchTo().window(win).getTitle().equals(title)) {
					return true;
				} else {
					driver.switchTo().window(win);
				}
			}
		return false;
	}
	
	public static void handleSSLCertificate() {

		System.setProperty("webdriver.chrome.driver", Resource_Helper.getResourcePath("\\Drivers\\chromedriver.exe"));
		ChromeOptions options = new ChromeOptions();

		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		driver = new ChromeDriver(options);
		driver.get("https://cacert.org/");
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
	
	public static void handleBootStrapDropDown(String xpathExpression) {
		List<WebElement> dropDownMenu = driver.findElements(By.xpath(xpathExpression));
		for (WebElement element : dropDownMenu) {
			String innerHTML = element.getAttribute("innerHTML");
			if (innerHTML.contentEquals("javascript")) {
				element.click();
			}
		}
	}
	
	public static Process executeAutoITScript(String path) {
		try {
			warning = Runtime.getRuntime().exec(path);
		}catch(IOException e) {
			e.getMessage();
		}
		return warning;
	}
	
	public static void clickCheckboxFromList(String element, String checkboxtobeselected) {
		List<WebElement> checkboxlist = driver.findElements(By.xpath(element));
		for (int i = 0; i < checkboxlist.size(); i++) {
			List<WebElement> list = checkboxlist.get(i).findElements(By.tagName("label"));
			for (WebElement cb : list) {
				if (checkboxtobeselected == cb.getText()) {
					cb.click();
					break;
				}
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
	
	public void scroll_Vertical(int scrollValue) {
		try {
			jse.executeScript("scroll(0," + scrollValue + ")");
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public static void threadSleepDelay(long delay) {
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.getMessage();
		}
	}

	public static void CheckTheCheckBox(WebElement checkbox) {
		boolean checkstatus = checkbox.isSelected();
		if (checkstatus == true) {
			System.out.println("checkbox is already selected");
		} else {
			checkbox.click();
			System.out.println("checkbox is checked");
		}
	}

	public static void uncheckTheCheckbox(WebElement checkbox) {
		boolean checkstatus = checkbox.isSelected();
		if (checkstatus == true) {
			checkbox.click();
			System.out.println("Checkbox is unchecked");
		} else {
			System.out.println("Checkbox is already selected");
		}
	}

	public static void CheckTheRadioButton(WebElement radiobutton) {
		boolean checkstatus = radiobutton.isSelected();
		if (checkstatus == true) {
			System.out.println("radiobutton is already selected");
		} else {
			radiobutton.click();
			System.out.println("radiobutton is checked");
		}
	}

	public static void uncheckTheRadioButton(WebElement radiobutton) {
		boolean checkstatus = radiobutton.isSelected();
		if (checkstatus == true) {
			radiobutton.click();
			System.out.println("radiobutton is unchecked");
		} else {
			System.out.println("radiobutton is already selected");
		}
	}
	
	public static String getRandNumber() {
		long currentTime = System.currentTimeMillis();
		Random r = new Random(currentTime);
		int Low = 1000;
		int High = 9080;
		int R = r.nextInt(High - Low) + Low;
		return Integer.toString(R + 1);
	}
	
	public static void SwitchToFrame(int frameIndex) {
		driver.switchTo().frame(frameIndex);
	}

	public static void SwitchToFrame(String frameName) {
		driver.switchTo().frame(frameName);
	}

	public static void SwitchToFrame(WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public static void implicitwait(int sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}

	public static void explicitWait(int sec, WebElement element) {
		wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void fluentWait(int timeoutduration, int pollingduration, WebDriver driver) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(timeoutduration, TimeUnit.SECONDS)
				.pollingEvery(pollingduration, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class, ElementNotVisibleException.class);
	}
	
	public static void handleScrollInsideWebElement(WebDriver driver, String CSS_Selector) {
		EventFiringWebDriver firingdriver = new EventFiringWebDriver(driver);
		firingdriver.executeScript("document.querySelector(CSS_Selector).scrollTop=500");
	}
	
	public static void selectElementByName(WebElement element, String elementToBeSelected) {
		select = new Select(element);
		select.selectByVisibleText(elementToBeSelected);
	}

	public static void selectElementByValue(WebElement element, String elementValue) {
		select = new Select(element);
		select.selectByValue(elementValue);
	}

	public static void selectElementByIndex(WebElement element, int indexValue) {
		select = new Select(element);
		select.selectByIndex(indexValue);
	}
	
	public static void dragAndDrop(WebElement fromElement, WebElement toElement) {
		actions = new Actions(driver);
		actions.clickAndHold(fromElement).moveToElement(toElement).release().build().perform();
	}

	public static void doubleClickOnWebElement(WebElement element) {
		actions = new Actions(driver);
		actions.doubleClick().build().perform();
	}

	public static void hoverOverWebElement(WebElement element) {
		actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}

	
	
	
	

	
		
	
	


}
