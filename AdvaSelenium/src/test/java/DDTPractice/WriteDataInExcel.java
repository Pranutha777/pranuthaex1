package DDTPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataInExcel{

	public static void main(String[] args) throws Throwable 
	{
		FileInputStream file = new FileInputStream("./src/test/resources/Book1.xlsx");
		//Keep the worbook/excel file in read mode
		Workbook book = WorkbookFactory.create(file);
		//navigate into mentinoed sheetname
		Sheet s = book.getSheet("Sheet2");
		//navigate into mentinoned rownum
		Row r1 = s.createRow(5);
		Cell c1 =r1.createCell(3);
		Row r2 = s.createRow(6);
		Cell c2 = r2.createCell(4);
		c1.setCellValue("Bhupendra");
		c2.setCellValue("Aruna");
		FileOutputStream fout = new FileOutputStream("./src/test/resources/Book1.xlsx");
		book.write(fout);
		
	}

}
