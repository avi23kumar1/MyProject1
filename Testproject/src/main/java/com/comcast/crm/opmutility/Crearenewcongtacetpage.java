 package com.comcast.crm.opmutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Crearenewcongtacetpage {
	WebDriver driver;
	public  Crearenewcongtacetpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="lastname")	
	private WebElement lastnamEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveEdt;	
	
	@FindBy(name = "support_start_date")
	private WebElement supportDateEdt;
	
	@FindBy(name = "support_end_date")
	private WebElement supportEnddatEdt;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img\"")
	private WebElement orgNameEdt;
	
	@FindBy(id="search_txt")
	private WebElement OrgnameSearchEdt;
	
	@FindBy(name="search")
	private WebElement OrgnamesearchBtn;
	
	@FindBy(xpath="//a[text()='\" +orgname+ \"']\"")
	private WebElement OrgnameResEdt;
	@FindBy(className = "dvHeaderText")
	private WebElement headtest1;
	@FindBy(id = "dtlview_Last Name")
	private WebElement lastedit1;
	
	
	


	public WebElement getLastedit1() {
		return lastedit1;
	}



	public WebElement getHeadtest1() {
		return headtest1;
	}



	public WebElement getOrgnameSearchEdt() {
		return OrgnameSearchEdt;
	}



	public WebElement getOrgnameResEdt() {
		return OrgnameResEdt;
	}

	

	public WebElement getOrgnamesearchBtn() {
		return OrgnamesearchBtn;
	}


	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}


	public WebElement getSupportDateEdt() {
		return supportDateEdt;
	}


	public WebElement getSupportEnddatEdt() {
		return supportEnddatEdt;
	}


	public WebElement getSaveEdt() {
		return saveEdt;
	}


	public WebElement getLastnamEdt() {
		return lastnamEdt;
	}
	
	public void createcontac1(String lastname)
	{
		lastnamEdt.sendKeys(lastname);
		saveEdt.click();
		
	}

	}


