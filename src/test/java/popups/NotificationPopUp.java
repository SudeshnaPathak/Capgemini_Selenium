package popups;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NotificationPopUp {

	public static void main(String[] args) throws InterruptedException {
		  ChromeOptions options = new ChromeOptions(); 
		  options.addArguments("--disable-notifications"); 
		  WebDriver driver = new ChromeDriver(options); 
		  driver.manage().window().maximize(); 
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		  driver.get("https://demoapps.qspiders.com/ui?scenario=1");
		  driver.findElement(By.xpath("//section[text()='Popups']")).click(); 
		  driver.findElement(By.xpath("//section[text()='Notifications']")).click();
		  driver.findElement(By.id("browNotButton")).click();
		  Thread.sleep(2000);
		  driver.quit();
	}

}
