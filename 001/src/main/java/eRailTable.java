import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class eRailTable {

	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		Thread.sleep(1000);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		//changing to RemoteWebDriver
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
		driver.get("https://erail.in/");
		//clear the text in source and enter "ms" and tab
		WebElement source =driver.findElement(By.xpath("//input[@id='txtStationFrom']"));
		source.clear();
		source.sendKeys("ms");
		source.sendKeys(Keys.TAB);
		WebElement destination = driver.findElement(By.xpath("//input[@id='txtStationTo']"));
		destination.clear();
		destination.sendKeys("mdu");
		destination.sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//input[@id='chkSelectDateOnly']")).click();
		//Get all train names
		List<WebElement> trainListCount = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader stickyTrainListHeader']//tr"));
		int trainCount = (trainListCount.size())-1;
		System.out.println("The number of trains available are" +(trainCount));
		
		Set<String> uniqueElement = new HashSet<>();
		Set<String> duplicateElement = new HashSet<>();
	
	    for(int i=2;i<=trainCount;i++) {
	    	String element = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader stickyTrainListHeader']//tr["+i+"]/td[2]")).getText();
	    	if(!element.isEmpty())
			{
				if(!uniqueElement.add(element))//--> it should return false so that duplicate value get added
				{
					duplicateElement.add(element);
				}		
			}
	    }
		
		//To print unique elements
		if(!uniqueElement.isEmpty())
		{
			for(String unique : uniqueElement)
			{
				System.out.println("The Unique Elements Are" +unique);
			}
		}
		
		//To print duplicate elements
		if(!duplicateElement.isEmpty())
		{
			for(String duplicate : duplicateElement)
			{
				System.out.println("The Duplicate Elements Are" +duplicate);
			}
		}
		else
		{
			System.out.println("No duplicates found");
		}
			
		
	}

}