package brinyTime_tests;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.brinyTime.objectRepository.CategoryPage;

import brinyTimeGenericUtility.BaseClass;
@Listeners(brinyTimeGenericUtility.ListnerImplementClass.class)
public class Create_Category_ScriptTest extends BaseClass {
	
	@Test(groups="smokeTest",retryAnalyzer = brinyTimeGenericUtility.RetryAnalyzerImplementation.class)
	public void createCategory() throws Throwable
	{
			
			String categoryName=eu.getExcelData("Sheet1",3,0)+ju.getRandomNumber();
			String categoryDescription=eu.getExcelData("Sheet1",3,7);

			
			CategoryPage categoryPage = new CategoryPage(driver);
			
			categoryPage.createCategory(categoryName, categoryDescription, driver);
			Assert.fail(); //To fail , bcz check the screenShot
	
	}
}
