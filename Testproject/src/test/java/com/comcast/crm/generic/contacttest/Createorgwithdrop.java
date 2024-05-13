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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.com.cast.crm.generic.fileutlity.Execelutility;
import com.com.cast.crm.generic.fileutlity.Fileutility;
import com.comcast.crm.generic.databaseutlity.Javautility;
import com.comcast.crm.generic.databaseutlity.Webdriverutility;
import com.comcast.crm.opmutility.CreatingNewOranization;
import com.comcast.crm.opmutility.Home;
import com.comcast.crm.opmutility.Login;
import com.comcast.crm.opmutility.Oranizationinfopage;
import com.comcast.crm.opmutility.Organization;
import com.crm.genric.baseutility.Baseclass;

import io.github.bonigarcia.wdm.WebDriverManager;

@Test(groups = "smoketest")
public class Createorgwithdrop extends Baseclass {
	public void test2() throws Throwable {
		String k10 = ex.getdataexecel("Sheet1", 0, 1) + jv.getrandomnumber();
		Home hm = new Home(driver);
		Organization org = new Organization(driver);
		hm.getOrglink().click();
		org.getCreateneworg().click();
		CreatingNewOranization cnop = new CreatingNewOranization(driver);
		cnop.createorg(k10);

		Thread.sleep(5000);
		Oranizationinfopage info = new Oranizationinfopage(driver);

		String k25 = info.getHeadmsg().getText();

		if (k25.contains(k10)) {
			System.out.println("test is pass");
		} else {
			System.out.println("test is fail");
		}

	}
	@Test(groups = "regressiontest")
  public void createcontactsupportdatetest() throws Throwable
	{String k12 = ex.getdataexecel("Sheet1", 1, 3);
	String k10 = ex.getdataexecel("Sheet1", 0, 1) + jv.getrandomnumber();
	Home hm = new Home(driver);
	Organization org = new Organization(driver);
	hm.getOrglink().click();
	org.getCreateneworg().click();
	CreatingNewOranization cnop = new CreatingNewOranization(driver);
	cnop.createorg(k10);

	Thread.sleep(5000);
	Oranizationinfopage info = new Oranizationinfopage(driver);

	String k25 = info.getHeadmsg().getText();

	if (k25.contains(k10)) {
		System.out.println("test is pass");
	} else {
		System.out.println("test is fail");
	}
	
	 
	 

	
	

	
	}
	@Test(groups = "regressiontest")
	public void createcontactwithorggdatetest() throws Throwable
	{
		String k10 = ex.getdataexecel("Sheet1", 0, 1) + jv.getrandomnumber();
		Home hm = new Home(driver);
		Organization org = new Organization(driver);
		hm.getOrglink().click();
		org.getCreateneworg().click();
		CreatingNewOranization cnop = new CreatingNewOranization(driver);
		cnop.createorg(k10, "Construction");
		

		Thread.sleep(5000);
		Oranizationinfopage info = new Oranizationinfopage(driver);

		String k25 = info.getHeadmsg().getText();

		if (k25.contains(k10)) {
			System.out.println("test is pass");
		} else {
			System.out.println("test is fail");
		}

	}

}
