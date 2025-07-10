package Generic_Utililities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_Uitility {
	/*
	 * This method is used to read datafrom Properties file(External resource)
	 * @param Key
	 * @return
	 * @throws Throwable
	 * @author pranutha
	 */
	
	public String getKeyAndValue(String Key) throws Throwable
	{
		FileInputStream f = new FileInputStream("./src/test/resources/example1prop.properties");
		Properties prop = new Properties();
		prop.load(f);
		String Value = prop.getProperty(Key);
		return Value;
		
	}
	
	
}
