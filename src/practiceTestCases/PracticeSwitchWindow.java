package practiceTestCases;
 
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PracticeSwitchWindow 
{
		public static WebDriver driver;
		public static void main(String[] args) throws InterruptedException 
		{
			//System.setProperty("webdriver.chrome.driver", "C:\\selenium-java-3.3.1\\chromedriver.exe");
			System.setProperty("webdriver.gecko.driver", "C:\\selenium-java-3.3.1\\geckodriver.exe");
			//driver = new ChromeDriver();
			driver = new FirefoxDriver();
 			// Put an Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
 	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 	        // Launch the URL
 	        driver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");
 	        // Store and Print the name of the First window on the console
 	        String handle= driver.getWindowHandle();
 	        System.out.println("Window handle:" + handle);
 	        // Click on the Button "New Message Window"
 	        //driver.findElement(By.name("New Message Window")).click();
 	        driver.findElement(By.xpath(".//button[contains(@onclick, 'newMsgWin()')]")).click();
 	        Thread.sleep(2000);
 	        // Store and Print the name of all the windows open	              
 	        Set handles = driver.getWindowHandles();
 	        System.out.println("Window handles:" + handles);
 	        // Pass a window handle to the other window
 	        for (String handle1 : driver.getWindowHandles()) 
 	        {
 	        	System.out.println("Window handle1:" + handle1);
 	        	driver.switchTo().window(handle1);
 	        }
 	        // Closing Pop Up window
 	        driver.close();
 	        // Close Original window
 	        driver.quit();
 	}
 }