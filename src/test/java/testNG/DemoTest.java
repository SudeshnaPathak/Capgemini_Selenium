package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoTest {
	
	@Test
	public void demo()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://mvnrepository.com/artifact/org.testng/testng/7.10.2");
		driver.quit();
	}
	
//	@Test
//	public void base()
//	{
//		System.out.println(bye);
//	}
//	
//	@Test
//	public void z()
//	{
//		System.out.println("zebra");
//	}
//	
//	@Test
//	public void m()
//	{
//		System.out.println("monkey");
//	}
}
