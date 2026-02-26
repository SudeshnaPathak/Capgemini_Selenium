package assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zomato {
	static WebDriver driver = new ChromeDriver();
	
	public static void countLinks()
	{
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
	}
	
	public static void main(String[] args) {
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.zomato.com/kolkata/order-food-online");
		countLinks();
		
		driver.findElement(By.xpath("(//p[text()='Dosa'])[1]")).click();
		countLinks();
		
		driver.findElement(By.xpath("//h4[contains(text(),'Dosa')]")).click();
		driver.quit();
	}

}
