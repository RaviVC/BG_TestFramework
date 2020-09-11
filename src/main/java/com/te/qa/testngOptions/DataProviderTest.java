package com.te.qa.testngOptions;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

	@Test(dataProvider="test1")
	public void test(String n1, Integer n2 ) {
		System.out.println(n1+" "+n2);
	}
	
	@DataProvider(name="test1")
	public Object [][] getData(){
		return new Object[][]{
		{"Ravi", new Integer(25)},
		{"Ramya", new Integer(24)},
	};
 }
}
