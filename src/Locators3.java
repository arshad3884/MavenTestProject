import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Locators3 {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//Relative Xpath is //header/div/button[1] for Practice button
		//Relative Xpath is //header/div/button[1]/following-sibling::button[2] for Signup button
		driver.findElement(By.xpath("//header/div/button[1]")).click();
	}

}
