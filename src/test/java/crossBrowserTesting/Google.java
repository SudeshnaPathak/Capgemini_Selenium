package crossBrowserTesting;

import org.testng.annotations.Test;

public class Google extends BaseClass{
	
	@Test
	public void demo1Test()
	{
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		System.out.println("Page Title: " + driver.getTitle());
		driver.quit();
	}	
}
