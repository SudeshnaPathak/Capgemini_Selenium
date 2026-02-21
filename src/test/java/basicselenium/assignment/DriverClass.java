package basicselenium.assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverClass {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		
		IdLocator.register(driver);
		Thread.sleep(2000);
		NameLocator.login(driver);
		Thread.sleep(2000);
		RelativeXpath.searchItem(driver);
		Thread.sleep(2000);
		RelativeXpath.addToCart(driver);
		Thread.sleep(2000);
		RelativeXpath.viewCart(driver);
		Thread.sleep(2000);
		RelativeXpath.checkout(driver);
		Thread.sleep(2000);
		LinkTextLocator.searchNewProducts(driver);
		Thread.sleep(2000);
		LinkTextLocator.searchRecentlyViewedProducts(driver);
	}

}
