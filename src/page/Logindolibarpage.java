package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logindolibarpage {
	//declaration
		@FindBy(id="username")
		private WebElement unTB;
		
		@FindBy(name="password")
		private WebElement pwTB;
		
		@FindBy(xpath="//input[@type='submit']")
		private WebElement loginBTN;
		
		//intilization
		public Logindolibarpage(WebDriver driver) {
			//this.driver = driver;
			PageFactory.initElements(driver,this);
		}
		
		//utilization
		public void setDolUsername(String un) {
			unTB.sendKeys(un);
		}
		
		public void setDolPassword(String pw) {
			pwTB.sendKeys(pw);
		}
		
		public void clickDolLoginBTN() {
			loginBTN.click();
		}


}
