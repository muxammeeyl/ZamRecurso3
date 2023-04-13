package VTiger.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataInExcel
{
	public static void main(String[] args) throws Throwable 
	{
		FileInputStream f=new FileInputStream(".\\src\\main\\resources\\ApachePoi.xlsx");
		
		Workbook w = WorkbookFactory.create(f);
		
		Sheet s = w.getSheet("Organization");
		
		Row r = s.getRow(1);
		
		Cell c = r.createCell(7);
		
		c.setCellValue("muzammil");
		
		FileOutputStream fo=new FileOutputStream(".\\src\\main\\resources\\ApachePoi.xlsx");
		w.write(fo);
		System.out.println("data printed");
		w.close(); 
	}
}
