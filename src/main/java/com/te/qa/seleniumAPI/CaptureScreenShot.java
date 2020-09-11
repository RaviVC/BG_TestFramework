package com.te.qa.seleniumAPI;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;
import com.te.qa.resources.Resource_Helper;

public class CaptureScreenShot {

	static WebDriver driver = null;

	public static void main(String[] args) throws IOException {

		takeScreenShot();

	}

	public static void takeScreenShot() {
		System.setProperty("webdriver.chrome.driver", Resource_Helper.getResourcePath("\\Drivers\\chromedriver.exe"));
		driver = new ChromeDriver();

		driver.get("https://www.te.com/usa-en/home.html");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		TakesScreenshot scrshot = ((TakesScreenshot) driver);
		File SrcFile = scrshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		File DestFile = new File(
				System.getProperty("user.dir") + "\\Screenshots\\ScreenshotImage" + date.getTime() + ".png");
		try {
			Files.copy(SrcFile, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Screeshot taken");
		driver.close();
	}

}
