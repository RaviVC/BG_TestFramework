package com.te.qa.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Test;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.te.qa.genericMethods.GenericMethods;
import com.te.qa.genericMethods.Generic_Helper;
import com.te.qa.objectRepository.Home_Page;
import com.te.qa.objectRepository.MDP_Page;
import com.te.qa.objectRepository.PDP_Page;
import com.te.qa.objectRepository.PGP_Page;
import com.te.qa.objectRepository.PLP_Page;
import com.te.qa.objectRepository.SearchOrder_Page;
import com.te.qa.objectRepository.Search_Page;
import com.te.qa.objectRepository.Store_Page;
import com.te.qa.resources.Resource_Helper;
 
public class BaseTest extends GenericMethods {
	
	public static Properties CONFIG;
	public static WebDriver driver;
	public static File reportDirectory;
	private JavascriptExecutor jse = null;
	public static ExtentHtmlReporter htmlreporter;
	public static ExtentReports extent;
	public static Home_Page homepage;
	public static ExtentTest test;
	public static Store_Page storepage;
	public static PGP_Page pgppage;
	public static PLP_Page plppage;
	public static MDP_Page mdppage;
	public static PDP_Page pdppage;
	public static Search_Page searchpage;
	public static SearchOrder_Page searchOrderPage;
		
	@BeforeSuite
	public void beforeSuite(){
		configure("chrome");
	}
	
	@BeforeClass
	public void beforeClass(){
		Date date = new Date();
		String filename = System.getProperty("user.dir") + "\\ExtentReports\\TE_SmokeTestResults" + date.getTime()
		+ ".html";
		
		htmlreporter = new ExtentHtmlReporter(filename);
		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
		
		htmlreporter.config().setReportName("TE Automation Test Results");
		htmlreporter.config().setTheme(Theme.STANDARD);
		htmlreporter.config().setTestViewChartLocation(ChartLocation.TOP);
		
		extent.setSystemInfo("Username", "Ravi");
		extent.setSystemInfo("Windows", "10");
		extent.setSystemInfo("Selenium", "3.11");
		extent.setSystemInfo("Java", "1.8");
	}
	
	@BeforeTest
	public void beforeTest(){
		homepage = PageFactory.initElements(driver, Home_Page.class);
		pgppage = PageFactory.initElements(driver, PGP_Page.class);
		plppage = PageFactory.initElements(driver, PLP_Page.class);
		mdppage = PageFactory.initElements(driver, MDP_Page.class);
		pdppage = PageFactory.initElements(driver, PDP_Page.class);
		storepage = PageFactory.initElements(driver, Store_Page.class);
		searchpage = PageFactory.initElements(driver, Search_Page.class);
		searchOrderPage = PageFactory.initElements(driver, SearchOrder_Page.class);
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result){
		if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName() + " " + "Is Executed and result is PASS" );
		}else if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getName()+" Is Failed " + result.getThrowable());
		}else if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.FAIL, result.getName()+" Is Skipped " + result.getThrowable());
		}
	}
	
	@AfterClass
	public void afterClass(){
		extent.flush();
	}
	
	@AfterSuite
	public void afterSuite() {
		driver.quit();
	}
	
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
		
		if(Browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", Resource_Helper.getResourcePath(CONFIG.getProperty("ChromeDriver_Path")));
			driver = new ChromeDriver();
		}else if(Browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.chrome.driver", Resource_Helper.getResourcePath(CONFIG.getProperty("IEDriver_Path")));
			driver = new InternetExplorerDriver();
		}else if(Browser.equalsIgnoreCase("ff")) {
			System.setProperty("webdriver.chrome.driver", Resource_Helper.getResourcePath(CONFIG.getProperty("FFDriver_Path")));
			driver = new FirefoxDriver();
		}
		return Browser;
	}
	
	public void launchApp(String URL,String Environment) {
		String targetURL = null;
			
		if(Environment.equalsIgnoreCase("dev")) {
			targetURL = URL.replace("www.te.com", "www-dev.te.com");
		}else if(Environment.equalsIgnoreCase("qa")) {
			targetURL = URL.replace("www.te.com", "www-qa.te.com");
		}else if(Environment.equalsIgnoreCase("stage")) {
			targetURL = URL.replace("www.te.com", "www-stage.te.com");
		}else if(Environment.equalsIgnoreCase("prod")) {
			targetURL = URL.replace("https://www.greatpro.org/", "https://www.greatpro.org/");
		}
		
		driver.get(targetURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	public String captureScreen(String fileName) {
		if (driver == null) {
			// log.info("driver is null");
			return null;
		}
		if (fileName == "") {
			fileName = "blank";
		}

		File destFile = null;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			
			destFile = new File(reportDirectory + "/" + fileName + "_" + formater.format(calendar.getTime()) + ".png");
			Files.copy(srcFile.toPath(), destFile.toPath());
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath()
					+ "' height='100' width='100'/> </a>");
		} catch (Exception e) {

		}
		return destFile.toString();
	}
	
	public void ReturnToHomePage() {
		threadsleepdelay(4000);
		homepage.homePageButton.click();
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

	public static void threadSleepWait(long millisecs) {
		try {
			Thread.sleep(millisecs);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
	
	public void threadsleepdelay(long millisecs){
   	try {
			Thread.sleep(millisecs);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
   }
}
