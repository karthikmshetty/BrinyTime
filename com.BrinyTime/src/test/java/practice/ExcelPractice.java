package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelPractice {
public static void main(String[] args) throws EncryptedDocumentException, FileNotFoundException, IOException {
Workbook wb=WorkbookFactory.create(new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\com.BrinyTime\\src\\test\\resources\\TestData\\Testdata_adminPage.xlsx"));
	
	Sheet sheet=wb.getSheet("DataProvider");
	int lastRow=sheet.getLastRowNum()+1;
	int lastCell=sheet.getRow(0).getLastCellNum();
	
	System.out.println(lastRow);
	System.out.println(lastCell);
	
}
}
