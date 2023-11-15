import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class TableSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		//click on column to sort the table
		driver.findElement(By.xpath("//tr/th[1]")).click();
		//capture all column elements into WebElement list
		List <WebElement> elementList = driver.findElements(By.xpath("//td[1]"));
		//capture text of all element in new list (Which should be sorted)
		List<String> originalList = elementList.stream().map(s->s.getText()).collect(Collectors.toList());
		//Sort the captured list
		List <String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		//Check that columnList and sortedColumn lists are same (It should be same to verify that column on webpage is sorted)
		Assert.assertTrue(originalList.equals(sortedList));
		
		//Scan the name column with gettext-> Beans -> Print the price of the Rice.
		List <String> price;
		do
			{
			List <WebElement> records = driver.findElements(By.xpath("//td[1]"));
			price = records.stream().filter(s->s.getText().contains("Wheat"))
				.map(s->getPriceVeggie(s)).collect(Collectors.toList());
	
			//Print the price of selected veggie
			price.forEach(s->System.out.println(s));
			if (price.size()<1)
			{
				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			}
			}while (price.size()<1);
	}

	private static String getPriceVeggie(WebElement s) {
		// TODO Auto-generated method stub
		String vegPrice =s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return vegPrice;
	}

}
