package VTiger.practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_DTT 
{
	public static void main(String[] args) throws Throwable 
	{
		//step 1 load the file in java readable format
		FileInputStream f= new FileInputStream(".\\src\\main\\resources\\ApachePoi.xlsx");
		
		//step 2 create workbook
		Workbook wb=WorkbookFactory.create(f);
		
		//step 3 get control over sheet
		Sheet s=wb.getSheet("Organization");
		
		//step 4 
		Row r=s.getRow(1);
		
		Cell c=r.getCell(2);
		
		String v=c.getStringCellValue();
		System.out.println(v);
		
		
	}
}
