import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class eCommerceAddCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		//creating object for applying explicit wait
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		/*Implicit wait*/
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		/*List of product to add them in cart*/
		String[] itemsNeeded = {"Brocolli", "Beetroot","Cauliflower","Cucumber"};
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		addItems(driver, itemsNeeded);
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		//explicit wait
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter promo code']")));
		
		driver.findElement(By.xpath("//input[@placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("promoBtn")).click();
		
		//explicit wait
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoBtn")));
		
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		//Countries dropdown
		WebElement countriesDropdown = driver.findElement(By.xpath("//select[@style='width: 200px;']"));
		Select CountriesList = new Select(countriesDropdown);
		CountriesList.selectByValue("Pakistan");
		driver.findElement(By.className("chkAgree")).click();
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		driver.quit();
		
	}
	public static void addItems(WebDriver driver, String[] itemsNeeded) {
		int j=0;
		/*Grabbing all products in a list type webElement*/
		List<WebElement> products = driver.findElements(By.cssSelector("div.product"));
		/*Go through each product one by one to find required one*/
		for (int i=0; i<products.size(); i++) {
			String[] productName = products.get(i).getText().split("-");
			String name =productName[0].trim();
			
			/*Covert array into array list
			  check whether your extracted name present in the arraylist on not */
			
			List<String> itemsNeededList = Arrays.asList(itemsNeeded);
			
			if(itemsNeededList.contains(name)) {
				/*Click to add cart*/
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j==itemsNeeded.length)//iterate equal to size of the array
					{
					break; //after three times it break
				}
				
				//break; can not use for multiple values 
			}
		}
	}

}
