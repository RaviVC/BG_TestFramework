package com.te.qa.testngOptions;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;


public class TestTimeOutTest {
	
	@Test(threadPoolSize = 3, invocationCount = 5,  timeOut = 10000)
	public void test1() {
		System.out.println("Test1");
	}
	
	@Test
	public void test2() {
		System.out.println("Test2");
	}
}
