 package com.comcast.crm.opmutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Oranizationinfopage {
	WebDriver driver;
	public Oranizationinfopage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);
		
	}
	public WebElement getHeadmsg() {
		return headmsg;
	}


	@FindBy(className = "dvHeaderText")
	private WebElement headmsg;
} 
