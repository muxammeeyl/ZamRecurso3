package VTiger.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario1 
{
	@Test
	public void m1() throws Throwable 
	{
		FileInputStream f=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(f);
		String browser=p.getProperty("browser");
		String url = p.getProperty("url");
		String un = p.getProperty("username");
		String pswd = p.getProperty("password");
		
		
		Random r=new Random();
		int i=r.nextInt();
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\ApachePoi.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String orgname = wb.getSheet("Organization").getRow(1).getCell(2).getStringCellValue()+i;
		wb.close();
		
		
		
		WebDriver driver=null;
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("----fail----");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pswd);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String mm= driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if (mm.contains("infosis")) 
		{
			System.out.println("----pass----");
		}
		else
		{
			System.out.println("====fail----");
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions ac=new Actions(driver);
		ac.moveToElement(ele).perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		
		
		
		
	
	}
}
