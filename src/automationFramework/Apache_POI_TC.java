package automationFramework;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.Home_Page;
import Utilities.Constants;
import Utilities.ExcelUtils;
import appModule.SignIn_Action;

public class Apache_POI_TC 
{
	private static WebDriver driver = null;
	public static void main(String [] args) throws Exception
	{
		//This is to open the Excel file. Excel path, file name and the sheet name are parameters to this method
		ExcelUtils.setExcelFile(Constants.Path_TestData + Constants.File_TestData,"Sheet1");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Constants.URL);
		SignIn_Action.Login(driver);
		System.out.println("Login Successfully, now it is the time to Log Off buddy.");
		Home_Page.lnk_LogOut(driver).click(); 
		driver.quit();
		//This is to send the Pass value to the Excel sheet in the Result column.
		ExcelUtils.setCellData("Pass", 1, 3);
	}
}