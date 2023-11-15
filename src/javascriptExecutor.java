import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class javascriptExecutor {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// to scroll down the page casting the driver with JS variable
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//to scroll the webpage
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(3000);
		//to use nested scroll using table selector
		js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=5000");
		
		
		//getting the contents of last row of the table and sum them
		List <WebElement> values= driver.findElements(By.xpath("//div[@class='tableFixHead']//td[4]"));
		int sum = 0;
		for (int i=0; i<values.size();i++)
		{
			sum = sum +Integer.parseInt(values.get(i).getText());
		}
		System.out.println(sum);
		//compare the sum is correct or not
		String text = driver.findElement(By.xpath("//div[@class='totalAmount']")).getText();
		String[] textarray = text.split(" ");
		int total = Integer.parseInt(textarray[3]);
		Assert.assertEquals(total, sum);
		
		//practical example
		WebElement table =driver.findElement(By.id("product"));
		//number of rows
		System.out.println(table.findElements(By.tagName("tr")).size());
		//number of columns
		System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
		//Get and Print second row
		List<WebElement> secondRow = table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
		//print second row
		System.out.println(secondRow.get(0).getText());
		System.out.println(secondRow.get(1).getText());
		System.out.println(secondRow.get(2).getText());
		
	}

}
