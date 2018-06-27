package testSuites;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import genericActionsLibrary.ExcelFile;
import genericActionsLibrary.Screenshot;
import pageActionsLibrary.LoginPageActions;
import testBaseLibrary.TestBase;

public class LoginPageSuite extends TestBase {
	
	public static final Logger log = Logger.getLogger(LoginPageSuite.class.getName());
	LoginPageActions loginPageActions;
	ExcelFile excelFile = new ExcelFile();
	
	@BeforeMethod
	public void beforeTest()
	{
		log.info("Intializing the Test");
		intialize("chrome","http://opensource.demo.orangehrmlive.com/");
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VD57\\Downloads\\SeleniumDrivers\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.get("http://opensource.demo.orangehrmlive.com/");
	}
	@Test
	public void verifyLoginWithInvalidCredentials()
	{	
		loginPageActions = new LoginPageActions(driver);
		
		String un = excelFile.readExcelData(0, 1, 0);
		String pswd = excelFile.readExcelData(0, 1, 1);
		loginPageActions.enterUserName(un);
		log.info("Entered the username: "+un);
		loginPageActions.enterPassword(pswd);
		log.info("Entered the password: "+pswd);
		log.info("clicked on Login Button");
		loginPageActions.clickLoginButton();
		Screenshot.captureScreenshot(driver, "invalidLogin");
//		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
//		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
//		driver.findElement(By.id("btnLogin")).click();
		String expMessage = "Invalid credentials";
		String actMessage = loginPageActions.getInvalidLoginMessage();
		System.out.println("Invalid Login Error Message is: "+actMessage);
		Assert.assertEquals(actMessage, expMessage);
	}
	
	@Test
	public void verifyLoginWithValidCredentials()
	{	
		loginPageActions = new LoginPageActions(driver);
		String un = excelFile.readExcelData(0, 2, 0);
		String pswd = excelFile.readExcelData(0, 2, 1);
		loginPageActions.enterUserName(un);
		log.info("Entered the username: "+un);
		loginPageActions.enterPassword(pswd);
		log.info("Entered the password: "+pswd);
		log.info("clicked on Login Button");
		loginPageActions.clickLoginButton();
		Screenshot.captureScreenshot(driver, "HomePage");
//		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
//		driver.findElement(By.id("txtPassword")).sendKeys("admin");
//		driver.findElement(By.id("btnLogin")).click();
		String expTitle = "OrangeHRM";
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, expTitle);
	}
	
	@AfterMethod
	public void afterTest()
	{
		driver.close();
	}

}
