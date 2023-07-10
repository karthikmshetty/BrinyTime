package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class A {
	@Test
	public  void main() throws FileNotFoundException, IOException {
		System.out.println("6666");
		new File("");
		System.out.println();
		String s= new File("./src/test/resources/TestData/Testdata_adminPage.xlsx").getAbsolutePath();
		System.out.println(new File("./src/test/resources/TestData/Testdata_adminPage.xlsx").getAbsolutePath() );
		Workbook wb = WorkbookFactory.create(new FileInputStream(s));

		Sheet sheet = wb.getSheet("MapDataProvider");
		int lastRow=sheet.getLastRowNum()+1;
	    int lastCell=sheet.getRow(0).getLastCellNum();
	    System.out.println(sheet.getRow(0).getCell(0).getStringCellValue());
	}

}
