package webDrivermethods;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WindowHandles {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Register.html");
		Thread.sleep(2000);
		System.out.println(driver.getWindowHandle()); //returns session id of current window
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='link facebook']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='link youtube']")).click();
		Thread.sleep(2000);
		Set<String> ids = driver.getWindowHandles(); //returns session id of all open windows
		System.out.println(ids);
		for(String id : ids)
		{
			driver.switchTo().window(id); //switch to the tab using session id, driver control goes to the new tab
			if(driver.getCurrentUrl().contains("youtube")) driver.close(); //only close youtube tab
		}
	}

}
