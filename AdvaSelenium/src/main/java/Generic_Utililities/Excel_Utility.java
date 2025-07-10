package Generic_Utililities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	/*
	 * This method is used to read datafrom excel file(External resource)
	 * @param Key
	 * @return
	 * @throws Throwable
	 * @author pranutha
	 */
	
	public String getExcelData(String SheetName,int rowNum,int cellNum) throws Throwable {
		// Enter product name
		FileInputStream fes = new FileInputStream("./src/test/resources/Book1.xlsx");

		// step2:- keeps the workbook/Excel file in read mode
		Workbook book = WorkbookFactory.create(fes);

		// step3:- Navigates into mentioned sheetname
		Sheet sheet = book.getSheet(SheetName);

		// step 4:- Navigates into mentioned rowNum
		Row row = sheet.getRow(rowNum);

		// step 5:- Navigates into mentioned cellNum
		Cell cell = row.getCell(cellNum);

		// step6:- fetch the cell value
//DataFormatter formatter = new DataFormatter();
//formatter.
		String excelData = cell.getStringCellValue();
		System.out.println(excelData);
		return excelData;
	}
	
	
	
	public String getExcelDataUsingFormatter(String SheetName,int rowNum,int cellNum) throws Throwable
	{
		
		// Enter product name
				FileInputStream fes = new FileInputStream("./src/test/resources/Book1.xlsx");

				// step2:- keeps the workbook/Excel file in read mode
				Workbook book = WorkbookFactory.create(fes);

				// step3:- Navigates into mentioned sheetname
				Sheet sheet = book.getSheet(SheetName);

				// step 4:- Navigates into mentioned rowNum
				Row row = sheet.getRow(rowNum);

				// step 5:- Navigates into mentioned cellNum
				Cell cell = row.getCell(cellNum);
				
				DataFormatter format = new DataFormatter();
				String excelData = format.formatCellValue(cell);
				
				return excelData;

		
	}
	
	public  Object[][] readDataUsingDAtaProvider(String SheetName) throws Throwable
	{
		
		FileInputStream fes = new FileInputStream("./src/test/resources/Book1.xlsx");

		// step2:- keeps the workbook/Excel file in read mode
		Workbook book = WorkbookFactory.create(fes);

		// step3:- Navigates into mentioned sheetname
		Sheet sheet = book.getSheet(SheetName);
		
		int lastRow = sheet.getLastRowNum()+1;
		
		int lastCell = sheet.getRow(0).getLastCellNum();
		
		Object[][] objArr = new Object[lastRow][lastCell];
		
		for(int i=0;i<lastRow;i++)
		{
			for (int j = 0; j < lastCell; j++)
			{
				objArr[i][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		
		return objArr;
		
	}
	
}
 
