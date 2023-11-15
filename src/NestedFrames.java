import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NestedFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		//to maximize the window
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/nested_frames");
		//check total number of frames on the page
		System.out.println(driver.findElements(By.tagName("frame")).size());
		driver.switchTo().frame("frame-top"); //parent frame
		driver.switchTo().frame("frame-middle"); //nested frame
		System.out.println(driver.findElement(By.id("content")).getText()); //Grabbing text
	}

}
