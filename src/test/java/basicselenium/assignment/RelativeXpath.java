package basicselenium.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RelativeXpath {
	public static void searchItem(WebDriver driver)
	{
		//Enter text on search box
		driver.findElement(By.id("small-searchterms")).sendKeys("Laptop");
		
		//Click on search button
		driver.findElement(By.xpath("//input[@value='Search'][1]")).click();
	}
	
	public static void addToCart(WebDriver driver)
	{
		//Click on Add to Cart 
		driver.findElement(By.xpath("//input[@value='Add to cart'][1]")).click();
	}
	
	public static void viewCart(WebDriver driver)
	{
		//Click on shopping cart 
		driver.findElement(By.xpath("//span[contains(text(),'Shopping')]")).click();
	}
	
	public static void checkout(WebDriver driver)
	{
		//Select Country
		driver.findElement(By.xpath("//option[text()='India']")).click();
		
		//Agree to terms of service
		driver.findElement(By.name("termsofservice")).click();
		
		//Click on Checkout
		driver.findElement(By.id("checkout")).click();
	}
}
