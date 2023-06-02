import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.brinyTime.objectRepository.CategoryPage;
import com.brinyTime.objectRepository.Log_Out_Admin;
import com.brinyTime.objectRepository.LoginToAdminPage;

import brinyTimeGenericUtility.BaseClass;
import brinyTimeGenericUtility.ExcelUtility;
import brinyTimeGenericUtility.FileUtility;
import brinyTimeGenericUtility.JavaUtility;
import brinyTimeGenericUtility.WebDriverUtility;

public class Create_Category_Script extends BaseClass {
	//Debasis is a Master : Pull
	//Debasis is a master : Push
	// practicing push
	@Test
	public void createCategory() throws Throwable
	{
			
			String categoryName=eu.getExcelData("Sheet1",3,0)+ju.getRandomNumber();
			String categoryDescription=eu.getExcelData("Sheet1",3,7);

			
			CategoryPage categoryPage = new CategoryPage(driver);
			
			categoryPage.createCategory(categoryName, categoryDescription, driver);
			
	
	}
}
