import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Fetch_link_to_excel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		// To retrieve the stored link from excel
		System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\eclipse-workspace\\BrinyTime2\\src\\test\\resources\\chromedriver123.exe")	;

		WebDriver driver=new ChromeDriver();
		FileInputStream fis=new FileInputStream("C:\\\\Users\\\\hp\\\\eclipse-workspace\\\\BrinyTime2\\\\src\\\\test\\\\resources\\\\Data\\\\Excel_data.xlsx");
	    Workbook wb = WorkbookFactory.create(fis);
	    Sheet sheet = wb.getSheet("Sheet1");
	    for (int i = 0; i < sheet.getLastRowNum(); i++) {
			  System.out.println(sheet.getRow(i).getCell(0).toString());
		}

	}

}
