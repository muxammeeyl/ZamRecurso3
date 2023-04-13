package Vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	//Declaration
	@FindBy (xpath="//a[text()='Organizations']")
	private WebElement OrganizationsLink;
	
	@FindBy (xpath="//a[text()='Contacts']")
	private WebElement ContactsLink;
	
	@FindBy (xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signOutLookUpImg;
	
	@FindBy (linkText = "Sign Out")
	private WebElement signOut;
	
	//Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getOrganizationsLink() {
		return OrganizationsLink;
	}

	public WebElement getContactsLink() {
		return ContactsLink;
	}
	
	public WebElement getSignOutLookUpImg()
	{
		return signOutLookUpImg;
	}
	
	public WebElement getSignOut()
	{
		return signOut;
	}
	
	/**
	 * Business Library
	 */
	
	public void clickOnOrganizationsLink()
	{
		OrganizationsLink.click();
	}
	
	public void clickOnContactssLink()
	{
		getContactsLink().click();
	}

	public void logoutOfApp(WebDriver driver) 
	{
		getSignOutLookUpImg().click();
		getSignOut().click();
	}
	
}
