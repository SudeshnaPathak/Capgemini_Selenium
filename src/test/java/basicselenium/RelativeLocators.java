package basicselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocators {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement ref = driver.findElement(By.id("realme")); //reference of Common Element
		WebElement text = driver.findElement(RelativeLocator.with(By.id("samsung")).above(ref)); //above common element
		System.out.println(text.getText());
		WebElement text1 = driver.findElement(RelativeLocator.with(By.id("moto")).below(ref)); //below common element
		System.out.println(text1.getText());
	}

}
