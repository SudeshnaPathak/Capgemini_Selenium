package assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipKart {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.flipkart.com/");
		
		WebElement e = driver.findElement(By.xpath("(//input[@placeholder='Search for Products, Brands and More'])[1]"));
		e.sendKeys("phone" , Keys.ENTER);
		List<WebElement> phones = driver.findElements(By.xpath("//li[contains(text(),'4 GB RAM')]/../../preceding-sibling::div"));
		for(int i = 0; i < phones.size(); i += 2)
		{
			System.out.println(phones.get(i).getText());
		}
		driver.quit();
	}

}
