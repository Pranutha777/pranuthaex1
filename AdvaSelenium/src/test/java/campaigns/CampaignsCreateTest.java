package campaigns;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

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
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utililities.BaseClass;
import Generic_Utililities.Excel_Utility;
import Generic_Utililities.File_Uitility;
import Generic_Utililities.Java_Utility;
import Generic_Utililities.WebDriver_Utilities;
import Pom_Repo.CampLookUpImgPage;
import Pom_Repo.CreateCampaignPAge;
import Pom_Repo.CreateProductPage;
import Pom_Repo.HomePage;
import Pom_Repo.LoginPage;
import Pom_Repo.ProductLooUpImg;
import Pom_Repo.ValidationCampaignPage;
import Pom_Repo.WindowSwitchingPage;

//@Listeners(Generic_Utililities.ListenerImp.class)
@Listeners(Generic_Utililities.ExtentReportImp.class)
public class CampaignsCreateTest extends BaseClass {
//if we are give retryAnalyzer we should not give Test and retryanalzer should be given in test only
	@Test(retryAnalyzer = Generic_Utililities.RetryAnalayserImp.class)
	public void createCampaignsTest() throws Throwable {

		// Login to vtiger application->mouseOverOn more Link->click on campaigns->
		// click on create campaign lookup image->Enter campaignName->
		// click on save Btn->verify whether the campaign is created in campaign
		// Information page
		// and Logout from the application.

		HomePage home = new HomePage(driver);
		home.clickCampaignsLink();

		CampLookUpImgPage campLookUp = new CampLookUpImgPage(driver);
		campLookUp.clickLookUpImg();

		Excel_Utility elib = new Excel_Utility();
		String campName = elib.getExcelData("Campaigns", 0, 0);

		CreateCampaignPAge campPage = new CreateCampaignPAge(driver);
		campPage.enterCampNAme(campName);
		campPage.clickSaveButton();

		ValidationCampaignPage validate = new ValidationCampaignPage(driver);
		validate.validateCamp(driver, campName);
	

	}
	
	@Test
	public void createCampaignWithProductTest() throws Throwable {

		
		
		HomePage home = new HomePage(driver);
		home.clickProductLink();

		ProductLooUpImg lookUp = new ProductLooUpImg(driver);
		lookUp.clickPrdLookUp();


		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandamNum();
	
		Excel_Utility elib = new Excel_Utility();
		String prdName = elib.getExcelData("Product", 0, 0) + ranNum;
		System.out.println(prdName);

		
		CreateProductPage prdPage = new CreateProductPage(driver);
		prdPage.enterPrdData(prdName);

		// ----------------------------------------------------------------------------------------------------------------

		home.clickCampaignsLink();

		CampLookUpImgPage img = new CampLookUpImgPage(driver);
		img.clickLookUpImg();

		String campName = elib.getExcelData("Campaigns", 0, 0) + ranNum;
		System.out.println(campName);

		CreateCampaignPAge campPage = new CreateCampaignPAge(driver);
		campPage.enterCampNAme(campName);

		WindowSwitchingPage winSwitch = new WindowSwitchingPage(driver);

		winSwitch.clickPrdLookUpImgInCamp();
		WebDriver_Utilities wlib = new WebDriver_Utilities();
		wlib.windowSwitching(driver, "Products&action");

		winSwitch.enterPrdDetails(prdName);

		// Dynamic xpath
		winSwitch.enterPrdNameInCamp(driver, prdName);

		wlib.windowSwitching(driver, "Campaigns&action");

		campPage.clickSaveButton();

		ValidationCampaignPage validate = new ValidationCampaignPage(driver);
		validate.validateCamp(driver, campName);
		validate.validateProduct(driver, prdName);

	}


}
 