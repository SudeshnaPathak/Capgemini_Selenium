package webElementMethods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Register.html");
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//h1[text()='Automation Demo Site ']")).isDisplayed());
		List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@type='checkbox']"));
		int i = 1;
		for(WebElement radio : radioButtons)
		{
			System.out.println(radio.isSelected());
			System.out.println(radio.getAttribute("type"));
			if(i != 2) radio.click();
			i++;
		}
		for(WebElement radio : radioButtons)
		{
			System.out.println(radio.isSelected());
		}
		System.out.println(driver.findElement(By.id("submitbtn")).isEnabled());
		WebElement element = driver.findElement(By.xpath("//h2[text()='Register']"));
		System.out.println(element.getText());
		System.out.println(element.getTagName());
		System.out.println(element.getCssValue("font-size"));
		System.out.println(element.getCssValue("margin-bottom"));
		Dimension sz = element.getSize();
		System.out.println("Height: "+ sz.height + " " + "Width: " + sz.width);
		Point loc = element.getLocation();
		System.out.println("X: " + loc.getX() + " Y: " + loc.getY());
		Rectangle rct = element.getRect();
		System.out.println("Dimension: "+ rct.getDimension());
		System.out.println("Coordinates: "+ rct.getPoint());
		driver.quit();
		
	}

}
