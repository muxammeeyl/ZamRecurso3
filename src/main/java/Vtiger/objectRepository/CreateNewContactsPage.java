package Vtiger.objectRepository;

import javax.management.loading.PrivateClassLoader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.genericUtilities.WebDriverUtility;

public class CreateNewContactsPage extends WebDriverUtility
{
	//Declaration
	@FindBy (name="lastname")
	private WebElement LastNameEdt;
	
	@FindBy (xpath="//input[@name='account_name']/following-sibling::img[@src='themes/softed/images/select.gif']")
	private WebElement OrgNameLookUpImg;
	
	@FindBy (xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	@FindBy (name="search_text")
	private WebElement SearchTextEdt;
	
	@FindBy (name="search")
	private WebElement SearchBtn;
	
	//Initialization
	public CreateNewContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}

	public WebElement getOrgNameLookUpImg() {
		return OrgNameLookUpImg;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	/**
	 * Business Library
	 */
	
	/**
	 * This method will perform create contact operation
	 * @param driver
	 * @param LASTNAME
	 * @param ORGNAME
	 */
	public void CreateNewContactWithOranization(WebDriver driver, String LASTNAME, String ORGNAME)
	{
		LastNameEdt.sendKeys(LASTNAME);
		OrgNameLookUpImg.click();
		switchToWindow(driver, "Accounts");
		waitForPageLoad(driver);
		SearchTextEdt.sendKeys(ORGNAME);
		SearchBtn.click();
		WebElement ele=driver.findElement(By.xpath("//a[text()="+ORGNAME+"]"));
		doubleClick(driver, ele);
		waitForPageLoad(driver);
		switchToWindow(driver, "Contacts");
		SaveBtn.click();
		
	}
	
	
	
	
	
	
	
	
	
	
}
