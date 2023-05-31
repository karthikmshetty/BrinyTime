package com.brinyTime.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import brinyTimeGenericUtility.FileUtility;
import brinyTimeGenericUtility.WebDriverUtility;

public class SubcategoryPage {
	
	WebDriverUtility wu=new WebDriverUtility();

			

	//declaration
	@FindBy(xpath = "//a[text()='Sub Category ']")
	private WebElement createsubcategorybtn;
	
	@FindBy(name = "category")
	private WebElement categorydropdown;
	
	@FindBy(xpath = "//input[@placeholder=\"Enter SubCategory Name\"]")
	private WebElement inputcategory;
	
	@FindBy(xpath = "//button[text()=\"Create\"]")
	private WebElement createSubCategory;
	
	@FindBy(xpath = "//tbody[@aria-live=\"polite\"]/tr/td[3]")
	private List<WebElement> subCategoryList;
	
	@FindBy(xpath = "//td[text()='\"+inputsubcat+\"']//../descendant::i[@class=\"icon-edit\"]")
	private WebElement editButton;
	
	@FindBy(xpath = "//input[@placeholder=\"Enter category Name\"]")
	private WebElement editSubCategoryField;
	
	@FindBy(xpath = "//button[text()=\"Update\"]")
	private WebElement updateSubcategorybtn;
	
	@FindBy(xpath = "//a[text()='Sub Category ']")
	private WebElement verifyUpdate;
	
	@FindBy(xpath = "//tbody[@role='alert']//td[3]")
	private List<WebElement> listOfUpdate;
	
	@FindBy(xpath = "//tbody[@role='alert']//td[3]")
	private List<WebElement> listOfDelete;
	

	
	public List<WebElement> getListOfDelete() {
		return listOfDelete;
	}

	public List<WebElement> getListOfUpdate() {
		return listOfUpdate;
	}

	public WebElement getVerifyUpdate() {
		return verifyUpdate;
	}

	public WebElement getEditSubCategoryField() {
		return editSubCategoryField;
	}

	public WebElement getUpdateSubcategorybtn() {
		return updateSubcategorybtn;
	}

	public WebElement getEditButton() {
		return editButton;
	}

	public WebElement getCreatesubcategorybtn() {
		return createsubcategorybtn;
	}

	public WebElement getCategorydropdown() {
		return categorydropdown;
	}

	public WebElement getInputcategory() {
		return inputcategory;
	}

	public WebElement getCreateSubCategory() {
		return createSubCategory;
	}

	public List<WebElement> getSubCategoryList() {
		return subCategoryList;
	}
	
	//constructor
	public SubcategoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//To create subcategory
	public void createSubCategory()
	{
		createSubCategory.click();
		
	}
	
	
	
}
