package com.comcast.crm.generic.orgtest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.com.cast.crm.generic.webdriverutlity.Utilityclassobject;
import com.comcast.crm.opmutility.Crearenewcongtacetpage;
import com.comcast.crm.opmutility.Createhomepage;
import com.comcast.crm.opmutility.Home;
import com.comcast.crm.opmutility.Organization;
import com.crm.genric.baseutility.Baseclass;

/**
 * @author avinash
 */
@Listeners(com.comcast.crm.listenerutility.Listimpclass.class)
public class CONTACTCLASS1 extends Baseclass {
	@Test
	public void contacttest1() throws Throwable {
		Utilityclassobject.gettest().log(Status.INFO, "read data from the excel");
		/* step1: read the data from the excel file */
		String k11 = ex.getdataexecel("Sheet1", 0, 1) + jv.getrandomnumber();
		Utilityclassobject.gettest().log(Status.INFO, "navigate to con page");
		/* step:2 navigate to contact module */
		Home hm = new Home(driver);
		hm.getContactlink().click();
		Utilityclassobject.gettest().log(Status.INFO, "navigate to create contacts");
		/* step3: click on "create contact"button */
		Createhomepage j1 = new Createhomepage(driver);
		j1.getCreatecontactEdt().click();
		Utilityclassobject.gettest().log(Status.INFO, "create new contacts");
		/* step4: enter all the details and create new contact */
		Crearenewcongtacetpage nw = new Crearenewcongtacetpage(driver);
		nw.createcontac1(k11);
		String lm = nw.getHeadtest1().getText();
		/* verify the LastNmae into expected result */
		boolean check = lm.contains(k11);
		Assert.assertEquals(check, true);
		String l3 = nw.getLastedit1().getText();
		boolean check1 = l3.contains(k11);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(check1, true);
		soft.assertAll();
	}

	@Test
	public void contacttest() throws Throwable {
		Utilityclassobject.gettest().log(Status.INFO, "read data from the excel");
		String k11 = ex.getdataexecel("Sheet1", 0, 1) + jv.getrandomnumber();
		Utilityclassobject.gettest().log(Status.INFO, "navigate to con page");
		Home hm = new Home(driver);
		Organization org = new Organization(driver);
		hm.getContactlink().click();
		Utilityclassobject.gettest().log(Status.INFO, "navigate to create contacts");
		org.getCreateneworg().click();
		Utilityclassobject.gettest().log(Status.INFO, "create new contacts");
		Crearenewcongtacetpage nw = new Crearenewcongtacetpage(driver);
		nw.createcontac1(k11);
		String lm = nw.getHeadtest1().getText();
		;
		boolean check = lm.contains(k11);
		Assert.assertEquals(check, true);

	}

	@Test
	public void contacttest2() throws Throwable {
		String k11 = ex.getdataexecel("Sheet1", 0, 1) + jv.getrandomnumber();
		Home hm = new Home(driver);
		Organization org = new Organization(driver);
 		hm.getContactlink().click();
		org.getCreateneworg().click();
		Crearenewcongtacetpage nw = new Crearenewcongtacetpage(driver);
		nw.createcontac1(k11);
		String lm = nw.getHeadtest1().getText();
		;
		boolean check = lm.contains(k11);
		Assert.assertEquals(check, true);

	}

}
