import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class FiltersOnTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		String text = "Rice";
		//write search key in filter input field
		driver.findElement(By.id("search-field")).sendKeys(text);
	
		//create a list of first column items after applying filter
		List <WebElement> columnItems = driver.findElements(By.xpath("//tr/td[1]"));
		//create a new list from above list which contains required results
		List <WebElement> result = columnItems.stream().filter(s->s.getText().contains(text)).collect(Collectors.toList());
		//check whether these two lists are equal
		Assert.assertEquals(columnItems, result);
	}

}
