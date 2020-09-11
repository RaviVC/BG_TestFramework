package com.te.qa.listeners;

import org.testng.Assert;
import org.testng.annotations.Test;
//import com.te.qa.listeners.RetryAnalyzer;

public class RetryAnalyzerDemo {
	
	@Test
	public void test1() {
		System.out.println("Inside Test1");
	}
	
	@Test
	public void test2() {
		System.out.println("Inside Test2");
	}
	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void test3() {
		System.out.println("Inside Test3");
		Assert.assertTrue(0>1);
	}

}
