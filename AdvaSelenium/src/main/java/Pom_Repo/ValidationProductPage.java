package Pom_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ValidationProductPage 
{
	public ValidationProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void ValidateProduct(WebDriver driver,String prodName)
	{
		String actdata = driver.findElement(By.id("mouseArea_Product Name")) .getText();
		Assert.assertEquals(actdata,prodName,"Assert Fail");
		System.out.println("Campign is created");
	}
}
