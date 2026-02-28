package assignment;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class OrangeHRM {
	static WebDriver driver = null;
	static Robot robo = null;
	static Actions act = null;
	public static void scrollDropdownAndSelect(int i) throws InterruptedException
	{
		String path = String.format("(//div[text()='-- Select --'])[%s]", i);
		driver.findElement(By.xpath(path)).click();
		Thread.sleep(3000);
		robo.keyPress(KeyEvent.VK_DOWN);
		robo.keyRelease(KeyEvent.VK_DOWN);
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public static void setDate(String placeholderValue)
	{
		String path = String.format("//input[@placeholder='%s']", placeholderValue);
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    String formattedDate = date.format(formatter);
		driver.findElement(By.xpath(path)).sendKeys(Keys.CONTROL+"A", Keys.BACK_SPACE, formattedDate.toString());
	}
	
	public static void clickOnSubmit()
	{
		WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
		act.scrollToElement(submitButton);
		submitButton.click();
	}
	
	public static void Logout()
	{
		WebElement e = driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']"));
		e.click();
		for(int i = 1 ; i <= 4 ; i++)
		{
			robo.keyPress(KeyEvent.VK_TAB);
			robo.keyRelease(KeyEvent.VK_TAB);
		}
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public static void main(String[] args) throws AWTException, InterruptedException {
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--incognito");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		robo = new Robot();
		act = new Actions(driver);
		
		driver.findElement(By.name("username")).sendKeys("Admin", Keys.TAB, "admin123", Keys.ENTER);
		
		driver.findElement(By.xpath("//span[text()='Recruitment']")).click();
		driver.findElement(By.xpath("//button[text()=' Add ']")).click();
		
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Joy", Keys.TAB, "Brata", Keys.TAB, "Pathak");

		scrollDropdownAndSelect(1);
		
		driver.findElement(By.xpath("//input[@placeholder='Type here']")).sendKeys("pathaksudeshna92@gmail.com", Keys.TAB, "8825250158");
		
		WebElement uploadButton = driver.findElement(By.xpath("//div[@class='oxd-file-button']"));
		
        act.moveToElement(uploadButton).click().perform();
		String filepath = "C:\\Users\\Sudeshna Pathak\\eclipse-workspace\\Capgemini_Selenium\\src\\test\\java\\assignment\\demo.txt";
		//set filepath in clipboard
		StringSelection filedetails=new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filedetails,null);
		robo.delay(3000);
		//Ctrl+V : Paste from clipboard history
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_V);
		robo.keyRelease(KeyEvent.VK_V);
		robo.keyRelease(KeyEvent.VK_CONTROL);
		//Enter to upload file
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
		
		setDate("yyyy-dd-mm");
		Thread.sleep(2000);
		
		clickOnSubmit();
		
		Thread.sleep(10000);
		driver.findElement(By.xpath("//a[text()='Candidates']")).click();
		
		scrollDropdownAndSelect(1);
		Thread.sleep(2000);
		scrollDropdownAndSelect(1);
		Thread.sleep(2000);
		scrollDropdownAndSelect(2);
		Thread.sleep(2000);
		scrollDropdownAndSelect(2);
		
		WebElement candidateName = driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));
		candidateName.sendKeys("Joy");
		Thread.sleep(5000);
		candidateName.sendKeys(Keys.ARROW_DOWN , Keys.ENTER);
		
		setDate("From");
		
		clickOnSubmit();
		
		WebElement e = driver.findElement(By.xpath("//span[text()='(1) Record Found']"));
		System.out.println("Records Found: " + e.isDisplayed());
		
		Logout();
		
	}

}
