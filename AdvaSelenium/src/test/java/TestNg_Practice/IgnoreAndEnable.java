package TestNg_Practice;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class IgnoreAndEnable 
{
	@Ignore
	@Test(priority = -5)
	public void CreateProduct()
	{
		System.out.println("Product is created");
	}
	//we can use Ignore or enabled =false to skip test method
	@Test(enabled = false)
	public void ModifyProduct()
	{
		System.out.println("Product is modified");
	}
	@Test(priority = 0)
	public void DeleteProduct()
	{
		System.out.println("Product is deleted");
	}

	
	

}
