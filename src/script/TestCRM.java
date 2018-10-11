package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import page.LoginCrmPage;

public class TestCRM extends BaseTest {
	@Test
	public void testcrm() {
		LoginCrmPage lc = new LoginCrmPage(driver);
		lc.setCRMUsername("rashmi@dell.com");
		lc.setCRMPassword("123456");
		lc.clickCRMLoginBTN();
	}

}
