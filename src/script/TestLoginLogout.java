package script;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.Reporter;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Utility;
import page.LoginPage;
import page.LogoutPage;


public class TestLoginLogout extends BaseTest {
	@Test(priority=1,groups= {"login","smoke"})
	public void testA() throws InterruptedException {
		String sheet = "TestLoginLogout";
		String data = Utility.getXLData(INPUT_PATH, sheet, 0, 0);
		Reporter.log("Data:"+data,true);
		
		int r = Utility.getXLRowCount(INPUT_PATH, sheet);
		Reporter.log("Row:"+r,true);
//		
//		String p = Utility.getPhoto(driver,PHOTO_PATH);
//		Reporter.log("Photo:"+p,true);
		//Assert.fail();
		
		LoginPage lp = new LoginPage(driver);
		String un = Utility.getXLData(INPUT_PATH, sheet, 1, 0);
		lp.setUsername(un);
		String pw = Utility.getXLData(INPUT_PATH, sheet, 1, 1);
		lp.setPassword(pw);
		lp.clickLoginBTN();
		
		LogoutPage op = new LogoutPage(driver);
		
		Thread.sleep(2000);
		op.clickLoginButton();
	}
	
}
