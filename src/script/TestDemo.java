package script;

import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import page.LoginPage;

public class TestDemo extends BaseTest {
	@Test
	public void testA() {
		LoginPage lp = new LoginPage(driver);
		lp.setUsername("admin");
		lp.setPassword("admin123");
		lp.clickLoginBTN();
	}

}
