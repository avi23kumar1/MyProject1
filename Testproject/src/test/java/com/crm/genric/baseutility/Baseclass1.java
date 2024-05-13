package com.crm.genric.baseutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;



import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.com.cast.crm.generic.fileutlity.Execelutility;
import com.com.cast.crm.generic.fileutlity.Fileutility;
import com.com.cast.crm.generic.webdriverutlity.Datatest;

import com.comcast.crm.generic.databaseutlity.Webdriverutility;
import com.comcast.crm.opmutility.Home;
import com.comcast.crm.opmutility.Login;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Baseclass1 {
public	Datatest date=new Datatest();
public Fileutility file = new Fileutility();
public 	Webdriverutility wb=new Webdriverutility();
	public Execelutility ex=new Execelutility();
	
	public  WebDriver driver=null;
	public static WebDriver sdriver=null;
	public ExtentSparkReporter spark;
	public  ExtentReports report;
	
	@BeforeSuite
	public void configbs() throws Throwable
	{
	System.out.println("connect to db ,report config");	
	date.getDBConnection();
	ExtentSparkReporter spark=new ExtentSparkReporter("./Advancereport/report.html");
	spark.config().setDocumentTitle("crm test suite name");
	spark.config().setReportName("crm report");
	spark.config().setTheme(Theme.DARK);
	
 report=new ExtentReports();
report.attachReporter(spark);
report.setSystemInfo("os", "windows -10");
report.setSystemInfo("browser", "chrome");
	}
	
	@BeforeClass
	public void confiBC(/*String browser*/) throws Throwable
	{
		System.out.println("launch browser");
		String q1=file.getdatafromProprty("browser");
	
		if(q1.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(q1.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(q1.equals("edge"))
				{
			driver=new EdgeDriver();
				}
		else
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		sdriver=driver;
		
	}

	@BeforeMethod
	public void ctreateorgBM() throws Throwable 
	{
		System.out.println("login");
		String q2=file.getdatafromProprty("url");
      String q3=file.getdatafromProprty("password");
			String q4 = file.getdatafromProprty("username"); 
			Login lg=new Login(driver);
		lg.logintoapp(q2, q3, q4);;
		
		
	}

	

	@AfterMethod
	public void craeteorgAM()
	{
		System.out.println("logout");	
		Home hm=new Home(driver);
		hm.logout();
	}
	
	@AfterClass
	public void createorgAC()
	{
		System.out.println("close browser");
		driver.quit();
		
		
	}
	
	@AfterSuite
	public void configas() throws Throwable
	{
		System.out.println("cliose db,");
		date.closeConnection();
		report.flush();
	}

}
