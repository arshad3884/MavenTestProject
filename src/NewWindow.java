import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NewWindow {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		//Opening a new blank tab
		driver.switchTo().newWindow(WindowType.WINDOW); //TAB for new tab
		//Switching to new tab
		Set <String> handles = driver.getWindowHandles();
		Iterator <String> it = handles.iterator();
		String parentWindowID = it.next();
		String childWindowID = it.next();
		//switch browser to child tab and get a new URL
		driver.switchTo().window(childWindowID);
		driver.get("https://rahulshettyacademy.com/");
		//Get text from the first course on the page
		String firstCourse = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		System.out.println(firstCourse);
		//Switch to parent window
		driver.switchTo().window(parentWindowID);
		//enter course name on parent page name field
		WebElement nameField = driver.findElement(By.name("name")); 
		nameField.sendKeys(firstCourse);
		//take screenshot of the nameField webElement
		File file= nameField.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("C:\\Users\\hp\\Desktop\\screenShot.jpg"));
		//take screenshot of whole page
		File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShot, new File("C:\\Users\\hp\\Desktop\\Fullpage.jpg"));
		//Get Height and Width of a webElement
		System.out.println(nameField.getRect().getDimension().getHeight());
		System.out.println(nameField.getRect().getDimension().getWidth());
	}

}
