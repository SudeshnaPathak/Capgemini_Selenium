package basicselenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@role='button']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@placeholder='Search for Products, Brands and More' and @title='Search for Products, Brands and More'])[1]")).sendKeys("shoes");
		driver.findElement(By.xpath("(//button[@title='Search for Products, Brands and More'])[1]")).click();
		driver.findElement(By.xpath("(//img)[4]")).click();

	}

}
