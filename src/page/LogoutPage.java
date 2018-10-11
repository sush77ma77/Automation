package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	//declaration
	@FindBy(id="logoutLink")
	private WebElement lgBTN;
	
	//intilization
	public LogoutPage(WebDriver driver) {
	
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public void clickLoginButton() throws InterruptedException {
		Thread.sleep(1000);
		lgBTN.click();
		
	}
	
	

}
