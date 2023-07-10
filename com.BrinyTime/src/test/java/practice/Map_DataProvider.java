package practice;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Map_DataProvider {
	
	@Test(dataProvider = "testData")
	public void getData(HashMap<Object,Object> data)
	{
		
		System.out.println(data.get("UserName")+" "+data.get("LastName")+(" ")+data.get("Password"));

	}
	@DataProvider(name="testData")
	public Object[][] main() throws Throwable {
		
		FileInputStream fileInputStream = new FileInputStream(".\\src\\test\\resources\\TestData\\Map_TestData.xlsx");
	    
		Workbook wb = WorkbookFactory.create(fileInputStream);
		Sheet sheet = wb.getSheet("TestData");
		int lastRowNum = sheet.getLastRowNum();
		short lastCellNum = sheet.getRow(0).getLastCellNum();

		Object[][] obj = new Object[lastRowNum][1];
		for (int i = 1; i <=lastRowNum; i++)
		
		{
			HashMap<Object, Object> hashMap = new HashMap<Object,Object>();
			for (int j = 0; j <lastCellNum; j++)
			{
				
				String key= sheet.getRow(0).getCell(j).toString();
				//DataFormatter dataFormatter = new DataFormatter();
				String value = sheet.getRow(i).getCell(j).toString();
				hashMap.put(key, value);
				
			}
			obj[i-1][0]=hashMap;				
		}	
		return obj;
	}	
}
