package mouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClick {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.selenium.dev/selenium/web/mouse_interaction.html");
		Actions act = new Actions(driver);
		WebElement textField = driver.findElement(By.id("clickable"));
		act.doubleClick(textField).perform();
		System.out.println(driver.findElement(By.id("click-status")).getText());
		driver.quit();
	}

}
