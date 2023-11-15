import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class angularFormPractice {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.name("name")).sendKeys("Muhammad Arshad");
		driver.findElement(By.className("ng-pristine")).sendKeys("alpha3884@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("1004254585");
		driver.findElement(By.id("exampleCheck1")).click();
		/*Static Dropdown*/
		WebElement staticdropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select dropdown = new Select(staticdropdown);
		dropdown.selectByIndex(0);
	
		
		driver.findElement(By.cssSelector("input[value='option2']")).click();
		driver.findElement(By.name("bday")).sendKeys("10/06/1992");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		/*Print success message to console*/
		System.out.println(driver.findElement(By.className("alert-success")).getText());
	}

}
