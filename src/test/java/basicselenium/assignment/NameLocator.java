package basicselenium.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NameLocator {

	public static void login(WebDriver driver) {
		//Click on login
		driver.findElement(By.linkText("Log in")).click();
		
		//Enter email
		driver.findElement(By.name("Email")).sendKeys("pathaksudeshna92@gmail.com");
		
		//Enter password
		driver.findElement(By.name("Password")).sendKeys("Sp@12345");
		
		//Click on login button
		driver.findElement(By.xpath("//input[@value='Log in']")).click();

	}

}
