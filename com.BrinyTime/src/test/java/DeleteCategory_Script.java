import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.brinyTime.objectRepository.CategoryPage;
import com.brinyTime.objectRepository.LoginToAdminPage;

import brinyTimeGenericUtility.BaseClass;
import brinyTimeGenericUtility.ExcelUtility;
import brinyTimeGenericUtility.FileUtility;
import brinyTimeGenericUtility.JavaUtility;
import brinyTimeGenericUtility.WebDriverUtility;

public class DeleteCategory_Script extends BaseClass {
@Test
public void deleteCategory() throws Throwable
{
			String categoryName=eu.getExcelData("Sheet1",3,0)+ju.getRandomNumber();
			String categoryDescription=eu.getExcelData("Sheet1",3,7);
			
			CategoryPage categoryPage = new CategoryPage(driver);
			categoryPage.createCategory(categoryName, categoryDescription, driver);
			Thread.sleep(3000);
  driver.findElement(By.xpath("//tbody[@aria-live=\"polite\"]/tr/td[text()='"+categoryName+"']//../descendant::i[@class=\"icon-remove-sign\"]")).click();
	wu.switchToAlertPopupAndAccept(driver);	
	
  categoryPage.deleteCategory();
  
			
			
			
			
			
	}

}
