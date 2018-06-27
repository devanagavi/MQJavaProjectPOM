package pageObjectLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(id="txtUsername")
	public WebElement txtUserName;
	
	@FindBy(id="txtPassword")
	public WebElement txtPassword;
	
	@FindBy(id="btnLogin")
	public WebElement btnLoginButton;
	
	@FindBy(id="spanMessage")
	public WebElement invlaidLoginMessage;
	
//	@FindBy("a[text()='Gmail']")
//	public WebElement anchorTxt;
//	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
