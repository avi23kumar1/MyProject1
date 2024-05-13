package com.cmr.createtest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.genric.baseutility.Baseclass;

public class Invoicetest {
@Test(retryAnalyzer = com.comcast.crm.listenerutility.Retrylistenerimp.class)
public void activetesim()
{
	System.out.println("print 23");
	Assert.assertEquals("", "king");
	System.out.println("print");
	System.out.println("print5");
	System.out.println("print63");
	System.out.println("print56");
}

}
