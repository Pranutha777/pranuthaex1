package Campigns;

import java.io.FileInputStream;

import org.testng.annotations.Test;

import Generic_Utililities.BaseClass;
import Generic_Utililities.Excel_Utility;
import Generic_Utililities.Java_Utility;
import Generic_Utililities.WebDriver_Utilities;
import Pom_Repo.CampLookUpImgPage;
import Pom_Repo.ContactLookUpImgPage;
import Pom_Repo.CreateCampaignPAge;
import Pom_Repo.CreateContactPage;
import Pom_Repo.CreateProductPage;
import Pom_Repo.HomePage;
import Pom_Repo.ProductLooUpImg;
import Pom_Repo.ValidateContactPage;
import Pom_Repo.ValidationCampaignPage;
import Pom_Repo.WindowSwitchingPage;
@firstpush
@Test
public class CreateCampaignWithProductTest extends BaseClass
{
	
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
	//@Test
public void createContactTest()  throws Throwable {

		
		HomePage home = new HomePage(driver);
		home.clickContactLink();

		ContactLookUpImgPage lookUp = new ContactLookUpImgPage(driver);
		lookUp.clickLookUp();

		Excel_Utility elib = new Excel_Utility();
		String firstName = elib.getExcelData("Contact", 0, 0);

		CreateContactPage contactPage = new CreateContactPage(driver);
		contactPage.selectDropDown(driver);

		String lastName = elib.getExcelData("Contact", 0, 1);

		contactPage.enterPrdData(firstName,lastName);

		ValidateContactPage validate = new ValidateContactPage(driver);
		validate.validateContactFirstNAme(driver, firstName);
		validate.validateContactlastNAme(driver, lastName);

		//home.logoutApp();

	}
	//@Test
	public void samplemethod()
	{
		System.out.println("inside samplemethod");
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



 
