package DDTPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NamesOfIphoneAndPriceInFlipkart {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement ele = driver.findElement(By.name("q"));
		ele.sendKeys("Iphone");
		//ele.sendKeys(Keys.ENTER);  // Performs the search
		ele.submit();
List<WebElement> IphoneNames = driver.findElements(By.xpath("//div[@class='DOjaWF gdgoEp']//div[contains(@class,'KzDlHZ')]"));
List<WebElement> IphonePrice = driver.findElements(By.xpath("//div[@class='DOjaWF gdgoEp']//div[contains(@class,'Nx9bqj _4b5DiR')]"));
		
		int IphoneCount = IphoneNames.size();
		for(int i =0; i<IphoneCount; i++)
		{
			String name = IphoneNames.get(i).getText();
			String price = IphonePrice.get(i).getText();
			System.out.println("Names:"+name+ "-price"+price);
		}
		

	}

}
