package testNG;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NinzaHRMSoftAssert {
	static WebDriver driver = null;
	static SoftAssert a = null;
	
	@BeforeSuite
	public void database()
	{
		System.out.println("Database setup complete");
	}
	
	@BeforeClass
	public void launch()
	{
		driver = new ChromeDriver();
		a = new SoftAssert();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("Browser Launch Successfull");
	}
	
	@BeforeMethod
	public void openApp()
	{
		driver.get("http://49.249.28.218:8091/");
		System.out.println("Navigated to application");
	}
	
	@Test
	public void actions() throws InterruptedException
	{
		driver.findElement(By.id("username")).sendKeys("rmgyantra" , Keys.TAB);
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999", Keys.ENTER);
		Thread.sleep(2000);
		WebElement e = driver.findElement(By.xpath("//h3[text()='Ninza-HRM']"));
		a.assertEquals(e.getText(), "Ninza-HRM");
		a.assertAll();
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
