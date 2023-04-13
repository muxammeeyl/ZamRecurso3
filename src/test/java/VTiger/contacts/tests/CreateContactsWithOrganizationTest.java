package VTiger.contacts.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Vtiger.genericUtilities.BaseClass;
import Vtiger.objectRepository.ContactsPage;
import Vtiger.objectRepository.CreateNewContactsPage;
import Vtiger.objectRepository.CreateNewOrganizationsPage;
import Vtiger.objectRepository.HomePage;

@Listeners(Vtiger.genericUtilities.ListenersImplementation.class)
public class CreateContactsWithOrganizationTest extends BaseClass
{
	@Test
	public void test() throws Throwable
	{
		//click on contacts link
		HomePage hp=new HomePage(driver);
		hp.clickOnContactssLink();
		
		//click on create contacts look up image
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateNewContact();
		
		CreateNewContactsPage cncp=new CreateNewContactsPage(driver);
		String LASTNAME=eUtil.readDataFromExcel("Contact", 1, 2);
		String ORGNAME=eUtil.readDataFromExcel("Contact", 4, 3);
		cncp.CreateNewContactWithOranization(driver, LASTNAME, ORGNAME);
		
		//validation
		String CONTACTHEADER=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		Assert.assertTrue(CONTACTHEADER.contains(LASTNAME));
	}
	/*
	 @Test
	
	public void demo()
	{
		System.out.println("demo");
	}
	*/
}
