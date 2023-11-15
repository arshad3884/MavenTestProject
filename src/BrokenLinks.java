import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		//maximize the window
		driver.manage().window().maximize();

		driver.get("https://www.netreputation.com/");
		Thread.sleep(2000);
		/*To check all Broken links on a webpage*/
		//Grabbing all footer links in a list of webElement
		List <WebElement> footerLinks = driver.findElements(By.xpath("//a"));
		//check number of links in the footer section
		System.out.println("Number of links on this page: "+footerLinks.size());
		//Go through each link
		for (WebElement footerLink: footerLinks)
		{
			//get url of each link using Selenium command
			String linkurl = footerLink.getAttribute("href");
			//Java methods will calls URL's and get you the status codes, we don't need to call links manually
			HttpURLConnection conn= (HttpURLConnection) new URL(linkurl).openConnection();
			//providing the request method to connection
			conn.setRequestMethod("HEAD");
			conn.connect();
			//getting a response code
			int responseCode = conn.getResponseCode();
			System.out.println(responseCode);
			if (responseCode>400)
			{
				System.out.println("The link with the text "+footerLink.getText()+" is broken! with code: "+responseCode);
				//Assert.assertTrue(false);
			}
		}
	}

}
