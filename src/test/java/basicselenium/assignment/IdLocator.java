package basicselenium.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IdLocator {
	
	public static void register(WebDriver driver)
	{
		//LinkText to Click on Register
		driver.findElement(By.linkText("Register")).click();
		
		//Select Gender
		driver.findElement(By.id("gender-female")).click();
		
		//Enter First Name
		driver.findElement(By.id("FirstName")).sendKeys("Sudeshna");
		
		//Enter Last Name
		driver.findElement(By.id("LastName")).sendKeys("Pathak");
		
		//Enter Email
		driver.findElement(By.id("Email")).sendKeys("pathaksudeshna92@gmail.com");
		
		//Enter Password
		driver.findElement(By.id("Password")).sendKeys("Sp@12345");
		
		//Enter Confirm Password
		driver.findElement(By.id("ConfirmPassword")).sendKeys("Sp@12345");
		
		//Click on Register button
		driver.findElement(By.id("register-button")).click();
	}

}
