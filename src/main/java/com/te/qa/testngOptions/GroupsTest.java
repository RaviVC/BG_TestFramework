package com.te.qa.testngOptions;

import org.testng.annotations.Test;

public class GroupsTest {
	
	@Test(groups = {"sanity"})
	public void test1() {
		System.out.println("Test1");
	}
	
	@Test(groups= {"sanity"})
	public void test2() {
		System.out.println("Test2");
	}
	
	@Test(groups= {"sanity"})
	public void test3() {
		System.out.println("Test3");
	}
	
	@Test(groups= {"regression"})
	public void test4() {
		System.out.println("Test4");
	}
	
	@Test(groups = {"regression"})
	public void test5() {
		System.out.println("Test5");
	}

}
