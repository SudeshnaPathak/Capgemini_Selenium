package crossBrowserTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	WebDriver driver;
	@BeforeClass
	@Parameters("browser")
	public void lauchBrowser(String browser)
	{
		if(browser.equals("chrome")) driver = new ChromeDriver();
		else if(browser.equalsIgnoreCase("firefox")) driver = new FirefoxDriver();
		else if(browser.equalsIgnoreCase("edge")) driver = new EdgeDriver();
		else driver = new ChromeDriver();
	}
}
