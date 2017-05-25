package pageObjects;

import org.openqa.selenium.By;
import Utilities.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogIn_Page 
{
	 private static WebElement element = null;
	 public static WebElement Login_UserName(WebDriver driver)
	 {
		 element = driver.findElement(By.id("log"));
		 Log.info("Username text box found");
	     return element;
	 }
	 public static WebElement Login_Password(WebDriver driver)
	 {
	     element = driver.findElement(By.id("pwd"));
	     Log.info("Password text box found");
	     return element;
	 }
	 public static WebElement LogIn_Button(WebDriver driver)
	 {
	     element = driver.findElement(By.id("login"));
	     Log.info("Submit button found");
	     return element;
	 }
}
