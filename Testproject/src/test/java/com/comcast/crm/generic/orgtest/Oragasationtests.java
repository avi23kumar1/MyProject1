package com.comcast.crm.generic.orgtest;

import java.io.FileInputStream;
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
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Oragasationtests {
	@Test
	public void test2() throws Throwable
	{
		FileInputStream fis=new FileInputStream("./configappdata/commondatass.properties");
		Properties pobj= new Properties();
		pobj.load(fis);
		 String q1 = pobj.getProperty("browser");
		 String q2 = pobj.getProperty("url");
		String q3=pobj.getProperty("password");
		
		String q4 = pobj.getProperty("username"); 
		Random rm=new Random();
		int k2 = rm.nextInt(1000);
	FileInputStream fys=new FileInputStream("./testdata/Book2.xlsx");
		
		Workbook wb = WorkbookFactory.create(fys);
		Sheet k3 = wb.getSheet("Sheet1");
	
		Row k4 = k3.getRow(0);
			 
			 String k10 = k4.getCell(1).toString()+k2;
			  
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
		 
		 driver.findElement(By.linkText("Organizations")).click();
		 driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		 driver.findElement(By.name("accountname")).sendKeys(k10);
		 driver.findElement(By.name("button")).click();
		 
		 
		 
		 
		String l2 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		
		
		if(l2.contains(k10))
		{
			System.out.println("test is pass");
		}
		else
		{
			System.out.println("test is fail");
		}
		 String a1 = driver.findElement(By.id("dtlview_Organization Name")).getText();
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
