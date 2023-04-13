package Vtiger.genericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import Vtiger.objectRepository.HomePage;
import Vtiger.objectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	
	public ExcelFileUtility eUtil=new ExcelFileUtility();
	public JavaUtility jUtil=new JavaUtility();
	public PropertyFileUtility pUtil=new PropertyFileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public WebDriver driver=null;
	public static WebDriver sDriver;
	
	@BeforeSuite
	public void bsConfig()
	{
		Reporter.log("====Database Connected====",true);
	}
	
	
	@BeforeClass (groups={"SmokeSuite","RegressionSuite"})
	public void bcConfig() throws Throwable
	{
		//Step 2: Read all the required Data
		String BROWSER=pUtil.readDataFromPropertyFile("browser");
		String URL=pUtil.readDataFromPropertyFile("url");
		Reporter.log("====URL copied====");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			Reporter.log("Chrome launched",true);
			System.out.println("chrome launched");
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			Reporter.log("firefox launched",true);
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			Reporter.log("edge launched",true);
		}
		sDriver=driver;
		
		wUtil.waitForPageLoad(driver);
		
		driver.get(URL);
		wUtil.waitForPageLoad(driver);
		
		Reporter.log("Browser launched ",true);

	}
	
	@BeforeMethod  (groups={"SmokeSuite","RegressionSuite"})
	public void bmConfig() throws Throwable
	{
		String USERNAME=pUtil.readDataFromPropertyFile("username");
		String PASSWORD=pUtil.readDataFromPropertyFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginIntoApp(USERNAME, PASSWORD);
		Reporter.log("====login to app successful====",true);
	}
	
	@AfterMethod  (groups={"SmokeSuite","RegressionSuite"})
	public void amConfig()
	{
		HomePage hp=new HomePage(driver);
		hp.logoutOfApp(driver);
		System.out.println("----LogOut of app Successful----");
	}
	
	
	//@AfterTest
	@AfterClass  (groups={"SmokeSuite","RegressionSuite"})
	public void acConfig()
	{
		driver.close();
		System.out.println("----Browser Closed Successfully----");
	}
	
	@AfterSuite (groups = {"SmokeSuite","RegressionSuit"})
	public void asConfig()
	{
		System.out.println("----DataBase Disconnected----");
	}
}
