package popups;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadPopUp {

	public static void main(String[] args) throws InterruptedException {
		 WebDriver driver = new ChromeDriver(); 
		 driver.manage().window().maximize(); 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		 driver.get("https://demoapps.qspiders.com/ui?scenario=1");
		 driver.findElement(By.xpath("//section[text()='Popups']")).click();
		 driver.findElement(By.xpath("//section[text()='Download']")).click();
		 
		 //File Download 
		 driver.findElement(By.id("writeArea")).sendKeys("Sudeshna Pathak", Keys.TAB, Keys.TAB, Keys.ENTER);
		 
		 //File upload popup
		 //input type should be file
		 driver.findElement(By.xpath("//section[text()='File Uploads']")).click();
		 File f = new File("./src/test/resources/Testdata/resume.pdf"); 
		 String path = f.getAbsolutePath(); 
		 Thread.sleep(3000); 
		 driver.findElement(By.id("resume")).sendKeys(path); 
		 Thread.sleep(5000); 
		 driver.quit(); 
		
	}

}
