package popups;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPopUp {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/ui/alert?sublist=0");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//td[text()='Levis Shirt']/..//input")).click();
		//td[text()='Levis Shirt']/preceding-sibling::td//input
		driver.findElement(By.id("deleteButton")).click();
		Thread.sleep(1000);
		Alert a = driver.switchTo().alert(); //Inside TargetLocatorInterface, return type of switchTo we have alert() which returns Alert class
		Thread.sleep(1000);
		System.out.println(a.getText());
		Thread.sleep(1000);
		a.accept();
		Thread.sleep(1000);
		driver.close();
//		a.dismiss(); NoSuchSessionException
	}

}
