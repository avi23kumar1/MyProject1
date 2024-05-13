package com.cmr.assert1.test;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.com.cast.crm.generic.fileutlity.Fileutility;
import com.comcast.crm.generic.databaseutlity.Webdriverutility;
import com.comcast.crm.opmutility.Login;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Newtestassset {
@Test
public void test2(Method mtd) throws Throwable
{
	System.out.println(mtd.getName()+"test start");
	String klm="Home";
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("http://localhost:8888/index.php");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	String title = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
	Assert.assertEquals(title, klm);
	driver.close();
	System.out.println(mtd.getName()+"test end");
}
@Test
public void test3(Method mtd)
{System.out.println(mtd.getName()+"test start");
	String klm="Home page";
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get("http://localhost:8888/index.php");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
driver.findElement(By.name("user_name")).sendKeys("admin");
driver.findElement(By.name("user_password")).sendKeys("admin");
driver.findElement(By.id("submitButton")).click();

boolean k1 = driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
Assert.assertEquals(true, k1);	
System.out.println(mtd.getName()+"test end");
}
@Test
public void test4(Method mtd)
{System.out.println(mtd.getName()+"test start");
	String klm="Home page";
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get("http://localhost:8888/index.php");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
driver.findElement(By.name("user_name")).sendKeys("admin");
driver.findElement(By.name("user_password")).sendKeys("admin");
driver.findElement(By.id("submitButton")).click();

boolean k1 = driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
Assert.assertTrue(k1);	
System.out.println(mtd.getName()+"test end");

}
}
