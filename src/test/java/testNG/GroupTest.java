package testNG;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GroupTest {
	
	static WebDriver driver = null;
	
	@Test(groups="smoke")
	public void Launch()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("Browser Launch Successfull");
	}
	
	@Test(groups="smoke")
	public void app()
	{
		driver.get("https://demowebshop.tricentis.com/");
		System.out.println("Navigated to application");
	}
	
	@Test(groups="smoke")
	public void base()
	{
		System.out.println(driver.getTitle());
	}
	
	@Test
	public void end()
	{
		driver.quit();
		System.out.println("Browser closed");
	}
}
