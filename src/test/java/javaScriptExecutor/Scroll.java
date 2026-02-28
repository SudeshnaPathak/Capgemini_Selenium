package javaScriptExecutor;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scroll {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://doodles.google/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//window : javascript method not window interface of selenium
		//window.scrollBy(x,y)
		js.executeScript("window.scrollBy(0, 100)");//starts from y=0
		js.executeScript("window.scrollBy(0, 100)");//starts from y=100
		js.executeScript("window.scrollBy(0, 100)");//starts from y=200
		
		//window.scrollTo(x,y)
		js.executeScript("window.scrollTo(0, 1000)");//starts from y=0
		js.executeScript("window.scrollTo(0, 5000)");//starts from y=0
		
		
	}

}
