package DDTPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PropertyFile {

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		
		
		FileInputStream file = new FileInputStream("D:\\Java Programs\\Data.properties");

		Properties prop = new Properties();
		prop.load(file);
		WebDriver driver;
		String Browser = prop.getProperty("Browser");
		String url = prop.getProperty("URL");
		String user = prop.getProperty("Username");
		String pass = prop.getProperty("Password");
		if(Browser.equalsIgnoreCase("chrome")) 
		{
			driver = new ChromeDriver();
		}
		else if (Browser.equalsIgnoreCase("FireFox"))
		{
			driver = new FirefoxDriver();
		}
		//in else it should be default browser
		else
		{
			driver =new ChromeDriver();
		}
		driver.get(url);
		
		WebElement ele = driver.findElement(By.id("email"));
		ele.sendKeys(user);
		System.out.println("username:"+ele);
		WebElement ele1 = driver.findElement(By.id("pass"));
		ele1.sendKeys(pass);
		System.out.println("pass"+ele1);
		
		
		

		
	}

}
