package automationFramework;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.*;
import Utilities.*;
import appModule.*;

public class UDF_TC 
{
	public WebDriver driver = null;
	private String sTestCaseName;
    private int iTestCaseRow;
    
	@BeforeMethod
	public void beforeMethod() throws Exception 
	{
		sTestCaseName = this.toString();
		sTestCaseName = Utils.getTestCaseName(this.toString());
		ExcelUtils.setExcelFile(Constants.Path_TestData + Constants.File_TestData,"Sheet1");
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, Constants.Col_TestCaseName);
 		driver = Utils.openBrowser(iTestCaseRow);
	}
 
	@Test
	public void main() throws Exception 
	{
 	    SignIn_Action.Login(driver);
 		System.out.println("Login Successfully, now it is the time to Log Off buddy.");
 		Home_Page.lnk_LogOut(driver).click(); 
	}
 
   @AfterMethod
   public void afterMethod() 
   {
	   System.out.println("Quit the webpage");
 	   driver.quit();
   }
}
