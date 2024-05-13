package com.comcast.crm.opmutility;






import java.security.KeyStore.PrivateKeyEntry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
WebDriver driver;
public Home(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements( driver,this);
	
}
@FindBy(linkText="Organizations")
private WebElement orglink;
@FindBy(linkText="Contacts")
private WebElement contactlink;
@FindBy(linkText="Campaigns")
private WebElement campaiglink;
@FindBy(linkText="More")
private WebElement morelink;

@FindBy(xpath ="//img[@src='themes/softed/images/user.PNG']")
private WebElement adminimg;
@FindBy(xpath ="//a[@href='index.php?module=Users&action=Logout']")
private WebElement logout1;


public WebElement getAdminimg() {
	return adminimg;
}


public WebElement getLogout1() {
	return logout1;
}


public WebElement getOrglink() {
	return orglink;
}


public WebElement getContactlink() {
	return contactlink;
}


public WebElement getCampaiglink() {
	return campaiglink;
}


public WebElement getMorelink() {
	return morelink;
}


public void navigatetocampaigipage()
{
	Actions act=new Actions(driver);
	act.moveToElement(campaiglink).perform();
	campaiglink.click();
}
public void logout()
{
	 Actions act=new Actions(driver);
	 act.moveToElement(adminimg).perform();
	 logout1.click();
}
	

}
