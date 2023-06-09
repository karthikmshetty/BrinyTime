package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Map_DataProvider {
	
	
	@Test(dataProvider = "multipleData")
public void getData(Map data)
{
	System.out.println(data.get("USERNAME"));
	System.out.println(data.get("PASSWORD"));

}

	
	
@DataProvider
public Map<Object, Object> multipleData() throws Throwable, FileNotFoundException, IOException
{
	Workbook wb = WorkbookFactory.create(new FileInputStream("C:\\Users\\hp\\git\\repository3\\com.BrinyTime\\src\\test\\resources\\TestData\\Testdata_adminPage.xlsx"));

	Sheet sheet = wb.getSheet("MapDataProvider");
	int lastRow=sheet.getLastRowNum()+1;
    int lastCell=sheet.getRow(0).getLastCellNum();
   
    //Object[][] a =new Object[lastRow][lastCell];
    HashMap<Object, Object> map = new HashMap<Object,Object>();
    
    for(int i=1;i<lastRow;i++)   // i=1 bcz heading should not repeat
    {
    	for(int j=0;j<lastCell;j++)
    	{
    		map.put(sheet.getRow(0).getCell(j).toString(),sheet.getRow(i).getCell(j).toString() );
    		
    	}
    	//a[i][0]=map;  //store pair of key and value 
    	
    	
    }
    return map;
	
}

}
