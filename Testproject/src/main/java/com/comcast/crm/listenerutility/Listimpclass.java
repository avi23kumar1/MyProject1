package com.comcast.crm.listenerutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.com.cast.crm.generic.webdriverutlity.Utilityclassobject;
import com.crm.genric.baseutility.Baseclass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Listimpclass  implements ITestListener,ISuiteListener{
public ExtentSparkReporter spark;
public   ExtentReports report;
public static ExtentTest test;
	
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("report confiquration");
		String   time = new Date().toString().replace("", "_").replace(":", "_");
		ExtentSparkReporter spark=new ExtentSparkReporter("./Advancereport/report_"+time+".html");
		spark.config().setDocumentTitle("crm test suite name");
		spark.config().setReportName("crm report");
		spark.config().setTheme(Theme.DARK);
		
	 report=new ExtentReports();
	report.attachReporter(spark);
	report.setSystemInfo("os", "windows -10");
	report.setSystemInfo("browser", "chrome");
	}

	
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("report backyup");
		report.flush();
	}

	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("========="+result.getMethod().getMethodName()+"?=====");
	 test = report.createTest(result.getMethod().getMethodName()); 
	 Utilityclassobject.settest(test);
	 test.log(Status.INFO,result.getMethod().getMethodName()+" ==> started<==");
	}

	
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("========="+result.getMethod().getMethodName()+"?=====");
		 test.log(Status.PASS,result.getMethod().getMethodName()+" ==> completed<==");
	}


	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String testname = result.getMethod().getMethodName(); 
		TakesScreenshot edriver=(TakesScreenshot)Baseclass.sdriver;
		 String file = edriver.getScreenshotAs(OutputType.BASE64);
		String   time = new Date().toString().replace("", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(file, testname+" "+time);
		 test.log(Status.FAIL,result.getMethod().getMethodName()+" ==> falied<==");

	
	}

	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
			
		
		
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	

}
