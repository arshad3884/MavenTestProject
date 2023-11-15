import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import org.openqa.selenium.By;
public class RelativeLocator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement nameEditBox = driver.findElement(By.name("name"));
		
		//Need to add import package import static org.openqa.selenium.support.locators.RelativeLocator.*;
		//Use of relative locators to get and print the label of the name field WebElement
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());
		//Get input field by "Date of birth" locator
		WebElement SubmitCTA = driver.findElement(with(By.tagName("input"))
				.below(driver.findElement(By.xpath("//label[@for='dateofBirth']"))));
		SubmitCTA.click();
		
		//check the checkbox left of the element iceCreamTag
		WebElement iceCreamTag = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamTag)).click();
		
		//Print the label of the first radio button (Which is right of it)
		WebElement radio = driver.findElement(By.id("inlineRadio1"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radio)).getText());
	}

}
