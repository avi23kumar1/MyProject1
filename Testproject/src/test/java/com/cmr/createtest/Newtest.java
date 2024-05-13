package com.cmr.createtest;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Newtest {
	@BeforeSuite
	public void configbs()
	{
	System.out.println("print1");	
	}
	@AfterSuite
	public void configas()
	{
		
	}
	@Test
	public void createorgtest()
	{
		
	}

}
