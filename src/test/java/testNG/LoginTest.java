package testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginTest {
		
		static WebDriver driver = null;
		@BeforeSuite
		public void database()
		{
			System.out.println("Database setup complete");
		}
		
		@BeforeClass
		public void launch()
		{
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			System.out.println("Browser Launch Successfull");
		}
		
		@BeforeMethod
		public void openApp()
		{
			driver.get("https://demowebshop.tricentis.com/");
			System.out.println("Navigated to application");
		}
		
		@Test
		public void actions()
		{
			driver.findElement(By.xpath("//a[text()='Log in']")).click();
			driver.findElement(By.id("Email")).sendKeys("pathaksudeshna92@gmail.com");
			driver.findElement(By.id("Password")).sendKeys("Sp@12345");
			driver.findElement(By.xpath("//input[@value='Log in']")).click();
			System.out.println("Login Module tested");
		}
		
		@AfterMethod
		public void back() throws InterruptedException
		{
			driver.navigate().back();
			Thread.sleep(3000);
			driver.navigate().back();
			System.out.println("Back to homepage");
		}
		
		@AfterClass
		public void end()
		{
			driver.quit();
			System.out.println("Browser closed");
		}
		
		@AfterSuite
		public void generateReports()
		{
			System.out.println("Test Reports generated");
		}
		
}
