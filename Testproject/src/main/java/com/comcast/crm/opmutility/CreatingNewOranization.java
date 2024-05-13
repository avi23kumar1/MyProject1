package com.comcast.crm.opmutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOranization {
	WebDriver driver;
	public CreatingNewOranization(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);	
	}
	@FindBy(name = "accountname")
	private WebElement orgname;
	@FindBy(name ="button")
	private WebElement savebutton;
	@FindBy(name="industry")
	private WebElement industryid;
	@FindBy(name = "phone")
	private WebElement phoneedit;
	
	
	
	public WebElement getPhoneedit() {
		return phoneedit;
	}
	public WebElement getOrgname() {
		return orgname;
	
	}
	public WebElement getSavebutton() {
		return savebutton;
	}
	
	public void createorg(String orgnames)
	{
		orgname.sendKeys(orgnames);
		savebutton.click();
	}
	public void createorg(String orgnames ,String industry)
	{
		
		orgname.sendKeys(orgnames);
		Select sel=new Select(industryid);
		sel.selectByVisibleText(industry);
		savebutton.click();
	}	
	


}
