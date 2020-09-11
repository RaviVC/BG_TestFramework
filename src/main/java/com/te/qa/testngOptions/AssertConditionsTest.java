package com.te.qa.testngOptions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertConditionsTest {
	
//	assertEqual(String actual,String expected)
//	assertEqual(String actual,String expected, String message)
//	assertEquals(boolean actual,boolean expected)
//	assertTrue(condition)
//	assertTrue(condition, message)
//	assertFalse(condition)
//	assertFalse(condition, message)

	
	@Test
	public void test1() {
		int age = 18;
		Assert.assertEquals(18, age, "Eligible to vote");
	}

	@Test
	public void test2() {
		int age = 22;
		if(age>18) {
			Assert.assertTrue(true);
			System.out.println("Eligible to vote");
		}else {
			Assert.assertFalse(false);
		}
		
	}

}
