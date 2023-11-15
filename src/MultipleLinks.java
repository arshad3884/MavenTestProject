import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MultipleLinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		//to maximize the window
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		
		//creating a webElement to click all links under that element
		WebElement footerLineDriver = driver.findElement(By.xpath("//div[@class='navFooterLine navFooterLinkLine navFooterPadItemLine navFooterCopyright']"));
		//Check number of links on that element
		System.out.println(footerLineDriver.findElements(By.tagName("a")).size());
		// ControlClick on each link and open them in new tab
		for (int i=0; i<footerLineDriver.findElements(By.tagName("a")).size(); i++)
		{
			String controlClick = Keys.chord(Keys.CONTROL, Keys.ENTER); //created a conrtrolClick variable	
			footerLineDriver.findElements(By.tagName("a")).get(i).sendKeys(controlClick);
		}
		//Grabbing text from all opened windows 
		Set <String> openedWindows = driver.getWindowHandles();
		Iterator <String> it =openedWindows.iterator();
		
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
	}

}
