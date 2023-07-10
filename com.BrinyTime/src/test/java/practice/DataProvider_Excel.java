package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import brinyTimeGenericUtility.ExcelUtility;

public class DataProvider_Excel {
	


@DataProvider
public Object[][] data() throws EncryptedDocumentException, FileNotFoundException, IOException
{
Workbook wb=WorkbookFactory.create(new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\com.BrinyTime\\src\\test\\resources\\TestData\\Testdata_adminPage.xlsx"));
	
	Sheet sheet=wb.getSheet("DataProvider");
	int lastRow=sheet.getLastRowNum()+1; //it starts count from 0
	int lastCell=sheet.getRow(0).getLastCellNum(); //it starts count from 1

	Object[][] arr=new Object[lastRow][lastCell]; // while initialising we should give with normal number fromat.so +1 used there.
	
	for(int i=0;i<lastRow;i++) 
	{
		for(int j=0;j<lastCell;j++)
		{
			arr[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			
			
		}
		
		
	}
	
	return arr;
}

@Test(dataProvider = "data")
public void getData(String product,String category,String price)
{
	System.out.println(product+" "+category+" "+price);
	
}
}



