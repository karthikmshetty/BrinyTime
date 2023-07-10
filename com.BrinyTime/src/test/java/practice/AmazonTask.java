package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AmazonTask {
	
	@Test
	public void m1() throws EncryptedDocumentException, FileNotFoundException, IOException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 13");
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		List<WebElement> list = driver.findElements(By.xpath("//span[contains(text(),'iPhone 13')]/ancestor::div/descendant::span[@class='a-price-whole']"));
		
		Workbook wb = WorkbookFactory.create(new FileInputStream("./src/test/resources/TestData/Excel_data.xlsx"));
		Sheet sheet = wb.getSheet("Sheet2");
		int i=0;
		for(WebElement we:list)
		{
			String price=we.getText();
			
			sheet.createRow(i++).createCell(0).setCellValue(price);
		}
		
		FileOutputStream out = new FileOutputStream("./src/test/resources/TestData/Excel_data.xlsx");
		wb.write(out);
		
		
		
	}
	

}
