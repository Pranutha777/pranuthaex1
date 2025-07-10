package Generic_Utililities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriver_Utilities 
{
	/**
	 * This method is used to make window maximize
	 * @param driver
	 
	 */
	public  void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method is used wait for elements to load
	 * @param driver
	 */
	 public void waitElementToLoad(WebDriver driver)
	 {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
	 }
	 /**
	  * This method is used for switching window
	  * @param driver
	  * @param PartialText
	  */
	 public void windowSwitching(WebDriver driver,String PartialText)
	 {
		 Set<String> allwindows = driver.getWindowHandles();
			Iterator<String> it = allwindows.iterator();
				
			while (it.hasNext())
			{
				String win = it.next();
				driver.switchTo().window(win);
				String title = driver.getTitle();
				if (title.contains("Products&action"))
				{
					break;
				}

			}
 
	 }
	 /**
	  * This method is used to switch from window to alert
	  * @param driver
	  * 
	  */
	 public void alertAccept(WebDriver driver)
	 {
		 driver.switchTo().alert().accept();
	 }
	 /**
	  * This method is used to dismiss the alert popup
	  * @param driver
	  */
	 public void alertDismiss(WebDriver driver)
	 {
		 driver.switchTo().alert().dismiss();
	 }
	 /**
	  * used to Switch to Frame Window based on index
	  * @param driver
	  * @param index
	  */
	 public void swithToFrame(WebDriver driver,int index)
	 {
		 driver.switchTo().frame(index);
	 }
	 /**
	  *  used to Switch to Frame Window based on id or name attribute
	  *  @param driver
	  *  @param id_name_attribute
	  */
	 public void swithToFrame(WebDriver driver , String id_name_attribute) 
	 {
		driver.switchTo().frame(id_name_attribute);
	 }
	 
	 /**
	  * used to select the value from the dropDwon  based on index
	  * @param webelement
	  * @param index
	  */
		
	 public void select(WebElement ele,int index)
	 {
		 Select sel = new Select(ele);
		 sel.selectByIndex(index);
	 }
	 
	 /**
	  *  used to select the value from the dropDwon  based on value / option avlaible in GUI
	  *  @param webelemnt
	  *  @param text
	  */
	 public void select(WebElement ele,String text)
	 {
		 Select sel = new Select(ele);
		 sel.selectByValue(text);
	 }
	 
	 /**
	  * used to place mouse cursor on specified element
	  * @param WebDriver
	  * @param WebElement
	  */
	  
	 public void mouseOverOnElement(WebDriver driver,WebElement ele)
	 {
		 Actions act = new Actions(driver);
		 act.moveToElement(ele).perform();
	 }
	 /**
	  *  used to right click  on specified element
	  * @param WebDriver
	  * @param WebElement 
	  */
	 public void rightClickOnElement(WebDriver driver,WebElement ele)
	 {	 
		 Actions act = new Actions(driver);
		 act.contextClick(ele).perform(); 
	 }
	 /**
	  * 
	  * @param driver
	  * @param javaScript
	  */
	public void executeJavaScript(WebDriver driver , String javaScript) 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeAsyncScript(javaScript, null);
	}
	/**
	 * pass enter Key appertain in to Browser
     * @param driver
     */
	public void passEnterKey(WebDriver driver) 
	{
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
    } 
	/**
	 * This method is used to move the cursor to a particular element
	 * @param driver
	 * @param ele
	 */
	public void moveToElement(WebDriver driver,WebElement ele)
	{
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
	}

		 public static String TakeScreenshot(WebDriver driver,String ScreenshotName) throws Throwable
		 {
			 TakesScreenshot ts = (TakesScreenshot) driver;
			 File src = ts.getScreenshotAs(OutputType.FILE);
			 File desc =new File("./ScreenShots"+ScreenshotName+".png");
			 FileUtils.copyFile(src, desc); 
			return desc.getAbsolutePath();
			 
		 }
}
