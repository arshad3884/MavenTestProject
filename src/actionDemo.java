import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.AccessControlContext;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v108.overlay.model.ContrastAlgorithm;
import org.openqa.selenium.interactions.Actions;

import io.netty.handler.ssl.OpenSslApplicationProtocolNegotiator;

public class actionDemo {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		//to maximize the window
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		// Create an action object to perform a hover action 
		Actions a = new Actions(driver);
		//to write in caps in any input field
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		//to make hover on an element
		a.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
		//select inputed text
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().sendKeys("HELLO").doubleClick();
		//to write click on specific an element
		a.moveToElement(driver.findElement(By.id("nav-link-accountList"))).contextClick().build().perform();
		// get total number of links count on the page
		System.out.println(driver.findElements(By.tagName("a")).size());
		// get total number of links (anchor tags) in footer section
		// it is called limiting WebDriver scope
		WebElement footerdriver = driver.findElement(By.id("navFooter")); //creating a webElement for footer section
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		// get total links in single column of the footer section
		WebElement columndriver =driver.findElement(By.xpath("//div[@class='navFooterLinkCol navAccessibility'][1]"));
		System.out.println(columndriver.findElements(By.tagName("a")).size());
		
		//Click on each link in the column and check these are opening
		for (int i=0; i<columndriver.findElements(By.tagName("a")).size();i++ )
		{
			String controlClick = Keys.chord(Keys.CONTROL, Keys.ENTER); //creating Control+Enter functionality in a string variable
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(controlClick); //after getting the element sending the keys to open all links in new tab
		}	
		//Go to each window and get the title of all opened windows
			Set <String> windows = driver.getWindowHandles();
			Iterator <String> it =windows.iterator();
			String parent = it.next();
			
			while (it.hasNext()) 
			{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
			
			}
			driver.switchTo().window(parent);
	//To check the all borken links in footer section
			List <WebElement> allLinks = driver.findElements(By.xpath("//td[@class='navFooterDescItem']//a"));	
			for (WebElement link: allLinks) 
			{
				String url = link.getAttribute("href");
				System.out.println(url);
				//Create an object of java class HttpsURLConnection
				HttpsURLConnection conn = (HttpsURLConnection) new URL(url).openConnection();
				conn.setRequestMethod("HEAD");
				conn.connect();
				int responseCode = conn.getResponseCode();
				System.out.println(responseCode);
				if (responseCode>400)
				{
					System.out.println("The link '"+link.getText()+"' is broken! with error code: "+responseCode);
				}
			}
	}

}
