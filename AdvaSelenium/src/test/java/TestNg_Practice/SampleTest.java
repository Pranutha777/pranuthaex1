package TestNg_Practice;

import org.testng.annotations.Test;

public class SampleTest 
{
	@Test(priority = -5)
	public void CreateProduct()
	{
		System.out.println("Product is created");
	}
	@Test(priority = 5)
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
