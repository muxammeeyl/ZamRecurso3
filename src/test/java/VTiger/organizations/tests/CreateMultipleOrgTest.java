package VTiger.organizations.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
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
public class CreateMultipleOrgTest extends BaseClass
{
	ExcelFileUtility eUtil=new ExcelFileUtility();
	JavaUtility jUtil=new JavaUtility();
	
	@Test(dataProvider = "getData")
	public void createOrgTest(String ORGNAME,String INDUSRTY) throws Throwable
	{	
		
		//step 3: launch the browser
		
		
		
		//step 4: Login to app
		
		//step 5: navigate to organization link
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganizationsLink();
		
		//step 6: click on create organization look up image
		OrganizationsPage op=new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();

		// Step 7: Create organization with mandatory Fields
		CreateNewOrganizationsPage cnop = new CreateNewOrganizationsPage(driver);
		cnop.createOrganization(ORGNAME, INDUSRTY);

		// Step 8: Validate for Organization
		OrganizationsInfoPage oip = new OrganizationsInfoPage(driver);
		String OrgHeader = oip.getOrganizationsHeader();
		
		Assert.assertTrue(OrgHeader.contains(ORGNAME));
		
		
	}
	
	@DataProvider
	public Object[][] getData() throws Throwable
	{
		Object[][]data=eUtil.readDataFromExcelToDataProvider("DataProvider1");
		return data;
	}
}
