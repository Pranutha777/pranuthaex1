package Generic_Utililities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

public class ListenerImp implements 
{
	public void onTestFailure(ITestResult result)
	{
		TakesScreenshot ts = (TakesScreenshot)BaseClass.sdriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("./FailedScript.png");
		try
		{
			FileUtils.copyFile(src, des);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
}
