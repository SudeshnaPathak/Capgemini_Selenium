package assessment2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Actions act = new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.amazon.in/?ref_=icp_country_from_us");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bluetooth headphones", Keys.ENTER);
		Thread.sleep(3000);
		List<WebElement> products = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		for(WebElement product : products)
		{
			int price = Integer.parseInt(product.getText());
			if(price < 900)
			{
				act.scrollToElement(product);
				product.click();
				String title = driver.findElement(By.id("productTitle")).getText();
				System.out.println("Title: " + title);
				int p = Integer.parseInt(driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText());
				System.out.println("Price: " + p);
				System.out.println("Price < 900:"+ (p < 900));
//				String rating = driver.findElement(By.xpath("(//span[@id='acrPopover'])[1]//a/span")).getText();
//				System.out.println("Rating: "+ rating);
				driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click(); //click on add to cart
				int cnt = Integer.parseInt(driver.findElement(By.id("nav-cart-count")).getText());
				if(cnt == 1)
				{
					System.out.println("Cart count incremented by 1");
				}
				break;
			}
		}
		driver.quit();
	}

}
