package com.testng.series;

import org.testng.annotations.Test;

public class TestGroup {
	@Test(groups="Cat")
	public void test1(){
		System.out.println("我是Cat001");
	}
	@Test(groups="Cat")
	public void test2(){
		System.out.println("我是Cat002");
	}
	@Test(groups="Dog")
	public void test3(){
		System.out.println("我是Dog001");
	}
	@Test(groups="Dog")
	public void test4(){
		System.out.println("我是Dog002");
	}

}
