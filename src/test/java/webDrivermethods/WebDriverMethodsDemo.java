package webDrivermethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverMethodsDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		//used for navigation
		driver.get("https://testautomationpractice.blogspot.com/");
		Thread.sleep(2000);
		//fetch the title
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		//fetch current url
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(2000);
		//fetch page source
		System.out.println(driver.getPageSource());
		Thread.sleep(2000);
		
		driver.quit();
		
	}

}
