package com.testng.series;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest {
  @Test
  public void test1() {
	  System.out.println("这是一个测试用例");
  }
  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("在测试套件前运行");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("在测试套件后运行");
  }

}
