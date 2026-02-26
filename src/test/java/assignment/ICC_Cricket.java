package assignment;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ICC_Cricket {

	public static void main(String[] args) throws AWTException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.icc-cricket.com/tournaments/mens-t20-world-cup-2026");
		
		driver.findElement(By.xpath("(//span[text()='Standings'])[2]")).click();
		Robot robo = new Robot();
		for(int i = 0 ; i < 10 ; i++) 
		{
			robo.keyPress(KeyEvent.VK_DOWN);
			robo.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(100);
		}
		for(int i = 1 ; i <= 2 ; i++)
		{
			String groupPath = String.format("//button[@aria-label='Super 8 GROUP %s']", i);
			driver.findElement(By.xpath(groupPath)).click();
			System.out.println("Super 8 GROUP "+i);
			String team = driver.findElement(By.xpath("((//table/tbody/tr)[1]/td)[2]")).getText();
			String nrr = driver.findElement(By.xpath("((//table/tbody/tr)[1]/td)[8]")).getText();
			String points = driver.findElement(By.xpath("((//table/tbody/tr)[1]/td)[9]")).getText();
			System.out.println("Team : " + team);
			System.out.println("NRR : " + nrr);
			System.out.println("Points: " + points);
		}
		driver.quit();
	}

}
