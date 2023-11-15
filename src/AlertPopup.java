import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AlertPopup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("name")).sendKeys("Muhammad Arshad");
		driver.findElement(By.id("alertbtn")).click();
		/* Switching control to popup, if have only OK button */
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		/* Switching control to popup, if have OK & CANCEL buttons */
		driver.findElement(By.id("confirmbtn")).click();
		driver.switchTo().alert().dismiss();

	}

}
