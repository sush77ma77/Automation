package script;

import org.testng.Assert;
import org.testng.Reporter;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Utility;
import page.LoginPage;


public class TestDemo extends BaseTest {
	@Test
	public void testA() {

		String data = Utility.getXLData(INPUT_PATH, "sheet1", 0, 0);
		Reporter.log("Data:"+data,true);
		
		int r = Utility.getXLRowCount(INPUT_PATH, "sheet1");
		Reporter.log("Row:"+r,true);
//		
//		String p = Utility.getPhoto(driver,PHOTO_PATH);
//		Reporter.log("Photo:"+p,true);
		//Assert.fail();
		
		LoginPage lp = new LoginPage(driver);
		String un = Utility.getXLData(INPUT_PATH, "sheet1", 1, 0);
		lp.setUsername(un);
		String pw = Utility.getXLData(INPUT_PATH, "sheet1", 1, 1);
		lp.setPassword(pw);
		lp.clickLoginBTN();
	}
	
}
