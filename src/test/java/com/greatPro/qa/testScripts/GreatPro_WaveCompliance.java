package com.greatPro.qa.testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.te.qa.testBase.BaseTest;
import com.te.qa.testBase.BaseTest_GreatPro;

public class GreatPro_WaveCompliance extends BaseTest_GreatPro{
	
	@Test
	public void checkCompliance_HomePage() throws IOException {
		
		test = extent.createTest("CheckCompliance_HomePage"); 
		test.log(Status.PASS,"CheckCompliance_HomePage Successfully");
		launchApp("GreatPro_URL", "prod");
		Runtime.getRuntime().exec("C:\\Development\\ADA\\Wave\\WaveTestScript1.exe");
		threadSleepWait(5000);		
	}
}
