package appModule;

import org.openqa.selenium.WebDriver;
//import Utilities.Log;
import pageObjects.Home_Page;
import pageObjects.LogIn_Page;
import Utilities.ExcelUtils;

public class SignIn_Action 
{
	public static void Login(WebDriver driver) throws Exception
	{ 
		String sUserName = ExcelUtils.getCellData(1,1);
		String sPassword = ExcelUtils.getCellData(1,2);
		Home_Page.lnk_MyAccount(driver).click(); 
		Thread.sleep(100);
		LogIn_Page.Login_UserName(driver).sendKeys(sUserName);
		LogIn_Page.Login_Password(driver).sendKeys(sPassword);
		Thread.sleep(100);
		LogIn_Page.LogIn_Button(driver).click();
	}
}
