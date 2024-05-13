package com.comcast.crm.generic.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.opmutility.Crearenewcongtacetpage;
import com.comcast.crm.opmutility.Createhomepage;
import com.comcast.crm.opmutility.Home;
import com.comcast.crm.opmutility.Login;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Neworgtest1 {
@Test
public void test35() throws EncryptedDocumentException, IOException
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
		driver=new ChromeDriver();
	}
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	Login op=new Login(driver);
	op.logintoapp(q2, q4, q3);
	Home hm = new Home(driver);
	hm.getContactlink().click();
	Createhomepage hms=new Createhomepage(driver);
	hms.getCreatecontactEdt().click();
	Crearenewcongtacetpage kms=new Crearenewcongtacetpage(driver);
	kms.createcontac1(k10);
	String lm = kms.getHeadtest1().getText();
	System.out.println(lm);
	boolean check = lm.contains(k10);
	Assert.assertEquals(check, true);
	String l3 = kms.getLastedit1().getText();
	boolean check1 = l3.contains(k10);
	SoftAssert soft =new SoftAssert();
	soft.assertEquals(check1, true);
	soft.assertAll();
	
	
}

}
