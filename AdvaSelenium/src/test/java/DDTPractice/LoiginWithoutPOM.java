package DDTPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pom_Repo.LoginPage1;

public class LoiginWithoutPOM {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/index.php?action=index&module=Home");
		LoginPage1 loginData = new LoginPage1(driver);
		loginData.EnterLoginData("admin","admin");
	}

}
