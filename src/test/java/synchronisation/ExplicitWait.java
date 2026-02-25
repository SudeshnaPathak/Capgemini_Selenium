package synchronisation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/ui/dropdown?sublist=0");
		WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(5));
		WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[text()='Dropdown']")));
		e.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Multi Select']"))).click();
	}

}
