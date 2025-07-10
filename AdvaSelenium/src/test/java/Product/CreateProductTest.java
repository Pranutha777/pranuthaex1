package Product;

	

	import java.io.FileInputStream;
	import java.io.IOException;
	import java.time.Duration;

import Generic_Utililities.WebDriver_Utilities;

//java.util.Properties;

	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_Utililities.BaseClass;
import Generic_Utililities.Excel_Utility;
	import Generic_Utililities.File_Uitility;
	
	import Pom_Repo.CreateProductPage;
	import Pom_Repo.HomePage;
	import Pom_Repo.LoginPage;
	import Pom_Repo.ProductLooUpImg;
	import Pom_Repo.ProductValidationPage;
@Test
	public class CreateProductTest extends BaseClass
	{
			
		public void createProductTest() throws Throwable 
		{

	//Login to vtiger application->click on product link->click on create product lookup image->
	//Enter product name->click on save Btn->verify whether the product is created in product Information page 
	//and Logout from the application.	

			
			
//			driver.findElement(By.linkText("Products")).click();
			HomePage home = new HomePage(driver);
			home.clickProductLink();
			
			// >click on create product lookup image
//			driver.findElement(By.cssSelector("[alt='Create Product...']")).click();

			ProductLooUpImg lookUp = new ProductLooUpImg(driver);
			lookUp.clickPrdLookUp();
			
			Excel_Utility elib = new Excel_Utility();
			String prdName = elib.getExcelData("Product", 0, 0);
			System.out.println("prodname:"+prdName);
//			driver.findElement(http://By.name("productname")).sendKeys(prdName);

			// click on save Btn
//			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

			CreateProductPage prdpage = new CreateProductPage(driver);
			prdpage.enterPrdData(prdName);
			
			Thread.sleep(2000);
			// >verify whether the product is created in product Information page
//			String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
	//
//			if (actData.equals(prdName)) {
//				System.out.println("Product Name is Created");
//			} else {
//				System.out.println("Product name is not created");
//			}

			ProductValidationPage validate = new ProductValidationPage(driver);
			validate.validateProd(driver, prdName);
			
			// logout from application
//			driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//			driver.findElement(By.linkText("Sign Out")).click();
			//home.logoutApp();
		}

	}

