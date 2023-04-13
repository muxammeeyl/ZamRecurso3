package VTiger.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice 
{
	@Test(dataProvider = "getData")
	public void addToCart(char gender, int Enumber, String Ename, int contactNO)
	{
		System.out.println(gender+" "+Enumber+" "+Ename+" "+contactNO);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][]data=new Object[2][4];
		
		data[0][0]='m';
		data[0][1]=1;
		data[0][2]="John";
		data[0][3]=123;
		
		data[1][0]='f';
		data[1][1]=2;
		data[1][2]="Kendall";
		data[1][3]=245;
		
		return data;
	}
}
