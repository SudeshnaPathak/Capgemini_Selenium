package assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amazon {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.amazon.in/?ref_=icp_country_from_us");
		
		driver.findElement(By.xpath("//a[text()=' Electronics ']")).click();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Boat Bluetooth", Keys.ENTER);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement bluetoothFilter = wait.until(
		        ExpectedConditions.elementToBeClickable(
		                By.xpath("//span[text()='Bluetooth']/ancestor::a/div")
		        )
		);
		bluetoothFilter.click();
		
		WebElement boatFilter = wait.until(
		        ExpectedConditions.elementToBeClickable(
		                By.xpath("//span[text()='boAt']/ancestor::a/div")
		        )
		);
		boatFilter.click();
		
		//span[contains(text(),'Bluetooth')]
		List<WebElement> bluetoothDevices = driver.findElements(By.xpath("//div[@data-cy='reviews-block']/preceding-sibling::div//h2/span"));
		for(WebElement device : bluetoothDevices) 
			{
				System.out.println(device.getText());
				System.out.println();
			}
		driver.quit();
	}

}
