package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import page.Logindolibarpage;

public class TestDolibar extends BaseTest {
	@Test
	public void testDol() {
		Logindolibarpage dl = new Logindolibarpage(driver);
		dl.setDolUsername("admin");
		dl.setDolPassword("admin");
		dl.clickDolLoginBTN();
	}
	

}
