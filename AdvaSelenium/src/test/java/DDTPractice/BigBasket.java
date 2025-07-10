package DDTPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BigBasket {

	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bigbasket.com/?utm_source=google&utm_medium=cpc&utm_campaign=Brand-PAN-Jan25&gad_source=1&gad_campaignid=22175835974&gbraid=0AAAAA91V9ooHOO1UhElIGRXWo8RAz15QX&gclid=CjwKCAjwsZPDBhBWEiwADuO6y9ytxe4DtNl42fiEQIBTEtk5wEzZA6ZUF26naHhIxIILZ4HCCDsj1RoC5JQQAvD_BwE");
		driver.findElement(By.xpath("//input[@placeholder='Search for Products...' and @fdprocessedid='dhqw5m']")).sendKeys("Mango");
		
		//List<WebElement> elements = driver.findElements(By.xpath("//input[@placeholder='Search for Products...']"));
		//WebElement firstElement = elements.get(0); // First occurrence
		//WebElement secondElement = elements.get(1); // Second occurrence

		//WebElement firstElement = driver.findElement(By.xpath("(//*[@placeholder='Search for Products...'])[1]"));
		//WebElement secondElement = driver.findElement(By.xpath("(//*[@placeholder='Search for Products...'])[2]"));
		Thread.sleep(2000);
		WebElement child = driver.findElement(By.xpath("(//input[@placeholder='Search for Products...'])[1]"));

		//child.sendKeys("Mango");
	
		//div[@class ='QuickSearch___StyledMenuButton-sc-rtz2vl-1 dpuSIx']//div[@id='placeholder']"));
		
		Actions a = new Actions(driver);
		a.moveToElement(child);
		child.sendKeys("Mango");
	}

}
