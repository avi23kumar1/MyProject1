package com.comcast.crm.generic.databaseutlity;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webdriverutility {
	public void waitforpageload(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void waitforelementpresent(WebDriver driver , WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void switchtotabonurl(WebDriver driver,String partailurl)
	{
		 Set<String> s = driver.getWindowHandles();
		    Iterator<String> it = s.iterator();
		    while(it.hasNext())
		    {
		    	String windowid = it.next();
		    	driver.switchTo().window(windowid);
		    	String wurl = driver.getCurrentUrl();
		    	if(wurl.contains(partailurl))
		    	{
		    		break;
		    	}
		    	
		    }
	}
	public void switchtotabotitle(WebDriver driver,String partailtitle)
	{
		 Set<String> s = driver.getWindowHandles();
		    Iterator<String> it = s.iterator();
		    while(it.hasNext())
		    {
		    	String windowid = it.next();
		    	driver.switchTo().window(windowid);
		    	String wurl = driver.getTitle();
		    	if(wurl.contains(partailtitle))
		    	{
		    		break;
		    	}
		    	
		    }
	}
	
	public void swtichtoframe(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	public void swtichtoframe(WebDriver driver,String nameid)
	{
		driver.switchTo().frame(nameid);
	}
	public void swtichtoframe(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	public void swtichtoalertandaccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void swtichtoalertandcancel(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public void select(WebElement element ,String text)
	{
		Select sel=new Select(element );
		sel.selectByVisibleText(text);
	}
	public void select(WebElement element ,int index)
	{
		Select sel=new Select(element );
		sel.selectByIndex(index);
	}
	public void mousemoveonelement(WebDriver driver ,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	public void doubleclick(WebDriver driver ,WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	public void draganddrop(WebDriver driver,WebElement element1,WebElement element2)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(element1, element2).perform();
	}
	public void screenshotpage(WebDriver driver) throws Throwable
	{
		WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		File dsc = new File("./screenshot/test.png");
		FileUtils.copyFile(src, dsc);
	}
	
	
	
}
