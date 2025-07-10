package TestNg_Practice;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class DependsOnMethodExample
{
	
	@Test
	public void CreateProduct()
	{
		System.out.println("Product is created");
	}
	//we can use Ignore or enabled =false to skip test method
	@Test(dependsOnMethods = "CreateProduct")
	public void ModifyProduct()
	{
		System.out.println("Product is modified");
	}
	@Test(dependsOnMethods = "CreateProduct")
	public void DeleteProduct()
	{
		System.out.println("Product is deleted");
	}

}
