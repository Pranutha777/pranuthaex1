package TestNg_Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample
{
	@Test(dataProvider ="getData")
	public void getDataFromDataProvider(String src,String Desc,int TotalPeople)
	{
		System.out.println("Book ticket from "+src+" to "+Desc+"And Total no of Pepole"+TotalPeople);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr = new Object[3][3];
		objArr[0][0] ="Nellore";
		objArr[0][1]="singpore";
		objArr[0][2]= 45;
		
		objArr[1][0]="Nellore";
		objArr[1][1]="Bankok";
		objArr[1][2]=85;
		
		objArr[2][0]="Nellore";
		objArr[2][1]="mysore";
		objArr[2][2]=52;
		
		return objArr;
		
	}
}
