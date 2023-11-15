import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Practice1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		//to maximize the window
		driver.manage().window().maximize();
		driver.get("http://qaclickacademy.com/practice.php");
		driver.findElement(By.id("checkBoxOption2")).click();
		WebElement object = driver.findElement(By.xpath("//label[@for='benz']"));
		String text = object.getText();
		
		WebElement list = driver.findElement(By.id("dropdown-class-example"));
		Select dropdown = new Select(list);
		dropdown.selectByVisibleText(text);
		
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.id("alertbtn")).click();
		String popuptext = driver.switchTo().alert().getText();
		System.out.println(popuptext.contains(text));
	}

}
