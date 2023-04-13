package VTiger.organizations.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Vtiger.genericUtilities.BaseClass;
import Vtiger.genericUtilities.ExcelFileUtility;
import Vtiger.genericUtilities.JavaUtility;
import Vtiger.genericUtilities.PropertyFileUtility;
import Vtiger.genericUtilities.WebDriverUtility;
import Vtiger.objectRepository.CreateNewOrganizationsPage;
import Vtiger.objectRepository.HomePage;
import Vtiger.objectRepository.LoginPage;
import Vtiger.objectRepository.OrganizationsInfoPage;
import Vtiger.objectRepository.OrganizationsPage;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(Vtiger.genericUtilities.ListenersImplementation.class)
public class CreateOrganizationTest extends BaseClass
{
	@Test //(groups = "SmokeSuite")
	public void test() throws Throwable 
	{	
		
		//Step 5: Navigate to Organizations link
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganizationsLink();
		
		
		//Step 6: Click on Create Organization Look up Image
		OrganizationsPage op=new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();
		
		//Step 7: Create organization with mandatory Fields
		CreateNewOrganizationsPage cnop=new CreateNewOrganizationsPage(driver);
		String ORGNAME = eUtil.readDataFromExcel("Organization", 1, 2);
		cnop.createOrganization(ORGNAME+jUtil.getRandomNumber());
		
		//Step 8: Save
		
		//Step 9: Validate for Organization
		OrganizationsInfoPage oip=new OrganizationsInfoPage(driver);
		String ORGHEADER=oip.getOrganizationsHeader();
		
		AssertJUnit.assertTrue(ORGHEADER.contains(ORGNAME));
		
		if(ORGHEADER.contains(ORGNAME))
		{
			System.out.println("====PASS====");
		}
		
		//Step 10: Logout of app
		
		
		//Step 11: close the browser
		
	}
}
