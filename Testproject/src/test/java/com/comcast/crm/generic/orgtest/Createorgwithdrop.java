package com.comcast.crm.generic.orgtest;

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Createorgwithdrop {
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
		Row m2 = k3.getRow(1);
			 
			 String k10 = k4.getCell(1).toString()+k2;
			String m3 = m2.getCell(1).toString();
			 String m4 = m2.getCell(2).toString();
			 wb.close();
			 
			  
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
		WebElement wes = driver.findElement(By.name("industry"));
		 Select sell=new Select(wes);
		 sell.selectByVisibleText("Energy");
		 WebElement wes1 = driver.findElement(By.name("accounttype"));
		 Select sell1=new Select(wes1);
		 sell1.selectByVisibleText("Press");
		 
		 
		 driver.findElement(By.name("button")).click();
		 
	
		 String a1 = driver.findElement(By.id("dtlview_Industry")).getText();
		 if(a1.equals(m3))
		 {
			 System.out.println("test is pass");
		 }
		 else 
		 {
			 System.out.println("test is fail");
		 }
		

		 String a2 = driver.findElement(By.id("dtlview_Type")).getText();
		 if(a2.equals(m4))
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
