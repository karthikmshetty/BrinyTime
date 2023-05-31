import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Store_link_to_excel {

	public static void main(String[] args) throws IOException {
		//To get the link from amazon and store it in excel
		System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\eclipse-workspace\\BrinyTime2\\src\\test\\resources\\chromedriver123.exe")	;
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		
		
		Workbook wb = WorkbookFactory.create(new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\BrinyTime2\\src\\test\\resources\\Data\\Excel_data.xlsx"));
		Sheet sheet = wb.getSheet("Sheet1");
		
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		for (int i = 0; i < links.size(); i++) {
			Row row = sheet.createRow(i);
			Cell cell = row.createCell(0);
			cell.setCellValue(links.get(i).getAttribute("href"));
		}
		FileOutputStream fout=new FileOutputStream("C:\\Users\\hp\\eclipse-workspace\\BrinyTime2\\src\\test\\resources\\Data\\Excel_data.xlsx");
		wb.write(fout);
		wb.close();
	}
	}


