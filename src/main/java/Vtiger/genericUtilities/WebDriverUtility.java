package Vtiger.genericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consist of generic methods related to webDriver actions
 * @author muzammil m
 *
 */
public class WebDriverUtility 
{
	/**
	 * this method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * This method will wait for 20 seconds for page load
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	/**
	 * this method will wait until webelement is visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * this method will wait until particular web element is clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * this method will handle dropdown by index
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element, int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * this method will handle dropdown by value
	 * @param element
	 * @param value
	 */
	public void handleDropdown(WebElement element, String value)
	{
		Select s=new Select(element);
		s.selectByValue(value);
	}
	/**
	 * this method will handle dropdown by visible text
	 * @param value
	 * @param element
	 */
	public void handleDropdown(String value,WebElement element)
	{
		Select s=new Select(element);
		s.selectByVisibleText(value);
	}
	/**
	 * this method will right click on page
	 * @param driver
	 */
	public void rightClickOnPage(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	/**
	 * this method will right click on webElement
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).contextClick().perform();
	}
	/**
	 * this method will perform mouse hover action on webElement
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * this method will double click on page
	 * @param driver
	 */
	public void doubleClickOnPage(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	/**
	 * this method will double click on webElement
	 */
	public void doubleClick(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).doubleClick().perform();
	}
	/**
	 * this method will perform drag and drop option
	 * @param driver
	 * @param srcElement
	 * @param destElement
	 */
	public void dragAndDropAction(WebDriver driver, WebElement srcElement, WebElement destElement)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(srcElement, destElement).perform();
	}
	/**
	 * this method will press enter key
	 * @throws AWTException
	 */
	public void pressEnterKey() throws AWTException
	{
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	}
	/**
	 * this method will release enter key
	 * @throws AWTException
	 */
	public void releaseEnterKey() throws AWTException
	{
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	}
	/**
	 * this method will handle frames using index
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * this method will handle frames using name or Id
	 * @param driver
	 * @param nameOrId
	 */
	public void handleFrame(WebDriver driver, String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	/**
	 * this method will handle frames using WebElement 
	 * @param driver
	 * @param element
	 */
	public void handleFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * this method will move to parent frame
	 * @param driver
	 */
	public void handleFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	/**
	 * this method will move to default frame
	 * @param driver
	 */
	public void handleDefaultFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * this method will accept alert pop up
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * this method will dismiss alert pop up
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * this method will capture and return alert text
	 * @param driver
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
		
	}
	/**
	 * this method will take screenshot and save it in screenshot folder
	 * @param driver
	 * @param ScreenShotName
	 * @return
	 * @throws IOException
	 */
	public String takesScreenShot(WebDriver driver, String ScreenShotName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(".\\ScreenShot\\"+ScreenShotName+".png");
		FileUtils.copyFile(src, dest);
		
		return dest.getAbsolutePath(); //used in extent reports
	}
	/**
	 * this method will switch t window based on partial window title
	 * @param driver
	 * @param PartialWinTitle
	 */
	public void switchToWindow(WebDriver driver, String PartialWinTitle)
	{
		//step 1 capture all the window ids
		Set<String> windowIds = driver.getWindowHandles();
		//step 2 use for each loop and navigate to each window
		for(String win: windowIds)
		{
			//step 3 capture the title of each window
			String currentTitle = driver.switchTo().window(win).getTitle();
			
			//step 4 compare current title with partial window title
			if(currentTitle.contains(PartialWinTitle))
			{
				break;
			}
		}
	}
	/**
	 * this method will scroll randomly downwards
	 * @param driver
	 */
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}
	/**
	 * this method will scroll downwards till particular WebElement
	 * @param driver
	 * @param ele
	 */
	public void scrollAction(WebDriver driver,WebElement ele)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int y=ele.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", ele);
	}
}
