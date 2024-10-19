
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;

public class browserCommands {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		Thread.sleep(1000);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
		driver.get("https://Shop.DemoQA.com");
		String title = driver.getTitle();
		int titleLength = title.length();
		System.out.println("The title of the page is" +title);
		System.out.println("The length of the title" +titleLength);
		String actualURL = "https://Shop.DemoQA.com";
		String currentURL = driver.getCurrentUrl();
		if(currentURL.equals(actualURL))
		{
			System.out.println("Yes,it is correct page");
		}
		else
		{
			System.out.println("No,it is not correct page");
		}
		String source = driver.getPageSource();
		int sourceLength = source.length();
		System.out.println(source);
		System.out.println(sourceLength);
		//driver.close();

	}

}
