import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class fileUploadDownload {

	public static void main(String[] args) throws InterruptedException, IOException {

		String downloadPath = System.getProperty("user.dir");

		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://altoconvertpdftojpg.com/");
		driver.findElement(By.id("browse")).click();
		Thread.sleep(3000);
		//After showing the upload popup we run the script using AutoID
		//AutoID will handle how to select file and upload it
		//exe file of AutoID script will be generated and run using below command
		Runtime.getRuntime().exec("C:\\Users\\rahul\\Documents\\check\\fileupload.exe");
		// Ater running the script the file get uploaded \
		Thread.sleep(5000);
		//Clicking on Covert file button
		driver.findElement(By.id("submit_btn")).click();
		//Wait until conversion completed and download button appears
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//Apply wait until the download button appear after processing the file
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Download']")));
		driver.findElement(By.xpath("//a[normalize-space()='Download']")).click();

		Thread.sleep(5000);
		File f = new File(downloadPath + "/converted.zip");
		if (f.exists())
		{
			//Confirm that file is downloaded
			System.out.println("file downloaded!");
			//We can delete a file 
			Assert.assertTrue(f.exists());
			if (f.delete())
			System.out.println("file deleted!");

		}

	}

}
