import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLcheck {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.setAcceptInsecureCerts(true); //override SSL error 
		//options.addExtensions("add extention path here"); //add extension to browser loaded by selenium
		
		//Setting proxy to selenium browser
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("ipaddress:4444");
		options.setCapability("proxy", proxy);
		
		//changing default download directory
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		options.setExperimentalOption("prefs", prefs);
		
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		//Take screenshot and saves it in an image file  
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\hp\\Desktop\\screenshot.png"));

	}

}
