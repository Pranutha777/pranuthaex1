package DDTPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartPhoneprize {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		//driver.findElement(By.id("placeholder")).sendKeys("Iphone");
		WebElement ele = driver.findElement(By.name("q"));
		ele.sendKeys("Iphone");
		ele.click();
		List<WebElement> IphonePrice = driver.findElements(By.xpath("//div[@class= Nx9bqj _4b5DiR]"));
		for(WebElement price :IphonePrice)
		{
			String actprice =price.getText();
			String expPrice = actprice.replace("₹", "").replace(",", "");
		
		int finalprice =Integer.parseInt(expPrice);
		 if(finalprice < 70000)
		 {
			 System.out.println("price:"+finalprice);
		 }
		}
	}

}
