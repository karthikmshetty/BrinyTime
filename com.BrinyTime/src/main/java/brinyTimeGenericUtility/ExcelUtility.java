package brinyTimeGenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	/**
	 * To write the data into excell
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void insertDataIntoExcel(String sheetname,int rownum,int cellnum,String data) throws EncryptedDocumentException, FileNotFoundException, IOException
	{
		Workbook workbook = WorkbookFactory.create(new FileInputStream(IPathConstant.excelPath));
		Sheet sheet = workbook.getSheet(sheetname);
		Row row=sheet.createRow(rownum);
		Cell cell=row.createCell(cellnum);
		cell.setCellValue(data);
		FileOutputStream out = new FileOutputStream(IPathConstant.excelPath);
		workbook.write(out);
		workbook.close();
			}

	/**
	 * this method returns the excel data
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
public String getExcelData(String sheetName,int rownum,int cellnum) throws EncryptedDocumentException, FileNotFoundException, IOException
{
	Workbook workbook = WorkbookFactory.create(new FileInputStream(IPathConstant.excelPath));
	Sheet sheet = workbook.getSheet(sheetName);
	Row row = sheet.getRow(rownum);
   Cell cell=row.getCell(cellnum);
   DataFormatter dataFormater = new DataFormatter();
   String data=dataFormater.formatCellValue(cell); // or we can use cell.toSring()
   return data;
}
public int getRowNumber(String sheetName) throws EncryptedDocumentException, FileNotFoundException, IOException
{
	Workbook workbook = WorkbookFactory.create(new FileInputStream(IPathConstant.excelPath));
Sheet sheet = workbook.getSheet(sheetName);
int row=sheet.getLastRowNum();
return row;

	
}



//for map data provider
public HashMap<String,String> getMultipleData(String sheetname) throws EncryptedDocumentException, FileNotFoundException, IOException
{
	Workbook wb = WorkbookFactory.create(new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\com.BrinyTime\\src\\test\\resources\\Data\\Testdata_adminPage.xlsx"));
	Sheet sheet = wb.getSheet(sheetname);
	int count=sheet.getLastRowNum();
	
	HashMap<String, String> map = new HashMap<String,String>();
	
	for(int i=0;i<=count;i++)
	{
		String key=sheet.getRow(i).getCell(0).getStringCellValue();
		String value=sheet.getRow(i).getCell(1).getStringCellValue();
		map.put(key, value);
		
	}
	return map;
		
		
		
	}

}


