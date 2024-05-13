package com.comcast.crm.opmutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organization {
	
	WebDriver driver;
	public Organization(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);
		
	}
	
	
	@FindBy(name = "search_text")
	private WebElement serachid;
	@FindBy(name = "search_field")
	private WebElement serachDD;
	@FindBy(name = "submit")
	private WebElement searchbtn;
	
	
	
	public WebElement getSearchbtn() {
		return searchbtn;
	}
	public WebElement getSerachid() {
		return serachid;
	}
	public WebElement getSerachDD() {
		return serachDD;
	}
	
@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
private WebElement createneworg;



public WebElement getCreateneworg() {
	return createneworg;
}
}    
