package com.comcast.crm.listenerutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retrylistenerimp implements IRetryAnalyzer {

	
	
	int count=0;
	int limicount=5;
	public boolean retry(ITestResult result) {
		if(count<limicount)
		{
			count++;
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	} 
	
	
	
	
	
	
	
}
