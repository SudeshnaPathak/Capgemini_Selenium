package assessment;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonAddToCart {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.amazon.in/?ref_=icp_country_from_us");
		String parentId = driver.getWindowHandle();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Headphones", Keys.ENTER);
		driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
		
		Set<String> ids = driver.getWindowHandles();
		ids.remove(parentId);
		String childId = ids.iterator().next();
		driver.switchTo().window(childId);
		
		String title = driver.findElement(By.id("productTitle")).getText();
		System.out.println(title);
		try {
			driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[2]")).click(); //click on add to cart
		}
		catch(Exception e)
		{
			driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[1]")).click(); //click on add to cart
		}
		
		driver.findElement(By.xpath("//h1[contains(text(),'Added to cart')]")).isDisplayed();
		driver.quit();
		
	}

}
