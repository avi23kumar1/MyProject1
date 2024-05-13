package com.comcast.crm.generic.contacttest;


import java.io.File;
import java.io.IOException;
import java.time.Duration;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sampletestscreenshot {
	@Test
	public void test() throws Throwable
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		File dsc = new File("./screenshot/test.png");
		FileUtils.copyFile(src, dsc);
		
	}
	@Test
	public void test2() throws Throwable
	{WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("http://localhost:8888");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	TakesScreenshot scrt= (TakesScreenshot)driver;
	File kss = scrt.getScreenshotAs(OutputType.FILE);
	File dsct = new File("./screenshot/test.png");
	FileHandler.copy(kss,dsct);
	
		
	}

}
