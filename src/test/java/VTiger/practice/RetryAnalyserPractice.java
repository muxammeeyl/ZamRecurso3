package VTiger.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractice 
{
	
	@Test (retryAnalyzer = Vtiger.genericUtilities.RetryAnalyserImplementation.class)
	public void sample()
	{
		
		
		Assert.fail();
		
	}
}
