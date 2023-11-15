import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Calender {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		
		
		driver.get("https://www.path2usa.com/travel-companion/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// to scroll down the page
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1200)");
		
		//open the calendar popup
		driver.findElement(By.id("form-field-travel_comp_date")).click();
		Thread.sleep(1000);
		//Selecting month
		while (!driver.findElement(By.xpath("//div[@class='flatpickr-current-month']")).getText().contains("May"))
		{
			driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();
		}
		//grabbing all calendar elements in a list
		List<WebElement> dates = driver.findElements(By.cssSelector("span.flatpickr-day"));
		int count = driver.findElements(By.cssSelector("span.flatpickr-day")).size();
		for (int i=0; i<count; i++)
		{
			String text = driver.findElements(By.cssSelector("span.flatpickr-day")).get(i).getText();
			//selecting the date
			if (text.equalsIgnoreCase("26"))
			{
				driver.findElements(By.cssSelector("span.flatpickr-day")).get(i).click();
				break;
			}
		}
		
	}

}
