package genericActionsLibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFile {
	String filePath = "./TestData/Credentials.xlsx";
	String testData;
	public String readExcelData(int sheetNum, int rowNum, int cellNum)
	{
		try
		{
			FileInputStream fis = new FileInputStream(filePath);
			
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sheet = wb.getSheetAt(sheetNum);
			Row row = sheet.getRow(rowNum);
			testData = row.getCell(cellNum).getStringCellValue();
			wb.close();
		}
		catch(Exception e)
		{
			System.out.println("Error while reading the Excel Data: " +e.getMessage());
		}
		return testData;
	}
	
	public String writeExcelData(int sheetNum, int rowNum, int cellNum, String resultData)
	{
		try
		{
			FileInputStream fis2 = new FileInputStream(filePath);
			Workbook wb2 = WorkbookFactory.create(fis2);
			Sheet sheet2 = wb2.getSheetAt(sheetNum);
			Row row2 = sheet2.getRow(rowNum);
			Cell cell2 = row2.createCell(cellNum);
			FileOutputStream fos = new FileOutputStream(filePath);
			cell2.setCellValue(resultData);	
			wb2.write(fos);
			wb2.close();
		}
		catch(Exception e)
		{
			System.out.println("Error while reading the Excel Data: " +e.getMessage());
		}
		return resultData;
	}

}
