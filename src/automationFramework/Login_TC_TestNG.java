package automationFramework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import pageObjects.Home_Page;
import pageObjects.LogIn_Page;

public class Login_TC_TestNG 
{
	public static WebDriver driver = null;
	@Test
	public void Login() 
	{
	  Home_Page.lnk_MyAccount(driver).click();
	  LogIn_Page.Login_UserName(driver).sendKeys("testuser_20000");
	  LogIn_Page.Login_Password(driver).sendKeys("12345678");
	  LogIn_Page.LogIn_Button(driver).click();
	  System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
	  Home_Page.lnk_LogOut(driver).click();
	}
	@BeforeTest
	public void beforeTest() 
	{
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("http://www.store.demoqa.com");
	}

	@AfterTest
	public void afterTest() 
	{
		driver.quit();
	}

}
