package mouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClass {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demowebshop.tricentis.com/");
		WebElement link = driver.findElement(By.xpath("(//a[contains(text(),'Computers')])[1]"));
		Actions act = new Actions(driver);
		
		//hover & click
		//act.moveToElement(link).perform();
		//act.click().perform()

		//OR
		
		//Directly click
		act.click(link).perform();
		driver.quit();
	}

}
