package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SauceDemo {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user", Keys.TAB);
		driver.findElement(By.id("password")).sendKeys("secret_sauce", Keys.ENTER);
		WebElement e = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
		String expected = e.getText();
		e.click();
		driver.findElement(By.xpath("//button[@id='add-to-cart']")).click();
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		String actual = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
		if(expected.equals(actual))
		{
			driver.findElement(By.id("react-burger-menu-btn")).click();
			driver.findElement(By.id("logout_sidebar_link")).click();
		}
	}

}
