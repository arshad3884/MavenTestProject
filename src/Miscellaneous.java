import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Miscellaneous {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		//maximize the window
		driver.manage().window().maximize();
		//delete all cookies after opening browser
		driver.manage().deleteAllCookies();
		//delete some particular cookie/cache (session cookie)
		//driver.manage().deleteCookieNamed("sessionKey");
		
		driver.get("https://www.google.com");
		// TO take screenshot and save it in the image file 
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("C:\\Users\\hp\\Desktop\\screenshot.png"));
		
		}

}
