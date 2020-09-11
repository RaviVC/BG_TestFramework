package com.te.qa.seleniumAPI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import com.te.qa.resources.Resource_Helper;

public class SSLCertificate_Helper {
	
	static WebDriver driver = null;
	
	public static void main(String[] args) {	
		handleSSLCertificate();
	}
	
	public static void handleSSLCertificate() {
		
		System.setProperty("webdriver.chrome.driver", Resource_Helper.getResourcePath("\\Drivers\\chromedriver.exe"));
		ChromeOptions options = new ChromeOptions();
		
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		driver = new ChromeDriver(options);
		driver.get("https://cacert.org/");
	}

}
