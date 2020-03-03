package com.testng.series;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestAssert {
	
	@Test
	public void test1(){
		Assert.assertEquals(1, 2);
		System.out.println("两个数字不相等");
	}
	
	@Test
	public void test2(){
		Assert.assertEquals(2, 2);
		System.out.println("两个数字相等");
	}
	
	@Test
	public void test3(){
		Assert.assertEquals("cheny", "cheny");
		System.out.println("两个数字相等");
	}
	
	@Test
	public void test4(){
		Assert.assertEquals("cheny", "chen");
		Reporter.log("这两个字符串不一样");
		System.out.println("这两个字符串不一样1");
	}

}
