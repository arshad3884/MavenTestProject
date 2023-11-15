import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDown {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		/*declare a dropdown through select class
		a dropdown with tag <select> is a static dropdown*/  
		WebElement staticdropdown= driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticdropdown);
		//dropdown.selectByIndex(2);
		//dropdown.selectByVisibleText("AED");
		//dropdown.deselectAll();  //works for dropdown with checkboxes
		dropdown.selectByValue("AED");
		/*shows the selected option*/
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
	}

}
