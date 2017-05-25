package pageObjects;

import org.openqa.selenium.By;
import Utilities.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
// Create a Static Method for each Element (Object) in the Home Page. 
// Each method will have an Argument (driver) and a Return value (element).
// Driver is being passed as an Argument so that Selenium is able to locate the element on the browser (driver).
// Element is returned, so that an Action can be performed on it.
// Method is declared as Public Static, so that it can be called in any other method without instantiate the class.
public class Home_Page 
{
	private static WebElement element = null;
	public static WebElement lnk_MyAccount(WebDriver driver)
	{
		element = driver.findElement(By.id("account"));
		Log.info("My Account link element found");
		return element;
	}
	public static WebElement lnk_LogOut(WebDriver driver)
	{
	    element = driver.findElement(By.id("account_logout"));
	    Log.info("Log Out link element found");
	    return element;	
	}
}
