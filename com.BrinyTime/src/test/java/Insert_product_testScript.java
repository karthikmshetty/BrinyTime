import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.brinyTime.objectRepository.InsertProductPage;
import com.brinyTime.objectRepository.LoginToAdminPage;

import brinyTimeGenericUtility.BaseClass;
import brinyTimeGenericUtility.ExcelUtility;
import brinyTimeGenericUtility.FileUtility;
import brinyTimeGenericUtility.JavaUtility;
import brinyTimeGenericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Insert_product_testScript extends BaseClass{
	@Test
public void insertProduct() throws EncryptedDocumentException, FileNotFoundException, IOException
{
				
				String Category=eu.getExcelData("Sheet1",2,0);
				
				//SUB CATEGORY DRP DOWN
				String subcatogery=eu.getExcelData("Sheet1",2,1);
				String productname = eu.getExcelData("Sheet1",2,3)+ju.getRandomNumber();
				String productcmpnyname = eu.getExcelData("Sheet1",2,4);
				String beforeprice= eu.getExcelData("Sheet1",2,5);
				String afterprice= eu.getExcelData("Sheet1",2,6);
				String productdescription = eu.getExcelData("Sheet1",2,7);
				String shippingCharge = eu.getExcelData("Sheet1",2,8);
				String productAvailability = eu.getExcelData("Sheet1",2,9);
				String Img1 = eu.getExcelData("Sheet1",2,10);
				String Img2 = eu.getExcelData("Sheet1",2,11);
				String Img3 = eu.getExcelData("Sheet1",2,12);
				
				InsertProductPage insertProductPage = new InsertProductPage(driver);
				
				insertProductPage.insertProducts(Category, subcatogery, productname, productcmpnyname, beforeprice, afterprice, productdescription, shippingCharge, productAvailability, Img1, Img2, Img3,driver);
		
	
}

}
