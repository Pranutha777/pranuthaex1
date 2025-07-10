package DDTPractice;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataFromJSON {

	public static void main(String[] args) throws Throwable 
	{
		// TODO Auto-generated method stub
		File f = new File("./src/test/resources/JsonData.JSON");
		ObjectMapper obj =new ObjectMapper();
		JsonNode data = obj.readTree(f);
		String Browser = data.get("Browser").asText();
		String Url = data.get("URL").asText();
		String username = data.get("UserName").asText();
		String password = data.get("PassWord").asText();
		System.out.println("url:"+Url);
		System.out.println("username:"+username);
		System.out.println("password:"+password);
		WebDriver driver;
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
		driver.get(Url);
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
		
	}

}
