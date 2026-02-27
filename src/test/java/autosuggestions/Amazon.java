package autosuggestions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.amazon.com/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("watch");
		List<WebElement> suggestions = driver.findElements(By.xpath("//div[@role='row']//span"));
		for(WebElement suggestion : suggestions)
		{
			System.out.println(suggestion.getText());
			if(suggestion.getText().toLowerCase().contains("women")) 
				{
					suggestion.click();
					break;
				}
		}
		
//		List<WebElement> suggestions = driver.findElements(By.xpath("//div[@role='row']"));
//		for(WebElement suggestion : suggestions)
//		{
//			System.out.println(suggestion.getText());
//			if(suggestion.getAttribute("aria-label").toLowerCase().contains("women")) 
//				{
//					suggestion.click();
//					break;
//				}
//		}
		
		driver.quit();
	}

}
