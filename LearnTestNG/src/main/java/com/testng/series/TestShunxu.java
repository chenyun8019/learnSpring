package com.testng.series;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestShunxu {
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("我是beforeTest");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("我是afterTest");
	}	
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("我是beforeMethod");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("我是afterMethod");
	}	
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("我是beforeClass");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("我是afterClass");
	}	
	
	@Test
	public void test1() {
		System.out.println("我是测试用例001");
	}
  
	@Test
	public void test2() {
		System.out.println("我是测试用例002");
	}
}
