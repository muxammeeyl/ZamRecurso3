package Vtiger.genericUtilities;

import java.util.Date;
import java.util.Random;

/**
 * This class consist of generic method related to java.
 * @author muzammil m.
 *
 */
public class JavaUtility 
{
	/**
	 * 
	 * @return
	 */
	public int getRandomNumber()
	{
		Random r=new Random();
		int i=r.nextInt(100);
		return i;
	}
	/**
	 * 
	 * @return
	 */
	public String getSystemDate()
	{
		Date d=new Date();
		String date=d.toString();
		return date;
	}
	/**
	 * 
	 * @return
	 */
	public String getSystemDateInFormat()
	{
		Date d=new Date();
		String[] DArr = d.toString().split(" ");
		String date=DArr[2];
		String month=DArr[1];
		String year=DArr[5];
		String time=DArr[3].replace(":", "-");
		String datevalue=date+"-"+month+"-"+year+"-"+time;
		return datevalue;
	}
}
