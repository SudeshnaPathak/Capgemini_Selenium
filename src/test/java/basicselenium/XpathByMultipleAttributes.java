package basicselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathByMultipleAttributes {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com/");
		Thread.sleep(3000);
		//Enter song to be searched
		driver.findElement(By.name("search_query")).sendKeys("ishq va");
		Thread.sleep(3000);
		//Click on search button
		driver.findElement(By.xpath("//button[@aria-label='Search' and @title='Search']")).click();
		// OR (//button[@aria-label='Search'])[1] ----->using indexing
		Thread.sleep(3000);
		//Click on the song
		driver.findElement(By.xpath("//yt-formatted-string[@class='style-scope ytd-video-renderer' and @aria-label='Ishqa Ve (official video) | Zeeshan Ali | Yuvraj Tung | Seerat Mast | Sandeep Aulakh | Honey Dhillon 3 minutes, 50 seconds']")).click();
	}
}
