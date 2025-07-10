package Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;

import Generic_Utililities.BaseClass;
import Generic_Utililities.Excel_Utility;
import Generic_Utililities.File_Uitility;

import Generic_Utililities.Java_Utility;
import Generic_Utililities.WebDriver_Utilities;
import Pom_Repo.CreateProductPage;
import Pom_Repo.HomePage;
import Pom_Repo.LoginPage;
import Pom_Repo.ProductLooUpImg;
import Pom_Repo.ProductValidationPage;
import Pom_Repo.ValidationProductPage;
@Test
public class CreateProductAndDeleteProductTest extends BaseClass
{
	
	public void createProductAndDeleteProductTest() throws Throwable 
	{
		
		//driver.findElement(By.linkText("Products")).click();
		//driver.findElement(By.cssSelector("[alt='Create Product...']")).click();
		HomePage homepage = new HomePage(driver);
		homepage.clickProductLink();
		
		ProductLooUpImg ProductImg = new ProductLooUpImg(driver);
		ProductImg.clickPrdLookUp();
		
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandamNum();
		Excel_Utility Excel = new Excel_Utility();
		
		String ProductName = Excel.getExcelData("Product",0,0)+ranNum;
	
		System.out.println("ProductName"+ProductName);
		
		//driver.findElement(By.name("productname")).sendKeys(ProductName);
		//driver.findElement(By.cssSelector("[title='Save [Alt+S]']")).click();
		
	
		CreateProductPage ProductPage = new CreateProductPage(driver);
		ProductPage.enterPrdData(ProductName);
		
		//verification
		/*String actdata = driver.findElement(By.id("mouseArea_Product Name")) .getText();
		System.out.println("actdata"+actdata);
		if(actdata.contains(ProductName))
		{
			System.out.println("ProductName is created");
		}
		else
		{
			System.out.println("ProductName is  not created");

		}*/
		
		homepage.clickProductLink();
		//ProductImg.validatePrdDeleted(driver, ProductName);
		//driver.findElement(By.linkText("Products")).click();
		//driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='"+ProductName+"']/../preceding-sibling::td[2]//input[@type=\"checkbox\"]")).click();
		
		ProductImg.selectPrdCheckBox(driver, ProductName);
		//driver.findElement(By.cssSelector("[value='Delete']")).click();
		
	  	ProductImg.clickDeleteButton();
	  	WebDriver_Utilities wlib = new WebDriver_Utilities();
		//driver.switchTo().alert().accept();
		wlib.alertAccept(driver);
		/*List<WebElement> prdData = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr//td[3])[position()>1]"));
		
	boolean flag=false;
	for (WebElement prd : prdData)
	{
		String actPrd = prd.getText();
		if(actPrd.contains(ProductName))
		{
			flag=true;
			break;
		}
	}
	if(flag)
	{
		System.out.println("Product Name is Deleted");
	}
	else
	{
		System.out.println("Product Name is not Deleted");
	}*/	
		ProductImg.validatePrdDeleted(driver, ProductName);
		
	}
	@Test
	public void createProductTest() throws Throwable 
	{

//Login to vtiger application->click on product link->click on create product lookup image->
//Enter product name->click on save Btn->verify whether the product is created in product Information page 
//and Logout from the application.	

		
		
//		driver.findElement(By.linkText("Products")).click();
		HomePage home = new HomePage(driver);
		home.clickProductLink();
		
		// >click on create product lookup image
//		driver.findElement(By.cssSelector("[alt='Create Product...']")).click();

		ProductLooUpImg lookUp = new ProductLooUpImg(driver);
		lookUp.clickPrdLookUp();
		
		Excel_Utility elib = new Excel_Utility();
		String prdName = elib.getExcelData("Product", 0, 0);
		System.out.println("prodname:"+prdName);
//		driver.findElement(http://By.name("productname")).sendKeys(prdName);

		// click on save Btn
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		CreateProductPage prdpage = new CreateProductPage(driver);
		prdpage.enterPrdData(prdName);
		
		Thread.sleep(2000);
		// >verify whether the product is created in product Information page
//		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
//
//		if (actData.equals(prdName)) {
//			System.out.println("Product Name is Created");
//		} else {
//			System.out.println("Product name is not created");
//		}

		ProductValidationPage validate = new ProductValidationPage(driver);
		validate.validateProd(driver, prdName);
		
		// logout from application
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		driver.findElement(By.linkText("Sign Out")).click();
		//home.logoutApp();
	}

}




