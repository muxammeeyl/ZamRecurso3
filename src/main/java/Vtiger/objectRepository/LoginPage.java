package Vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement submitBtn;
	
	public void enterUsername(String username)
	{
		usernameEdt.sendKeys(username);
	}
	public void enterPassword(String password)
	{
		passwordEdt.sendKeys(password);
	}
	public void clickSubmitBtn()
	{
		submitBtn.click();
	}

	/**
	 * Business Library
	 */
	
	/**
	 * This method will perform login operation
	 * @param USERNAME
	 * @param PASSWORD
	 */
	public void loginIntoApp(String USERNAME, String PASSWORD)
	{
		enterUsername(USERNAME);
		enterPassword(PASSWORD);
		clickSubmitBtn();
	}
	
	
	
	
	
	
	
	
	
	
	
}
