package com.testng.series;

import org.testng.annotations.Test;

public class TestIgonre {

	@Test(enabled=true)
	public void test1() {
		System.out.println("我是测试用例001");
	}
	
	@Test(enabled=false)
	public void test2() {
		System.out.println("我是测试用例002");
	}
	
	@Test
	public void test3() {
		System.out.println("我是测试用例003");
	}
}
