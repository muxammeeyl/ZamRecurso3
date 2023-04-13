package Vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.genericUtilities.WebDriverUtility;

public class CreateNewOrganizationsPage extends WebDriverUtility
{
	//declaration
	@FindBy (name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy (name="industry")
	private WebElement industryDropdown;
	
	@FindBy (xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//initialization
	public CreateNewOrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}
	/**
	 * Business Library
	 */
	
	/**
	 * This method will perform create Organization operation with Organization name
	 * @param ORGNAME
	 */
	public void createOrganization(String ORGNAME)
	{
		orgNameEdt.sendKeys(ORGNAME);
		saveBtn.click();
	}
	
	/**
	 * This method will perform create organization with Organization name & Industry name
	 * @param ORGNAME
	 * @param INDUSTRY
	 */
	public void createOrganization(String ORGNAME, String INDUSTRY)
	{
		orgNameEdt.sendKeys(ORGNAME);
		handleDropdown(INDUSTRY, industryDropdown);
		saveBtn.click();
	}
	
}
