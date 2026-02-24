package webElementMethods;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {
	static WebDriver driver = new ChromeDriver();
	static String parentId;
	public static void searchSelectAddToCart(String item1, String item2) throws InterruptedException {

	    String searchBarId = "twotabsearchtextbox";
	    String searchButtonId = "nav-search-submit-button";
	    String searchItemPath = String.format("(//span[contains(text(),'%s')])[1]", item2);
	    WebElement searchBar = driver.findElement(By.id(searchBarId)); //locate search bar
	    searchBar.clear(); //clear search bar
	    searchBar.sendKeys(item1); //enter item to be searched
	    driver.findElement(By.id(searchButtonId)).submit(); //click on search button ---> A page showing list of items appears
	    Thread.sleep(2000);
	    driver.findElement(By.xpath(searchItemPath)).click(); //click on the specific item to open new item tab
	    
	    Set<String> ids = driver.getWindowHandles();
		ids.remove(parentId);
		String child = ids.iterator().next(); 
		driver.switchTo().window(child); //switch to new item tab
		Thread.sleep(2000);
		try {
			driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[2]")).click(); //click on add to cart
		}
		catch(Exception e)
		{
			driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[1]")).click(); //click on add to cart
		}
		driver.close();
		driver.switchTo().window(parentId); //return to parent window for more search
	}
	
	public static void main(String[] args) throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		Thread.sleep(2000);
		parentId = driver.getWindowHandle();
		
		List<List<String>> items = List.of(
		        List.of("Bosch fridge", "MaxFlex"),
		        List.of("Samsung TV", "QLED"),
		        List.of("iPhone 15", "128GB"),
		        List.of("Dell laptop", "Inspiron"),
		        List.of("Sony headphones", "WH-1000XM5")
		);
		
		for(List<String> item : items)
		{
			searchSelectAddToCart(item.get(0) , item.get(1));
		}
		driver.switchTo().window(parentId);
		driver.findElement(By.xpath("//a[@id='nav-cart']")).click(); //locate cart & click on it
		Thread.sleep(2000);
		System.out.println("Total: "+driver.findElement(By.xpath("//span[@id='sc-subtotal-amount-buybox']//span")).getText()); //subtotal
		driver.quit();
	}

}
