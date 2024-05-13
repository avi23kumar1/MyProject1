package com.comcast.crm.generic.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.com.cast.crm.generic.fileutlity.Execelutility;
import com.com.cast.crm.generic.fileutlity.Fileutility;
import com.comcast.crm.generic.databaseutlity.Javautility;

public class Datecreate {
	@Test
	public void test() throws Throwable
	{
		Fileutility fils=new Fileutility();
		Execelutility ex=new Execelutility();
		Javautility jv=new Javautility();
		
		
		
		 String q1 = fils.getdatafromProprty("browser");
		 String q2 = fils.getdatafromProprty("url");
		String q3=fils.getdatafromProprty("password");
		
		String q4 = fils.getdatafromProprty("username"); 
		
	
		String k10=ex.getdataexecel("Sheet1", 0, 1)+jv.getrandomnumber();
			 
			  
		WebDriver driver=null;
		if(q1.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(q1.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(q1.equals("edge"))
				{
			driver=new EdgeDriver();
				}
		else
		{
			driver=new ChromeDriver();
		}
		
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get(q2);
		 driver.findElement(By.name("user_name")).sendKeys(q4);
		 driver.findElement(By.name("user_password")).sendKeys(q3);
		 driver.findElement(By.id("submitButton")).click();
		 
		 driver.findElement(By.linkText("Contacts")).click();
		 driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		String start = jv.getsystemdateYYYYDDMM();
		String enddate = jv.getrequrieddateYYYYDDMM(30);
		 
		 
		 
		 driver.findElement(By.name("lastname")).sendKeys(k10);
		 driver.findElement(By.name("support_start_date")).clear();
		 driver.findElement(By.name("support_start_date")).sendKeys(start);
		 
		 
		 
		 driver.findElement(By.name("support_end_date")).clear();
		 driver.findElement(By.name("support_end_date")).sendKeys(enddate);
		 
		 driver.findElement(By.name("button")).click();
		 
		
		 String a1 = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		 if(a1.equals(start))
		 {
			 System.out.println("test is pass");
		 }
		 else 
		 {
			 System.out.println("test is fail");
		 }
		 String a2 = driver.findElement(By.id("dtlview_Support End Date")).getText();
		 if(a2.equals(enddate))
		 {
			 System.out.println("test is pass");
		 }
		 else 
		 {
			 System.out.println("test is fail");
		 }
		
		
		 driver.close();	
	}

}
