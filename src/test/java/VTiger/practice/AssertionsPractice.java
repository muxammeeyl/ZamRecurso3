package VTiger.practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice 
{
	@Test
	public void practice()
	{
		System.out.println("step 1");
		
		Assert.assertTrue(false);
		
		System.out.println("step 2");
		System.out.println("step 3");
		System.out.println("step 4");
	}
	
	@Test
	public void practice1()
	{ 
		SoftAssert sa=new SoftAssert();
		
		System.out.println("practice step 1");
		sa.assertEquals(false, false);
		System.out.println("practice step 2");
		sa.assertTrue(false);
		System.out.println("practice step 3");
		

		System.out.println("practice step 4");
		sa.assertAll();
		
		Assert.assertTrue(false);
	}
}
