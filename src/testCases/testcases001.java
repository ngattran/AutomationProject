package testCases;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import pageObjects.Home_Page;
import appModule.SignIn_Action;
import Utilities.Constants;
import Utilities.ExcelUtils;
import Utilities.Log;
 
public class testcases001 
{
	public WebDriver driver;
	@BeforeMethod
	public void beforeMethod() throws Exception 
	{
	  	DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Selenium_Test_001");
		ExcelUtils.setExcelFile(Constants.Path_TestData + Constants.File_TestData,"Sheet1");
 		Log.info(" Excel sheet opened");
 		driver = new FirefoxDriver();
 		Log.info("New driver instantiated");
 		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 		Log.info("Implicit wait applied on the driver for 10 seconds");
 		driver.get(Constants.URL);
	}
 
	@Test
	public void Test() throws Exception 
	{
 	    SignIn_Action.Login(driver);
 		System.out.println("Login Successfully, now it is the time to Log Off buddy.");
 		
 		Home_Page.lnk_LogOut(driver).click(); 
 		Log.info("Click action is perfomred on Log Out link");
	}
 
   @AfterMethod
   public void afterMethod() 
   {
 	    driver.quit();
   }
}
