package VTiger.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario3 
{
	@Test
	public void m1() throws Throwable
	{
		//FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\ApachePoi.xlsx");
		//Workbook wb = WorkbookFactory.create(fi);
		//String oname = wb.getSheet("Organization").getRow(1).getCell(2).getStringCellValue();
		
		//Random r=new Random();
		//int i=r.nextInt(1000);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888");
		/*driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("accountname")).sendKeys(oname+i);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String a=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(oname.contains(a))
		{
			System.out.println("----pass----");
		}
		else
		{
			System.out.println("----fail----");
		}
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("lastname")).sendKeys("muza");
		driver.findElement(By.xpath("//input[@name='account_name']/follwing-sibling::img[@alt='Select']")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.switchTo().window("Accounts");
		driver.findElement(By.name("search_text")).sendKeys(a);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(a)).click();
		driver.switchTo().window("Contacts");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		*/
	}
}
