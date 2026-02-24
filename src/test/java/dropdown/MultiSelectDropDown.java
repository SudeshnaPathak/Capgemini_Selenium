package dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectDropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/ui/dropdown/multiSelect?sublist=1");
		Thread.sleep(3000);
		
		WebElement multi = driver.findElement(By.id("select-multiple-native"));
		Thread.sleep(2000);
		Select sel = new Select(multi);
		System.out.println("Multiple select :"+ sel.isMultiple());
		sel.selectByIndex(0);
		Thread.sleep(1000);
		sel.selectByValue("Mens Casual Premium Slim Fit T-Shirts ");
		Thread.sleep(1000);
		sel.selectByVisibleText("Mens Cotton Jacket...");
		Thread.sleep(1000);
		sel.selectByContainsVisibleText("John Hardy");
		Thread.sleep(1000);
//		driver.findElement(By.xpath("//button[text()='Add']")).click();
//		Thread.sleep(1000);
		
//		sel.deselectByIndex(0);
//		Thread.sleep(1000);
//		sel.deselectByValue("Mens Casual Premium Slim Fit T-Shirts ");
//		Thread.sleep(1000);
//		sel.deselectByVisibleText("Mens Cotton Jacket...");
//		Thread.sleep(1000);
//		sel.deSelectByContainsVisibleText("John Hardy");
//		Thread.sleep(1000);	
		
//		sel.deselectAll();
		
		System.out.println(sel.getFirstSelectedOption().getText());
		Thread.sleep(2000);
		List<WebElement> selectedOptions = sel.getAllSelectedOptions();
		for(WebElement option : selectedOptions)
		{
			System.out.println(option.getText());
		}
	}

}
