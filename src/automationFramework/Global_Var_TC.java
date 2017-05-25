package automationFramework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import pageObjects.Home_Page;
import appModule.SignIn_Action;
import Utilities.Constants;

public class Global_Var_TC
{
	private static WebDriver driver = null;
	@Test
	public static void TestCase() throws Exception 
	{
		SignIn_Action.Login(driver);
		System.out.println("Login to webpage successfully, this is time to logout");
		Home_Page.lnk_LogOut(driver).click();
	}
	@BeforeTest
	public void beforeTest() 
	{
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Constants.URL);
		System.out.println("Webpage is loaded successfully");
	}

	@AfterTest
	public void afterTest() 
	{
		driver.quit();
	}

}
