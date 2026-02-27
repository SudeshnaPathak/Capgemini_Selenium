package webDrivermethods;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverMethodsDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println(driver.manage().window().getSize());
		System.out.println(driver.manage().window().getPosition());
		
		Point p = new Point(0 , 0);
		driver.manage().window().setPosition(p);
		
		Dimension s = new Dimension(1000 , 500);
		driver.manage().window().setSize(s);
		
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
