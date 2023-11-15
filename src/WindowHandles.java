import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowHandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		//to maximize the window
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.className("blinkingText")).click(); //Open in new tab/window
		//Handle new window
		Set <String> windows = driver.getWindowHandles(); //[parentId, ChildId]
		Iterator <String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		//Navigating to child window
		driver.switchTo().window(childId);
		//Getting email from text extracting from child window
		driver.findElement(By.xpath("//p[@class='im-para red']")).getText();
		String email = driver.findElement(By.xpath("//p[@class='im-para red']")).getText().split(" ")[4].trim();
		//Navigating back to parent window
		driver.switchTo().window(parentId);
		driver.findElement(By.id("username")).sendKeys(email);
	}

}
