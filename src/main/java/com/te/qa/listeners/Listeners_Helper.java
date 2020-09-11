
  package com.te.qa.listeners;
  
  import org.testng.ITestContext; import org.testng.ITestListener; import
  org.testng.ITestResult;
  
  public class Listeners_Helper implements ITestListener{
  
		
		  public void onTestStart(ITestResult result) {
		  System.out.println(result.getName()+
		  "********** Test Execution Started **********"); System.out.println("\n"); }
		  
		  public void onTestSuccess(ITestResult result) {
		  System.out.println(result.getName()+ " ->> Test Passed ");
		  System.out.println("********** Test Execution Completed **********");
		  System.out.println(
		  "*****************************************************************************************************"
		  ); System.out.println("\n"); }
		  
		  public void onTestFailure(ITestResult result) {
		  System.out.println(result.getName()+ "**********Test Failed  **********");
		  System.out.println(
		  "*****************************************************************************************************"
		  );
		  
		  }
		  
		  public void onTestSkipped(ITestResult result) {
		  System.out.println(result.getName()+ "**********Test Skipped **********");
		  System.out.println(
		  "*****************************************************************************************************"
		  );
		  
		  }
		  
		  public void onTestFailedButWithinSuccessPercentage(ITestResult result) { //
		  
		  
		  }
		  
		  public void onStart(ITestContext context) { // TODO Auto-generated method
		  
		  
		  }
		  
		  public void onFinish(ITestContext context) {
		  System.out.println(context.getName()+"********** Execution Finished **********");
		  
		  }

  }
 