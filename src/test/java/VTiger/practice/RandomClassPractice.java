package VTiger.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RandomClassPractice 
{
	@Test (invocationCount = 0)
	public void m1()
	{
		String a="abcd";
		System.out.println(a);
		System.out.println(a.toString());
	}
	
	/*@Test (invocationCount = 0)
	public void m2()
	{
		System.out.println("m2");
	}
	
	@Test (invocationCount = 0)
	public void m3()
	{
		System.out.println("m3");
	}
	*/
}
