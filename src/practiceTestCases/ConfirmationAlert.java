package practiceTestCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ConfirmationAlert {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://toolsqa.wpengine.com/handling-alerts-using-selenium-webdriver/");
		driver.manage().window().maximize();
		// This step will result in an alert on screen
		//WebElement element = driver.findElement(By.xpath(".//button[contains(@onclick, 'promptConfirm')]"));
		driver.findElement(By.xpath(".//button[contains(@onclick, 'pushConfirm()')]")).click();
		//JavascriptExecutor executor = (JavascriptExecutor) driver;
		//executor.executeScript("arguments[0].click()", element);
		System.out.println("Promt button is clicked");
		
		Alert confirmationAlert = driver.switchTo().alert();
		System.out.println("Alert text is: " + confirmationAlert.getText());
		confirmationAlert.accept();
		driver.close();
		driver.quit();
	}
}
