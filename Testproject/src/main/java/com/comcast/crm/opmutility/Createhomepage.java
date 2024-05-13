package com.comcast.crm.opmutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Createhomepage {

	WebDriver driver;
	public Createhomepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
@FindBy(xpath="//img[@alt='Create Contact...']")	
private WebElement createcontactEdt;

public WebElement getCreatecontactEdt() {
	return createcontactEdt;
}



}