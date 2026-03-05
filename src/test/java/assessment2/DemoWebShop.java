package assessment2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoWebShop {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.xpath("//li/a[contains(text(),'Books')]")).click();
		driver.findElement(By.xpath("(//div[@class='product-item'])[3]//input")).click();
		String title1 = driver.findElement(By.xpath("(//div[@class='product-item'])[3]//h2/a")).getText();
		double price1 = Double.parseDouble(driver.findElement(By.xpath("((//div[@class='product-item'])[3]//div[@class='prices']/span)[2]")).getText());
		driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]")).click();
		Thread.sleep(1000);
		String title2 = driver.findElement(By.xpath("//a[@class='product-name']")).getText();
		double price2 = Double.parseDouble(driver.findElement(By.xpath("//span[@class='product-unit-price']")).getText());
		if(title1.equals(title2)) System.out.println("Title name verified");
		else System.out.println("Name invalid");
		if(price1 == price2) System.out.println("Price verified");
		else System.out.println("Price invalid");
		driver.findElement(By.xpath("//input[@name='removefromcart']")).click();
		driver.findElement(By.xpath("//input[@name='updatecart']")).click();
		boolean isEmpty = driver.findElement(By.xpath("//div[contains(text(),'Your Shopping Cart is empty!')]")).isDisplayed();
		Thread.sleep(1000);
		System.out.println("Cart Empty: "+ isEmpty);
		driver.quit();
	}

}
