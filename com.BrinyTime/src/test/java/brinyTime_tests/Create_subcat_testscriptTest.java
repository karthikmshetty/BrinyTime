package brinyTime_tests;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.brinyTime.objectRepository.SubcategoryPage;

import brinyTimeGenericUtility.BaseClass;

public class Create_subcat_testscriptTest extends BaseClass{

		@Test
		public void createSubcategory() throws Throwable, FileNotFoundException, IOException
		{        		
		
			SubcategoryPage createSubcategoryPage = new SubcategoryPage(driver);

		    String Category=eu.getExcelData("Sheet1",1,0);
		

		// for sub category
		String inputsubcat=eu.getExcelData("Sheet1",1,1)+ju.getRandomNumber();
		
		//for edit sub category
	    String edit=eu.getExcelData("Sheet1",1,2);
		
	
		//click on sub category
		driver.findElement(By.xpath("//a[text()='Sub Category ']")).click();
		createSubcategoryPage.getCreatesubcategorybtn().click();
		WebElement we =createSubcategoryPage.getCategorydropdown();
        wu.selectInDropdown(Category,we);
        
		
//		
		//enter sub category
		
        createSubcategoryPage.getInputcategory().sendKeys(inputsubcat);
        createSubcategoryPage.getCreateSubCategory().click();
        
		
		//To check the created sub category added or not
		List<WebElement> subcategory =createSubcategoryPage.getSubCategoryList();
		boolean flag=false;
		for(WebElement we1: subcategory)
		{
			
			String text=we1.getText();
		if(inputsubcat.equals(text))
		{
			System.out.println("Created subcategory is present ie. --> "+text);
			
		flag=true;
			break;	
		}
		}
		Assert.assertNotSame(flag,false,"Sub Category Not created");
		    
		    //To edit created sub category
		   WebElement element = driver.findElement(By.xpath("//td[text()='"+inputsubcat+"']//../descendant::i[@class=\"icon-edit\"]"));
		   wu.waitTillElementToBeVisible(driver,element);
		   element.click();
		    
		    //clear the field
           // To edit the sub category
		    createSubcategoryPage.getEditSubCategoryField().clear();

		    createSubcategoryPage.getEditSubCategoryField().sendKeys(edit);
		    createSubcategoryPage.getUpdateSubcategorybtn().click();
		    
		    //again click on subCategory
		    createSubcategoryPage.getVerifyUpdate().click();
			// find the edited category present or not
			
			List<WebElement> editedcategory = createSubcategoryPage.getListOfUpdate();
			boolean flag1=false;
			for(WebElement we1: editedcategory)
			{
				
				String text=we1.getText();
			if(edit.equals(text))
			{
				System.out.println("edited subcategory is present ie. --> "+text);
				
			flag1=true;
				break;	
			}
			}
			
			Assert.assertNotSame(flag1,false,"subCategory Not updated");
//			 if(flag1==false)
//				System.out.println("subCategory Not updated");
//			    
			
			

		    
		    //To delete the edited sub category
		    driver.findElement(By.xpath("//td[text()='"+edit+"']//../descendant::i[@class='icon-remove-sign']")).click();
		    //alert popup to accept the delete request
		    wu.switchToAlertPopupAndAccept(driver);
		    
		    List<WebElement> deletecategory =createSubcategoryPage.getListOfDelete();
			boolean flag2=false;
			for(WebElement we1: deletecategory)
			{
				
				String text=we1.getText();
			if(!edit.equals(text))
			{
				
				System.out.println("deleted successfully");
				
			flag2=true;
				break;	
			}
			}
			
			Assert.assertSame(flag2,true,"subcategory Not deleted");
//			    if(flag2==false)
//				System.out.println("subcategory Not deleted");
//			    
		}			

}
