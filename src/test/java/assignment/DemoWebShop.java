package assignment;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoWebShop {

	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		System.out.println("TEST CASE: 1");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		for(WebElement link : links)
		{
			System.out.println(link.getText());
		}
		
		System.out.println("TEST CASE: 6");
		System.out.println(driver.findElement(By.partialLinkText("14.1-inch Laptop")).getTagName());
		
		WebElement e = driver.findElement(By.xpath("//a[text()='14.1-inch Laptop']/../..//input"));
		Dimension d = e.getSize();
		System.out.println("Height: "+ d.height + " Width: " + d.width);
		e.click();
		
		driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
		
		WebElement rmv = driver.findElement(By.xpath("//input[@type='checkbox' and @name='removefromcart']"));
		System.out.println("Is remove checkbox selected? " + rmv.isSelected());
		Rectangle r = rmv.getRect();
		System.out.println("Dimension: "+ r.getDimension());
		System.out.println("Location: "+ r.getPoint());
		
		WebElement subTotal = driver.findElement(By.xpath("//span[@class='product-subtotal']"));
		Thread.sleep(2000);
		System.out.println("Total amount: " + subTotal.getText());
		
		System.out.println("TEST CASE: 8");
		driver.navigate().back();
		driver.findElement(By.id("small-searchterms")).sendKeys("laptop");
		Robot robo = new Robot();
		robo.keyPress(KeyEvent.VK_DOWN);
		robo.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		System.out.println("Add to Cart Enabled : "+driver.findElement(By.xpath("//input[@value='Add to cart']")).isEnabled());
		driver.quit();
	}

}
