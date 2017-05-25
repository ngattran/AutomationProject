package practiceTestCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PromptAlerts {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://toolsqa.wpengine.com/handling-alerts-using-selenium-webdriver/");
		driver.manage().window().maximize();
		// This step will result in an alert on screen
		//WebElement element = driver.findElement(By.xpath("//*[@id='content']/p[16]/button"));
		//((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
		driver.findElement(By.xpath(".//button[contains(@onclick, 'promptConfirm()')]")).click();
		System.out.println("Prompt Confirm button is clicked");	
		
		Alert promptAlert  = driver.switchTo().alert();
		System.out.println("Alert text is " + promptAlert.getText());
		//Send some text to the alert
		
		promptAlert.sendKeys("Accepting the alert");
		Thread.sleep(2000); //This sleep is not necessary, just for demonstration
		promptAlert.accept();
	}

}
