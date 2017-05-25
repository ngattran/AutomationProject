package Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utilities.ExcelUtils;
import Utilities.Constants;

public class Utils 
{
	public static WebDriver driver = null;
	public static WebDriver openBrowser(int iTestCaseRow)
	{
		String sBrowserName;
		try
		{
			sBrowserName = ExcelUtils.getCellData(iTestCaseRow, Constants.Col_Browser);
			if(sBrowserName.equals("Mozilla"))
			{
				driver = new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.get(Constants.URL);
			}
			else
				{
					if(sBrowserName.equals("Chrome"))
					{
						driver = new ChromeDriver();
						String exePath = "E:\\Software\\Selenium Webdiver\\chromedriver.exe";
						System.setProperty("webdriver.chrome.driver", exePath);
						driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
						driver.get(Constants.URL);
					}
				}
			}
			catch (Exception e)
			{
				e.getMessage();
			}
		return driver;
	}
	public static String getTestCaseName(String sTestCase)
	{
		 String value = sTestCase;
	     try
	     {
	        int posi = value.indexOf("@");
	        value = value.substring(0, posi);
	        posi = value.lastIndexOf(".");    
	        value = value.substring(posi + 1);
	        return value;
	     }
	     catch (Exception e)
	     {
	        e.getMessage();
	        throw (e);
	     }
	}
}
