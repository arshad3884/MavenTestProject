import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class FrameTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		//to maximize the window
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		//Drag and drop action inside the frames
		// Switch to frame using frame index
		driver.switchTo().frame(0); //First frame at 0th index
		// Switch to frame using webElement
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		//Create an action object to perform drag and drop
		Actions a = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target =	driver.findElement(By.id("droppable"));	
		a.dragAndDrop(source, target).build().perform();
		/*Webdriver will not automatically switch to default content, 
		We have to switch the driver to default content*/
		driver.switchTo().defaultContent();
	}

}
