package com.te.qa.testngOptions;

import org.testng.annotations.Test;

public class ParallelTest {
	
	@Test
	public void test1() {
		System.out.println(Thread.currentThread().getId());
		System.out.println("test1");
	}
	
	@Test
	public void test2() {
		System.out.println(Thread.currentThread().getId());
		System.out.println("test2");
	}
	
	

}
