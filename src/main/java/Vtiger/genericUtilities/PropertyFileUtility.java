package Vtiger.genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/*
 * This class consist of generic methods related to property file 
 * author Muzammil M.
 * */

public class PropertyFileUtility 
{
	static final String s=";";

	/*
	 * This method will read data from property file
	 * @param key
	 * @return
	 * @throws IOException
	 * */
	public String readDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fp=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p= new Properties();
		p.load(fp);
		String value=p.getProperty(key);
		return value;
	}
}
