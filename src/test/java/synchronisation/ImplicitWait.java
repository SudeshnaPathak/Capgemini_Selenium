package synchronisation;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWait {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); //Global Wait Statement
		
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.findElement(By.xpath("//a[@class='link facebook']")).click();
		driver.findElement(By.xpath("//a[@class='link youtube']")).click();
		Set<String> ids = driver.getWindowHandles();
		for(String id : ids)
		{
			driver.switchTo().window(id);
			if(driver.getCurrentUrl().contains("youtube")) driver.close();
		}
	}

}
