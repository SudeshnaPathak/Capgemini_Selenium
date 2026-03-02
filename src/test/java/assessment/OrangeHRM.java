package assessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OrangeHRM {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.findElement(By.name("username")).sendKeys("Admin", Keys.TAB, "admin123", Keys.ENTER);
		driver.findElement(By.xpath("//span[text()='Buzz']")).click();
		
		String expectedText = "Hi! I'am Sudeshna";
		driver.findElement(By.xpath("//textarea")).sendKeys(expectedText);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.navigate().refresh();
		WebElement textbox = driver.findElement(By.xpath("(//p[@class='oxd-text oxd-text--p orangehrm-buzz-post-body-text'])[1]"));
		System.out.println("Post Verified:"+ driver.findElement(By.xpath("(//p[@class='oxd-text oxd-text--p orangehrm-buzz-post-body-text'])[1]")).isDisplayed());
		String actualText = textbox.getText();
		if(actualText.equals(expectedText))
		{
			System.out.println("Post Verified Successfully");
		}
		else System.out.println("Post not verified");
		
	}

}
