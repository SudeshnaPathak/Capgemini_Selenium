package basicselenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsXpath {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(2000);
		
//		driver.findElement(By.linkText("Facebook")).click(); //linktext is generally used with <a> tags bcoz they have visible texts
//		driver.findElement(By.linkText("YouTube")).click();
		
//		driver.findElement(By.linkText("Log in")).click();
//		Thread.sleep(2000);
		
//		WebElement text = driver.findElement(By.partialLinkText("Shopping")); //Do not use when there is space in visible text
//		System.out.println(text.getText()); //returns the visible text inside opening & closing tag ----> Shopping cart
		
		//locate searchbox and enter the input
//		driver.findElement(By.id("small-searchterms")).sendKeys("Black & White Diamond Heart");
		//click on search
//		driver.findElement(By.cssSelector("input[value='Search']")).click(); 
		
//		List<WebElement> link = driver.findElements(By.tagName("a"));
//		System.out.println(link.size());
//		for(WebElement allink : link)
//		{
//			System.out.println(allink.getText());
//		}
		
		//using relative Xpath : Xpath by textfunction
		WebElement text = driver.findElement(By.xpath("//strong[text()='Newsletter']"));
		System.out.println(text.getText());
		
		//using relative Xpath : Xpath by contains
		WebElement text1 = driver.findElement(By.xpath("//strong[contains(text(),'News')]"));
		System.out.println(text1.getText());
		
		driver.findElement(By.linkText("Register")).click();
		//using relative Xpath : Xpath by attribute
		driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("FirstName"); 
		
		
		

	}

}
