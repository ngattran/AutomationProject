package automationFramework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import appModule.SignIn_Action;
import pageObjects.Home_Page;

public class Module_Param_TC {
	public static WebDriver driver = null;
	@Test
	public void TestCase1() throws Exception
	{
		SignIn_Action.Login(driver);
		System.out.println("Login to the webpage successfully");
		//Logout the webpage
		Home_Page.lnk_LogOut(driver).click();
	}
	@BeforeTest
	public void beforeTest() 
	{
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.store.demoqa.com");
		System.out.println("The webpage is loaded successfully");
	}
	@AfterTest
	public void afterTest() 
	{
		driver.quit();
	}
}
