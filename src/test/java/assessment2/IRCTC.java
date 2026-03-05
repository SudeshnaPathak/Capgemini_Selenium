package assessment2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class IRCTC {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions(); 
		options.addArguments("--disable-notifications"); 
		WebDriver driver = new ChromeDriver(options); 
		Actions act = new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.irctc.co.in/");
		String parentId = driver.getWindowHandle();
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		WebElement holiday = driver.findElement(By.xpath("//h2[text()='HOLIDAYS']"));
		act.scrollToElement(holiday).perform();
		act.moveToElement(holiday).perform();
		driver.navigate().to("https://web.archive.org/web/20260204092626/https://www.hotels.irctc.co.in/hotels");
		
		driver.findElement(By.id("inputbox")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='autofillId']//p[contains(text(),'Delhi')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Search Hotel')]")).click();
		List<WebElement> hotels = driver.findElements(By.xpath("//div[@class='HotelAddress']/parent::div//a/span"));
		for(int i = 0 ; i < 5 ; i++)
		{
			System.out.println(hotels.get(i).getText());
		}
		driver.switchTo().window(parentId);
	}

}
