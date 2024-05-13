package com.cmr.assert1.test;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Sampletest1 {
	@Test
	public void test1(Method mtd)
	{
	System.out.println(mtd.getName()+"test start");
	SoftAssert asse=new SoftAssert();
	System.out.println("tset1");
	
	asse.assertEquals("Home", "Home");
	System.out.println("tset2");
	Assert.assertEquals("Home", "Home2");
	System.out.println("tset4");
	asse.assertAll();
	System.out.println(mtd.getName()+"test end");
	
	}
	@Test
	public void test2(Method mtd)
	{
		System.out.println(mtd.getName()+"test start");
		SoftAssert asse=new SoftAssert();
		System.out.println("test1");
		System.out.println("test2");
		
		System.out.println("test3");
	asse.assertTrue(true);
		System.out.println("test4");
		System.out.println(mtd.getName()+"test end");
	}

}
