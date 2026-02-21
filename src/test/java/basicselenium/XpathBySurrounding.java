package basicselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathBySurrounding {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(3000);
		//Find duplicate element surrounding a unique element
		//Click on Add to cart of Build your own expensive computer
		driver.findElement(By.xpath("//a[text()='Build your own expensive computer']/../..//input")).click();
	}

}
