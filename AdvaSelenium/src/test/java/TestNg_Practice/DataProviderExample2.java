import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utililities.Excel_Utility;

public class DataProviderExample2 {

	@Test(dataProvider = "readContactData")
	public void createContact(String FirstNAme,String LastNAme) throws Throwable
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.cssSelector("[alt=\"Create Contact...\"]")).click();
		driver.findElement(By.name("firstname")).sendKeys(FirstNAme);
		driver.findElement(By.name("lastname")).sendKeys(LastNAme);
		
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}
	
	@DataProvider
	public Object[][] readContactData()
	{
		Excel_Utility Excel = new Excel_Utility();
		Object[][] objArr = Excel.readDataUsingDAtaProvider("DataProviderData");
		
		//Object[][] objArr = new Object[3][2];
		
		//objArr[0][0]="Pranutha";
		//objArr[0][1]="Raavi";
		
	//	objArr[1][0]="Bhupendra";
		//objArr[1][1]="Raavi";
		
		//objArr[2][0]="Aruna";
		//objArr[2][1]="Raavi";
		
		return objArr;
		
	}
}
 