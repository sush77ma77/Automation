package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginCrmPage {
	//declaration
			@FindBy(id="userName")
			private WebElement unTB;
			
			@FindBy(name="j_password")
			private WebElement pwTB;
			
			@FindBy(xpath="//input[@title='Sign In']")
			private WebElement loginBTN;
			
			//intilization
			public LoginCrmPage(WebDriver driver) {
				//this.driver = driver;
				PageFactory.initElements(driver,this);
			}
			
			//utilization
			public void setCRMUsername(String un) {
				unTB.sendKeys(un);
			}
			
			public void setCRMPassword(String pw) {
				pwTB.sendKeys(pw);
			}
			
			public void clickCRMLoginBTN() {
				loginBTN.click();
			}



}
