package basicselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) throws InterruptedException {
		
		//Launch the Empty Chrome Browser
		WebDriver driver = new ChromeDriver(); //UPCASTING
		//Maximize the Chrome Browser
		Thread.sleep(2000); //stops execution for 2 seconds
		driver.manage().window().maximize(); //METHOD CHAINING
		//Navigate to the application
		Thread.sleep(2000);
		driver.get("https://demowebshop.tricentis.com/");
		
		//Hover & Click on register
		driver.findElement(By.linkText("Register")).click();
		//Enter the value to first name text feild using id locator
		driver.findElement(By.id("FirstName")).sendKeys("FirstName");
		//Enter the value to last name text feild using name locator
		driver.findElement(By.name("LastName")).sendKeys("LastName");
	}

}
	