package assessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//span[@role='button']")).click();
		
		WebElement e = driver.findElement(By.xpath("(//input[@placeholder='Search for Products, Brands and More'])[1]"));
		e.sendKeys("shoes");
		driver.findElement(By.xpath("(//div[contains(text(),'for men')])[1]")).click();
		driver.quit();
	}

}
