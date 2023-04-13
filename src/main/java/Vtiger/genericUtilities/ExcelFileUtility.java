package Vtiger.genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class consist of generic methods related to excel sheet
 * @author Muzammil m.
 *
 */
public class ExcelFileUtility 
{	
	/**
	 * This method will read data from excel sheet
	 * @param sheet
	 * @param r
	 * @param c
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromExcel(String sheet, int r, int c) throws Throwable
	{
		FileInputStream fx=new FileInputStream(IConstantUtility.excelFilePath);
		String value = WorkbookFactory.create(fx).getSheet(sheet).getRow(r).getCell(c).getStringCellValue();
	    
		return value;
	}
	
	public Object[][] readDataFromExcelToDataProvider(String SheetName) throws Throwable
	{
		FileInputStream f=new FileInputStream(IConstantUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(f);
		Sheet s = wb.getSheet(SheetName);
		int LastRow = s.getLastRowNum();
		int LastCell = s.getRow(0).getLastCellNum();
		
		Object[][]data=new Object[LastRow][LastCell];
		
		for(int i=0;i<LastRow;i++)
		{
			for(int j=0;j<LastCell;j++)
			{
				data[i][j]=s.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		
		return data;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
