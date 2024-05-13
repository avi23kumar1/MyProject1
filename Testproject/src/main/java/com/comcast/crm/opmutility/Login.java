package com.comcast.crm.opmutility;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.databaseutlity.Webdriverutility;
/**
 * @author avinash
 * contains login page elements business lib like login
 */

public class Login   extends Webdriverutility{
	WebDriver driver;
	public Login (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);
		
	}
	@FindBy(name="user_name")
	public WebElement useredit;
	
	@FindBy (name="user_password")
	public WebElement passwordedit;
	@FindBy(id="submitButton")
	public WebElement loginedit;
	public WebElement getUseredit() {
		return useredit;
	}
	public WebElement getPasswordedit() {
		return passwordedit;
	}
	public WebElement getLoginedit() {
		return loginedit;
	}
	/**
	 * login to application based username, password, url arguments
	 * @param url
	 * @param username
	 * @param password
	 */
	
	public void logintoapp( String url,String username, String password)
	{
		waitforpageload(driver);
		driver.get(url);
		driver.manage().window().maximize();	
		useredit.sendKeys("admin");
		passwordedit.sendKeys("admin");
		loginedit.click();
	}
	

} 
