package basicselenium.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LinkTextLocator {

	public static void searchRecentlyViewedProducts(WebDriver driver)
	{
		driver.findElement(By.partialLinkText("Recently")).click();
	}
	
	public static void searchNewProducts(WebDriver driver)
	{
		driver.findElement(By.linkText("New products")).click();
	}

}
