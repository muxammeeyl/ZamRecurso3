package VTiger.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Vtiger.genericUtilities.BaseClass;

import Vtiger.objectRepository.LoginPage;

public class GetAllWindowNames extends BaseClass
{
	@Test (dataProvider="getData")
	public void testScript1(String username,String pass)
	{
		LoginPage lp=new LoginPage(driver);
		lp.loginIntoApp(username, pass);
	}
	
	@DataProvider
	public Object[][] getData() throws Throwable
	{
		Object[][] data =eUtil.readDataFromExcelToDataProvider("UserName");
		return data;
	}
}
