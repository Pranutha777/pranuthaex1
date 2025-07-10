package Organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;

import Generic_Utililities.BaseClass;
import Generic_Utililities.Excel_Utility;
import Generic_Utililities.File_Uitility;
import Generic_Utililities.File_Utility;
import Generic_Utililities.Java_Utility;
import Generic_Utililities.WebDriver_Utilities;
import Pom_Repo.HomePage;
import Pom_Repo.LoginPage;
import Pom_Repo.OrganizationCreatePage;
import Pom_Repo.OrganizationLookUpImg;
import Pom_Repo.ValidateOrgPage;
@Test
public class OrganisationcreateTest extends BaseClass{

	
	//Login to vtiger application
	//->click on organizations link
	//->click on create organization lookup image
	//->Enter organisation name,phone number and email
	//->click on save Btn
	//->verify whether the organization is created in Organization Information page and Logout from the application. 
	
	public void organisationcreateTest()  throws Throwable 
	{
			
		HomePage home = new HomePage(driver);
		home.clickOrgLink();

						
//		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		 
		OrganizationLookUpImg lookUpOrg = new OrganizationLookUpImg(driver);
		lookUpOrg.clickPrdLookUp();
		
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandamNum();

		Excel_Utility elib = new Excel_Utility();
		String OrgName = elib.getExcelData("Organization", 0, 1) + ranNum;

	//	driver.findElement(http://By.name("accountname")).sendKeys(OrgName);
//---------------------------------------------------------------------------------------------------------------------------------------

		String PhnNum = elib.getExcelDataUsingFormatter("Organization", 1, 1);
//		driver.findElement(http://By.name("phone")).sendKeys(PhnNum);
//----------------------------------------------------------------------------------------------------------------------------------				

		String mailId = elib.getExcelDataUsingFormatter("Organization", 2, 1);
	//	driver.findElement(http://By.id("email1")).sendKeys(mailId);

	//	driver.findElement(By.cssSelector("[title='Save [Alt+S]']")).click();
		
		OrganizationCreatePage orgPage = new OrganizationCreatePage(driver);
		orgPage.enterOrgnaizationData(OrgName, PhnNum, mailId);
//---------------------------------------------------------------------------------------------------------------------------------------
//		String actdata = driver.findElement(http://By.id("dtlview_Organization Name")).getText();
//		if (actdata.contains(OrgName)) {
//			System.out.println("Organization Name is Created");
//		} else {
//
//			System.out.println("Organization Name is not Created");
//		}

		ValidateOrgPage validate = new ValidateOrgPage(driver);
		validate.validateOrg(driver, OrgName);
		
		// logout from application
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		driver.findElement(By.linkText("Sign Out")).click();
		//home.logoutApp();
	}

}