package dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class SingleSelectDropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/ui/dropdown?sublist=0");
		Thread.sleep(3000);
		WebElement code = driver.findElement(By.id("country_code")); //country code dropdown
		Thread.sleep(3000);
		WebElement country = driver.findElement(By.id("select3"));//country dropdown
		Thread.sleep(3000);
		
		//Select class for Dropdown
		Select sel1 = new Select(code);
		sel1.selectByIndex(2); //By Index
		Thread.sleep(3000);
		
		Select sel2 = new Select(country);
		sel2.selectByValue("Germany"); //By Value
		sel2.selectByVisibleText("India"); //By Visible Text
		
	}

}
