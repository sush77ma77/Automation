package generic;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

@Listeners(Result.class)
abstract public class BaseTest implements IAutoConst {
	public  WebDriver driver;//global variable should be public
	//if WebDriver is final :it can run only on one browser
	//static:selenium grid cant work
	
	//public String url = "http://localhost/login.do"; instead of hardcoding we store it in utilites
	//and store it in interface
	//getPropertyValue is a static method.we call with the help of class name
	//URL we are getting value from config.properties file
	public String url = Utility.getPropertyValue(CONFIG_PATH,"URL");
	String ITO = Utility.getPropertyValue(CONFIG_PATH,"ITO");
	
	
	//public long duration = 10;
	//it is prefered to take value from excel sheet
	//even without selenium enginner mannual test engineer should be able to run the frame work
	
	public long duration =Long.parseLong(ITO);//convert string to long
	
	static {
		System.setProperty(CHROME_KEY,CHROME_VALUE);//always final should be capital
		System.setProperty(GECKO_KEY,GECKO_VALUE);
	}
	@Parameters({"ip","browser"})
	@BeforeMethod(alwaysRun=true)
	public void openApplication(@Optional("localhost")String ip,@Optional("chrome")String browser) {
	
	 //to acheive grid we use following code
		//instead of this--> driver = new ChromeDriver();
		//instead of hardcoding value of ip and browser we get that values from testng.xml
		//this will change to --->driver=Utility.openBrowser(driver,"localhost", "chrome");
		driver = Utility.openBrowser(driver, ip, browser);
		driver.manage().timeouts().implicitlyWait(duration,TimeUnit.SECONDS);
		driver.get(url);//
	}
	
	//alwaysrun = true used for groping,what ever is the group it runs
	@AfterMethod(alwaysRun=true)
	public void closeApplication(ITestResult result) {
		String name  = result.getName();
		int status = result.getStatus();
		//to take screen shot if test is failed
		if(status == 2) {
		String path = Utility.getPhoto(driver, PHOTO_PATH);
		Reporter.log("Test:"+name+"is failed & Photo is:"+path,true);
		}
		else {
			Reporter.log("Test:"+name+"is Passed",true);
		}
		driver.quit();
	}

}
