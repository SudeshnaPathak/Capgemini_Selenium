package mouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scroll {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demowebshop.tricentis.com/");
		Actions act = new Actions(driver);
		WebElement e = driver.findElement(By.xpath("//h3[text()='My account']"));
		act.scrollToElement(e).perform();
//		act.scrollByAmount(0 , 500).perform(); //vertical scrolling
		driver.quit();
	}

}
