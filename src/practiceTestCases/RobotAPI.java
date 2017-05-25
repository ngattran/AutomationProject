package practiceTestCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class RobotAPI {
	 WebDriver driver = null;
  @Test
  public void test() throws InterruptedException, AWTException 
  {
	  Robot robot = new Robot();  // Robot class throws AWT Exception	
      robot.mouseMove(830, 420); // move mouse point to specific location	
      robot.delay(1500);        // delay is to make code wait for mentioned milliseconds before executing next step	
      robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // press left click	
      robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // release left click	
      robot.delay(1500);	
      robot.keyPress(KeyEvent.VK_DOWN); // press keyboard arrow key to select Save radio button	
      Thread.sleep(2000);	
      robot.keyPress(KeyEvent.VK_ENTER);	
      // press enter key of keyboard to perform above selected action	
      
      
      driver.findElement(By.xpath(".//a[contains(text(),'animatedcolors')]")).click();
      
      Thread.sleep(2000); // Thread.sleep throws InterruptedException	
      robot.keyPress(KeyEvent.VK_DOWN);
      Thread.sleep(2000);
      robot.keyPress(KeyEvent.VK_TAB);
      Thread.sleep(2000);
      robot.keyPress(KeyEvent.VK_TAB);
      Thread.sleep(2000);
      robot.keyPress(KeyEvent.VK_TAB);
      Thread.sleep(2000);
      robot.keyPress(KeyEvent.VK_ENTER);
      Thread.sleep(2000);
  }
  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();	
      driver.get("http://spreadsheetpage.com/index.php/file/C35/P10/");	
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
