package TestNg_Practice;

import static org.testng.Assert.assertNotNull;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertEx {

	@Test
	public void m1()
	{
		System.out.println("step1");
		System.out.println("step2");
		Assert.assertEquals("A","B");
		System.out.println("step3");
		System.out.println("step4");
	}
	@Test
	public void m2()
	{
		System.out.println("PEAVDFD");
		System.out.println("DGDGD");
		Assert.assertEquals("A","B");
	}
	@Test
	public void m3()
	{
		String expData ="dfdfd";
		String actData ="ddeee";
		Assert.assertTrue(actData.equals(expData),"Assert fail");
		System.out.println("aseert pass");
	}
	
	@Test
	public void m4()
	{
		String expData ="pranutha";
		String actData ="pranutha";
		Assert.assertTrue(actData.equals(expData),"Assert fail");
		System.out.println("aseert pass");
	}
	
	@Test
	public void m5()
	{
		String expData ="pranutha";
		String actData ="pranuthajjhj ";
		Assert.assertFalse(actData.equals(expData),"Assert fail");
		System.out.println("aseert pass");
	}
	
	@Test
	public void m6()
	{
		String expData ="pranutha";
		String actData ="pranutha";
		Assert.assertFalse(actData.equals(expData),"Assert fail");
		System.out.println("aseert pass");
	}
	
	@Test
	public void m7()
	{
		String p = null;
		//String actData ="pranutha";
		Assert.assertNull(p,"Assert fail");
		System.out.println("aseert pass");
	}
	
	@Test
	public void m8()
	{
		String p ="pranutha";
		Assert.assertNull(p,"Assert fail");
		System.out.println("aseert pass");
	}
	
	@Test
	public void m9()
	{
		String p ="pranutha";
		assertNotNull(p,"Assert fail");
		System.out.println("aseert pass");
	}
	@Test
	public void m10()
	{
		String p ="";
		assertNotNull(p,"Assert fail");
		System.out.println("aseert pass");
	}
	
	@Test
	public void m11()
	{
		String p ="fdfdfdf";
		String c ="dfdfd";
		Assert.assertSame(p,c,"Assert fail");
		System.out.println("aseert pass");
	}
	
	@Test
	public void m12()
	{
		String p ="fdfdfdf";
		String c ="dfdfd";
		Assert.assertNotSame(p,c,"Assert fail");
		System.out.println("aseert pass");
	}
	
	
}

