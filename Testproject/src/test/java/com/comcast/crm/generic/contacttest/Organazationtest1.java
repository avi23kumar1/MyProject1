package com.comcast.crm.generic.contacttest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

public class Organazationtest1 extends Baseclass {
	@Test
	public void test() throws Throwable {

		String k10 = ex.getdataexecel("Sheet1", 0, 1) + jv.getrandomnumber();
		Home hm = new Home(driver);
		Organization org = new Organization(driver);
		hm.getOrglink().click();
		org.getCreateneworg().click();
		CreatingNewOranization cnop = new CreatingNewOranization(driver);
		cnop.createorg(k10);
		Oranizationinfopage info = new Oranizationinfopage(driver);

		String k25 = info.getHeadmsg().getText();

		if (k25.contains(k10)) {
			System.out.println("test is pass");
		} else {
			System.out.println("test is fail");
		}

		hm.getOrglink().click();

		org.getSerachid().sendKeys(k10);
		wb.select(org.getSerachDD(), "Organization Name");
		org.getSearchbtn().click();

		hm.logout();
	}

}
