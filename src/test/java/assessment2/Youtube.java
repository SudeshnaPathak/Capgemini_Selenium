package assessment2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Youtube {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Actions act = new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.youtube.com/");
		WebElement searchbox = driver.findElement(By.xpath("//input[@name='search_query']"));
		searchbox.sendKeys("selenium automation tutorial");
		Thread.sleep(2000);
		List<WebElement> suggestions = driver.findElements(By.xpath("//div[@role='listbox']/div/div[1]"));
		System.out.println(suggestions.size());
		for(int i = 0 ; i < suggestions.size()-1 ; i++)
		{
			WebElement suggestion = suggestions.get(i);
			System.out.println(suggestion.getAttribute("aria-label"));
			if(i == suggestions.size()-2) suggestion.click();
		}
		driver.findElement(By.xpath("//a[@class='yt-lockup-metadata-view-model__title']")).click();
		Thread.sleep(2000);
		String title = driver.getTitle().toLowerCase();
		System.out.println("Title:" + title);
		if(title.contains("selenium") || title.contains("automation"))
		{
			System.out.println("Verified");
		}
		else System.out.println("Not verified");
		driver.quit();
	}

}
