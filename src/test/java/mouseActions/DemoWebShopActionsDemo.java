package mouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoWebShopActionsDemo {

	public static void main(String[] args) throws InterruptedException{
		
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demowebshop.tricentis.com/");

        Actions act = new Actions(driver);

        // ---------------------------
        // 1. Mouse Hover
        // ---------------------------
        WebElement computers = driver.findElement(By.linkText("Computers"));
        act.moveToElement(computers).perform();
        System.out.println("Hovered on Computers menu");

        Thread.sleep(2000);

        // ---------------------------
        // 2. Click
        // ---------------------------
        act.click(computers).perform();
        System.out.println("Clicked Computers");

        Thread.sleep(2000);

        // ---------------------------
        // 3. Right Click (Context Click)
        // ---------------------------
        WebElement desktop = driver.findElement(By.linkText("Desktops"));
        act.contextClick(desktop).perform();
        System.out.println("Right clicked Desktops");

        Thread.sleep(2000);

        // ---------------------------
        // 4. Double Click
        // ---------------------------
        act.doubleClick(desktop).perform();
        System.out.println("Double clicked Desktops");

        Thread.sleep(2000);

        // ---------------------------
        // 5. Click and Hold
        // ---------------------------
        WebElement searchBox = driver.findElement(By.id("small-searchterms"));
        act.clickAndHold(searchBox).perform();
        System.out.println("Click and hold on search box");

        Thread.sleep(2000);
        act.release().perform();
        
//        searchBox.sendKeys("Laptop");
//        Thread.sleep(1000);
//        searchBox.sendKeys(Keys.ARROW_DOWN , Keys.CONTROL+"A", Keys.ENTER);
        
        // ---------------------------
        // 6. Keyboard Action
        // ---------------------------
        searchBox.sendKeys("Laptop");
        act.keyDown(Keys.CONTROL)
           .sendKeys("a")
           .keyUp(Keys.CONTROL)
           .perform();
        System.out.println("Selected text using keyboard action");

        Thread.sleep(2000);

        // ---------------------------
        // 7. Drag and Drop (Demo Simulation)
        // ---------------------------
        WebElement logo = driver.findElement(By.className("header-logo"));
        act.dragAndDropBy(logo, 500, 500).perform();
        System.out.println("Dragged logo slightly");
        
        // ---------------------------
        // 8. Scroll By or Scroll to Element
        // ---------------------------
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.id("newsletter-subscribe-button"));
        Thread.sleep(3000);

        // scroll by pixels
        act.scrollByAmount(0, 600).perform(); //along y axis
        Thread.sleep(3000);

       // scroll directly to element
       act.scrollToElement(element).perform();
       System.out.println("Scrolled to element");
     
        driver.quit();
	}

}
