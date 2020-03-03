package com.testng.series;

import org.testng.annotations.Test;

public class TestdependsOn {
	
	@Test
	public void toLogin(){
		System.out.println("去登录");
	}
	
	@Test(dependsOnMethods="toOrder")
	public void toPay(){
		System.out.println("去支付");
	}
	
	@Test(dependsOnMethods="toLogin")
	public void toOrder(){
		System.out.println("去下单");
	}

}
