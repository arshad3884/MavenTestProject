import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class AutoSuggestion {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		/*Locate and select check boxes*/
		/*Assertion to assert the results are matched with required condition or not*/
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "1 Adult");
		/*To get the number of checkboxes on a page*/
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		
		/*Handling AutoSuggestive dropdowns using Selenium*/
		driver.findElement(By.id("autosuggest")).sendKeys("Pa");
		Thread.sleep(2000);
		
		List<WebElement> listOptions = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		for(WebElement listoption :listOptions) {
			if(listoption.getText().equalsIgnoreCase("Pakistan")) {
					listoption.click();
					break;			
			}
		}

	}
}
