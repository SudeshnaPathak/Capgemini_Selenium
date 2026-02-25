package keys;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRM {

	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys("Admin", Keys.TAB);
		driver.findElement(By.name("password")).sendKeys("admin123", Keys.ENTER);
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		WebElement e = driver.findElement(By.xpath("//label[text()='Employee Name']/..//following-sibling::div//input"));
		e.sendKeys("Alex");
		Thread.sleep(10000);
		e.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		e.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']")).click();
		WebElement e1 = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		Thread.sleep(5000);
		e1.sendKeys(Keys.CONTROL+"A");
		Thread.sleep(5000);
		e1.sendKeys(Keys.CONTROL+"X");
		Thread.sleep(5000);
		e1.sendKeys("Sudeshna");
		Thread.sleep(2000);
		e1.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		WebElement e2 = driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']"));
		e2.click();
		Robot robo = new Robot();
		robo.keyPress(KeyEvent.VK_TAB);
		robo.keyRelease(KeyEvent.VK_TAB);
		robo.keyPress(KeyEvent.VK_TAB);
		robo.keyRelease(KeyEvent.VK_TAB);
		robo.keyPress(KeyEvent.VK_TAB);
		robo.keyRelease(KeyEvent.VK_TAB);
		robo.keyPress(KeyEvent.VK_TAB);
		robo.keyRelease(KeyEvent.VK_TAB);
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
	}

}
