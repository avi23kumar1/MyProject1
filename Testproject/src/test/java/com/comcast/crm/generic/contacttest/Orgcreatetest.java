package com.comcast.crm.generic.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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
import com.comcast.crm.generic.databaseutlity.Webdriverutility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Orgcreatetest {
	@Test
	public void test() throws Throwable
	{
		
		
		Fileutility fils=new Fileutility();
		Execelutility ex=new Execelutility();
		Javautility jv=new Javautility();
		Webdriverutility wlib=new Webdriverutility();
		
		
		 String q1 = fils.getdatafromProprty("browser");
		 String q2 = fils.getdatafromProprty("url");
		String q3=fils.getdatafromProprty("password");
		
		String q4 = fils.getdatafromProprty("username"); 
		
	
		String k10=ex.getdataexecel("Sheet1", 0, 1)+jv.getrandomnumber();
		String k11=ex.getdataexecel("Sheet1", 1, 1)+jv.getrandomnumber();
		
		WebDriver driver=null;
		if(q1.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
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
			WebDriverManager.chromedriver().setup();
		}
		
		
		
		wlib.waitforpageload(driver);
		
		driver.get(q2);
		 driver.findElement(By.name("user_name")).sendKeys(q4);
		 driver.findElement(By.name("user_password")).sendKeys(q3);
		 driver.findElement(By.id("submitButton")).click();
		 Thread.sleep(2000);
		 
		 driver.findElement(By.linkText("Organizations")).click();
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		 Thread.sleep(5000);
		 driver.findElement(By.name("accountname")).sendKeys(k10);
		 driver.findElement(By.name("button")).click();
		 
		 
		 Thread.sleep(2000);
		 driver.findElement(By.linkText("Contacts")).click();
		 driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		 driver.findElement(By.name("lastname")).sendKeys(k11);
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		 Thread.sleep(5000);
		 
		 wlib.switchtotabonurl(driver,"module=Accounts");
		 
		  driver.findElement(By.id("search_txt")).sendKeys(k10);
		 driver.findElement(By.name("search")).click();
		 driver.findElement(By.xpath("//a[text()='"+k10+"']")).click();
		 Thread.sleep(5000);
		
		 wlib.switchtotabonurl(driver, "Contacts&action");
		 
		 
		 
		
		  
		 driver.findElement(By.name("button")).click();
		 
		 String l2 = driver.findElement(By.id("dtlview_Last Name")).getText();
			
			
			
			if(l2.contains(k11))
			{
				System.out.println("test is pass");
			}
			else
			{
				System.out.println("test is fail");
			}
			 String a1 = driver.findElement(By.id("mouseArea_Organization Name")).getText();
			 if(a1.contains(k10))
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
