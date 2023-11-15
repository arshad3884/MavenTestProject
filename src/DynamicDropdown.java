import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DynamicDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		/*select option from "FROM" dropdown*/
		//driver.findElement(By.xpath("//a[@value='BLR']")).click();
		
		//Thread.sleep(2000);
		/*Select option from "TO" dropdown, using the index to fetch the 
		element from "TO" dropdown as 1st element on on "FROM" dropdown
		Here we accessing dynamic dropdown with indexes*/
		//driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		
		/*Parent-Child relationship locator to Identify the objects Uniquely*/
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		/*selecting DEPART DATE using cssSelector*/
		driver.findElement(By.cssSelector(".ui-datepicker-days-cell-over.ui-datepicker-today")).click();
		/*Selecting ROUND TRIP radio button*/
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
	}

}
