package praticespakage;
/**
 * test class for contact module
 * @author avinash
 */

import org.testng.annotations.Test;

import com.comcast.crm.opmutility.Login;
import com.crm.genric.baseutility.Baseclass;

public class SearchContacttest extends Baseclass {
	/**
	 * scenario: login()==>navigatecontct==> createcontact()==> verify
	 */
	
	
	
	@Test
	public void searchcontacttest()
	{/* step 1: login to app */
		Login lp =new Login(driver);
		lp.logintoapp("url", "username", "password");
	}

}
