package Vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsInfoPage 
{
	//Initialization
	@FindBy (xpath="//span[@class='dvHeaderText']")
	private WebElement OrgHeaderText;
	
	//Initialization
	public OrganizationsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getOrgHeader() 
	{
		return OrgHeaderText;
	}
	
	/**
	 * Business Library
	 */
	/**
	 * This method will return Organizations header text
	 * @return
	 */
	public String getOrganizationsHeader()
	{
		return OrgHeaderText.getText();
	}
}
