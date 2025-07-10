
package Generic_Utililities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import Pom_Repo.HomePage;
import Pom_Repo.LoginPage;

public class BaseClass 
{
	public WebDriver driver;
	
	//this driver is used to get in testfailuretake screenshot
	public static WebDriver sdriver;
	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void BS()
	{
		System.out.println("DataBase connection");
	}
	
	@BeforeTest(groups = {"smokeTest","regressionTest"})
	public void BT()
	{
		System.out.println("Parallel Execution");
	}
	@Parameters("browser")
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void BC(String browser) throws Throwable
	{
		System.out.println("url"+url);
	
		//File_Uitility futli = new File_Uitility();
		if(browser.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("FireFox"))
		{
			driver = new FirefoxDriver();
			
		}
		else if (browser.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
			
		}
		else
		{
			driver = new ChromeDriver();
		}
		sdriver = driver;
		System.out.println("Browser Launching");
	}
	@Parameters({"url","Username","Password"})
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void BM(String browser,String url,String Username,String Password) throws Throwable
	{
		//File_Uitility futli = new File_Uitility();
		//String browser = futli.getKeyAndValue("Browser");	
		//String url = futli.getKeyAndValue("URL");
		//String Username = futli.getKeyAndValue("UserName");
		//String Password = futli.getKeyAndValue("Password");
		
		System.out.println("url"+url);
		System.out.println("Username"+Username);
		System.out.println("Password"+Password);
		driver.get(url);

		LoginPage login = new LoginPage(driver);
		login.loginToApp(Username, Password);

		WebDriver_Utilities wlib = new WebDriver_Utilities();
		wlib.maximizeWindow(driver);
		wlib.waitElementToLoad(driver);
		
		System.out.println("Login to Application");
	}
	
	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void AM()
	{
		HomePage home = new HomePage(driver);
		home.logoutApp();
		System.out.println("Logout from Application");
	}
	
	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void AC()
	{
		driver.quit();
		System.out.println("close the Browser");
	}
	@AfterTest(groups = {"smokeTest","regressionTest"})
	public void AT()
	{
		System.out.println("parallel execution close");
	}
	
	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void AS()
	{
		System.out.println("Close DAtaBAse");
	}
}
 