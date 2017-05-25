package practiceTestCases;

import org.openqa.selenium.Cookie;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import pageObjects.LogIn_Page;


public class HandlyingCookies 
{
	static WebDriver driver;	

    public static void AddCookies(WebDriver driver, String sUsername, String sPassword) throws Exception					
    {	
    	 try
    	 {
    		 LogIn_Page.txt_UserName().sendKeys(sUsername);
    		 LogIn_Page.txt_Password().sendKeys(sPassword);
    		 LogIn_Page.Login_btn().click();
    		 Log.info("SignIn Action is successfully perfomred");
    		 
    		 Cookie ck = new Cookie(sUsername, sPassword);
        	 driver.manage().addCookie(ck);
    	 }
    	 catch (Exception e)
    	 {
    		 Log.info("SignIn action is not successfully");
    		 throw e;
    	 }
    }		
    public static void LoadCookiesData(WebDriver driver) throws InterruptedException	
    {
    	// After adding the cookie we will check that by displaying all the cookies.
		Set<Cookie> cookiesList =  driver.manage().getCookies();
		//Write cookies information to the file Cookies.data
		File file = new File("Cookies.data");							
        try		
        {		
            // Delete old file if exists
			file.delete();		
            file.createNewFile();			
            FileWriter fileWriter = new FileWriter(file);							
            BufferedWriter Bufwriter = new BufferedWriter(fileWriter);							
            // loop for getting the cookie information 		
            for(Cookie ck :cookiesList)							
            {		
                Bufwriter.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure()));																									
                Bufwriter.newLine();			
            }		
            Bufwriter.flush();			
            Bufwriter.close();			
            fileWriter.close();			
        }
        catch(Exception ex)					
        {		
            ex.printStackTrace();			
        }	
    }
}
