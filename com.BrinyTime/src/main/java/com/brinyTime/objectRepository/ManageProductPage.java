package com.brinyTime.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import brinyTimeGenericUtility.WebDriverUtility;

public class ManageProductPage {
	//declaration
	//To click on manageproduct module
	@FindBy(xpath = "//a[text()='Manage Products ']")
	private WebElement clickManageProduct;
	
	//To get all the product list from page
	@FindBy(xpath = "//table[@aria-describedby=\"DataTables_Table_0_info\"]//td[2]")
	private List<WebElement> listOfProduct;
	
	//To find the product while searching
	@FindBy(xpath = "//td[.=\"Redmi Note 4 (Gold, 32 GB)  (With 3 GB RAM)\"]")
	private WebElement searchedProduct;
	
	@FindBy(xpath = "//input[@type=\"text\"]")
    private WebElement searchBar;
	
	
	public WebElement getClickManageProduct() {
		return clickManageProduct;
	}

	public List<WebElement> getListOfProduct() {
		return listOfProduct;
	}

	public ManageProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	WebDriverUtility wu=new WebDriverUtility();
	
	//To check the inserted product is present or not
	public void VerifyInsertedProduct(String productname, WebDriver driver)
	{
		wu.waitTillElementToBeVisible(driver,clickManageProduct);
		clickManageProduct.click();
		
		//check the product added or not
		boolean flag=false;
		for(WebElement we1:listOfProduct)
		{
			String text=we1.getText();
			if(text.equals(productname))
			{
				System.out.println("Product added successfully");
				flag=true;
				break;
			}
			}
		if(flag==false)
			System.out.println("Product not added ");
		
		}
	
	
	//To Verify the searched product is there or not
	public void searchProduct(String product) throws Throwable
	{
		
		clickManageProduct.click();
		searchBar.sendKeys(product);
		Thread.sleep(3000);
		String prod=searchedProduct.getText().toLowerCase();
		
		Assert.assertTrue(prod.contains(product.toLowerCase()),"Searched Product is not present ");
		
		Reporter.log("Searched product present",true);
//		if(prod.contains(product.toLowerCase()))
//		{
//			System.out.println("searched product is present--- "+prod);
//		}
//		else 
//			System.out.println("Not able to find the searched product ");
//		
	}
	

}
