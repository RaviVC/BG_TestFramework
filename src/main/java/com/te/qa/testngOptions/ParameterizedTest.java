package com.te.qa.testngOptions;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizedTest {
	
	@Parameters({"browser"})
	@Test
	public void setupBrowser(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			System.out.println("Launch chrome browser");
		}else if(browser.equalsIgnoreCase("FF")){
			System.out.println("Launch FF Browser");
		}else if(browser.equalsIgnoreCase("IE")){
			System.out.println("Launch IE Browser");
		}
	}
}
