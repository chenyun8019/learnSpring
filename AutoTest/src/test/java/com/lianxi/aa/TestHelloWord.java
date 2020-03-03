package com.lianxi.aa;

import org.testng.annotations.Test;

public class TestHelloWord {
	@Test
	public void testSay(){
		new HelloWord().say();
	}

}
