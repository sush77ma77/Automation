package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//for orangehrm
	
	//declaration
	@FindBy(id="txtUsername")
	private WebElement unTB;
	
	@FindBy(name="txtPassword")
	private WebElement pwTB;
	
	@FindBy(id="btnLogin")
	private WebElement loginBTN;
	
	//intilization
	public LoginPage(WebDriver driver) {
		//this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	//utilization
	public void setUsername(String un) {
		unTB.sendKeys(un);
	}
	
	public void setPassword(String pw) {
		pwTB.sendKeys(pw);
	}
	
	public void clickLoginBTN() {
		loginBTN.click();
	}

}
