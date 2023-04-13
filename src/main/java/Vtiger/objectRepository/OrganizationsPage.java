package Vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.genericUtilities.WebDriverUtility;

public class OrganizationsPage extends WebDriverUtility
{
	//declaration
	@FindBy (xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOrgLookUpImg;
	
	@FindBy (xpath="//input[@name='selected_id']")
	private WebElement selectRadioBtn;
	
	@FindBy (xpath="//input[@value='Send Mail']")
	private WebElement sendEmailBtn;
	
	@FindBy (xpath="//input[@class='crmbutton small create' and @value=' Select ']")
	private WebElement selectBtn;
	
	@FindBy (xpath="//input[@id='subject']")
	private WebElement subjectEdt;
	
	@FindBy (xpath="//input[@name='Send']")
	private WebElement sendEBtn;
	
	@FindBy (xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveEmailBtn;
	
	//initialization
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getCreateOrgLookUpImg() 
	{
		return createOrgLookUpImg;
	}
	public WebElement getSelectRadioBtn() {
		return selectRadioBtn;
	}

	public WebElement getSendEmailBtn() {
		return sendEmailBtn;
	}
	
	public WebElement getSelectBtn() {
		return selectBtn;
	}

	public WebElement getSubjectEdt() {
		return subjectEdt;
	}
	
	public WebElement getSendEBtn() {
		return sendEBtn;
	}

	/**
	 * Business Library
	 */
	/**
	 * This method will perform click action on create organization look up image
	 */
	public void clickOnCreateOrgLookUpImg()
	{
		getCreateOrgLookUpImg().click();
	}

	public void sendMailToOrg(WebDriver driver)
	{
		waitForPageLoad(driver);
		getSelectRadioBtn().click();
		getSendEmailBtn().click();
		waitForPageLoad(driver);
		getSelectBtn().click();
		waitForPageLoad(driver);
		switchToWindow(driver, "Emails");
		getSubjectEdt().sendKeys("How are you?");
		saveEmailBtn.click();
		//getSendEBtn().click();
		switchToWindow(driver, "Accounts");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
