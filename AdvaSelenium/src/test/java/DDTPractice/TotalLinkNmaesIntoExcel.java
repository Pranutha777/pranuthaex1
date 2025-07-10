package DDTPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalLinkNmaesIntoExcel {

	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/Book1.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet s3 = book.getSheet("Sheet3");
		WebDriver driver = new ChromeDriver();
		driver .get("https://www.flipkart.com/");
		List<WebElement>links = driver.findElements(By.xpath("//a"));
		//List<WebElement>links = driver.findElements(By.tagName("a"));
		 int rowCount = s3.getLastRowNum();
        
        
		
		for(int i = 0; i<rowCount;i++)
		{
			
            Row row = s3.getRow(i);
            Cell c =row.getCell(0);
            c.setCellValue(links.get(i).getAttribute("href"));
            //this line is used to fetch data in console
            System.out.println("Link " + links.get(i).getAttribute("href"));
		}
		
		FileOutputStream fout = new FileOutputStream("./src/test/resources/Book1.xlsx");
		book.write(fout);
		book.close();
	}

}
