package shadowRoot;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDomElement {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://books-pwakit.appspot.com/");
		
		SearchContext host = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
		host.findElement(By.cssSelector("#input")).sendKeys("Harry Porter", Keys.ENTER);
		Thread.sleep(5000);
		driver.quit();
	}

}
