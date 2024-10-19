import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class tableLearning {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		Thread.sleep(1000);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		//changing to RemoteWebDriver
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		//To get the data of one cell for all the rows
		List<WebElement> allRows= driver.findElements(By.xpath("//table[@id='customers']//tr"));
		int rowCount = allRows.size();
		System.out.println("The number of Rows are" +" " +rowCount);
		List<WebElement> data= driver.findElements(By.xpath("//table[@id='customers']//tr[2]/td"));
	    int dataCount =data.size();
	    System.out.println("The number of Cells are" +" " +dataCount);
		for (int i=2;i<=rowCount; i++) {
		//+i
			for(int j=1;j<=dataCount;j++)
			{
		String text1= driver.findElement(By.xpath("//table[@id='customers']//tr["+i+"]//td["+j+"]")).getText();
		//System.out.println("The cell to print is" +" " +text1);
		//To print row and column of particular detail
		if(text1.equals("Helen Bennett"))
				{
			System.out.println("The row number is" +i);
			System.out.println("The column number is" +j);
				}
			}
		}
	
	}

}
