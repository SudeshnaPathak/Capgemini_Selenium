package assessment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.amazon.in/?ref_=icp_country_from_us");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("smart tv 15 inch", Keys.ENTER);
		List<WebElement> tvs = driver.findElements(By.xpath("//h2//span[contains(text(),'HD')]"));
		List<WebElement> prices = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		int len = Integer.min(tvs.size(), prices.size());
		for(int i = 0 ; i < len ; i++)
		{
			System.out.println(tvs.get(i).getText() + ":-" + prices.get(i).getText());
		}
		driver.quit();
	}

}
