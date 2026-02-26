package testNG;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class hardAndSoftAssert {
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
		driver.get("https://demowebshop.tricentis.com/");
		String title = driver.getTitle();
//		assertEquals(title, "Demo Web Shop"); //Hard Assert
		a.assertEquals(title , "Demo Web Shop"); //Soft Assert
		System.out.println("Navigated to application");
		a.assertAll();
	}
	
	@Test
	public void actions() throws InterruptedException
	{
		driver.findElement(By.id("small-searchterms")).sendKeys("shoes", Keys.ENTER);
		Thread.sleep(2000);
		WebElement e = driver.findElement(By.xpath("//h1[text()='Search']"));
//		assertEquals(e.getText(),"Search1"); //Hard Assert
		a.assertEquals(e.getText(),"Search1");
		System.out.println("Search Displayed: "+ e.isDisplayed());
		a.assertAll();
	}
	
	@AfterMethod
	public void back() throws InterruptedException
	{
		driver.navigate().back();
		Thread.sleep(2000);
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
