package com.comcast.crm.generic.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
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
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.com.cast.crm.generic.fileutlity.Execelutility;
import com.com.cast.crm.generic.fileutlity.Fileutility;
import com.comcast.crm.generic.databaseutlity.Javautility;
import com.comcast.crm.generic.databaseutlity.Webdriverutility;
import com.comcast.crm.opmutility.Login;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Craeatetest4 {
	@Test
public void tset1() throws Throwable
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
		
	
		wlib.waitforpageload(driver);
		
		driver.get(q2);
		Login ip = new Login(driver);
		ip.logintoapp("url","admin", "admin");
		 driver.findElement(By.linkText("Organizations")).click();
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		 Thread.sleep(5000);
		 driver.findElement(By.name("accountname")).sendKeys(k10);
		 driver.findElement(By.name("button")).click();
		 
		
		 String a1 = driver.findElement(By.id("dtlview_Last Name")).getText();
		 if(a1.equals(k10))
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
