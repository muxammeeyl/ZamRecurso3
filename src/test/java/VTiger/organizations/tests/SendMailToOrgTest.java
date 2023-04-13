package VTiger.organizations.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Vtiger.genericUtilities.BaseClass;
import Vtiger.objectRepository.HomePage;
import Vtiger.objectRepository.OrganizationsPage;

@Listeners (Vtiger.genericUtilities.ListenersImplementation.class)
public class SendMailToOrgTest extends BaseClass
{
	@Test
	public void test()
	{
		//click on organizations link
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganizationsLink();
		
		//send email
		OrganizationsPage op=new OrganizationsPage(driver);
		op.sendMailToOrg(driver);
	}
}
