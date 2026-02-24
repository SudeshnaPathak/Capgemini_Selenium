package webDrivermethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverNavigateMethods{

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.youtube.com/");
		Thread.sleep(3000);
		driver.navigate().to("https://open.spotify.com/");
		Thread.sleep(3000);
		driver.navigate().back(); //back to youtube
		Thread.sleep(3000);
		driver.navigate().forward(); //forward to spotify
		Thread.sleep(3000);
		driver.navigate().refresh();
	}

}
