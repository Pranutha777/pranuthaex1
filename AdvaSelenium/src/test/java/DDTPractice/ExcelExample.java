package DDTPractice;

import java.io.FileInputStream;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelExample {

	public static void main(String[] args) throws Throwable 
	{
		FileInputStream file = new FileInputStream("./src/test/resources/Book1.xlsx");
		Workbook  book = WorkbookFactory.create(file);
		Sheet s = book.getSheet("Sheet2");
		Row r = s.getRow(2);
		Cell c =r.getCell(4);
		DataFormatter data = new DataFormatter();
		String cellvalue = data.formatCellValue(c);
		
		System.out.println("cellvale:"+cellvalue);

	}
}