package crossBrowserTesting;

import org.testng.annotations.Test;

public class Instagram extends BaseClass{
	
	@Test
	public void demo2Test()
	{
		driver.get("https://www.instagram.com/");
		driver.manage().window().maximize();
		System.out.println("Page Title: " + driver.getTitle());
		driver.quit();
	}
}
