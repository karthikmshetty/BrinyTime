package com.brinyTime.objectRepository;

import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class CategoryPage {
	
	//declaration
	@FindBy(xpath ="//a[text()=' Create Category ']")
	private WebElement categoryModule;
	
	@FindBy(xpath ="//input[@placeholder='Enter category Name']")
	private WebElement categoryNameField;
	
	@FindBy(name = "description")
	private WebElement categoryDescriptionField;
	
	@FindBy(xpath ="//button[text()='Create']")
	private WebElement createButton;
	
	@FindBy(xpath = "//tbody[@role='alert']//td[2]")
	private List<WebElement> categoryList;
	
	//dlete the particular category
	@FindBy(xpath = "//tbody[@aria-live=\"polite\"]/tr/td[2]//../descendant::i[@class=\"icon-remove-sign\"]")
	private List<WebElement> listOfCategoryToDelete;
	
	//verify the deleted popup message
@FindBy(xpath = "//div[@class=\"alert alert-error\"]")
private WebElement deletedMsg;
	public WebElement getCategoryModule() {
		return categoryModule;
	}

	public WebElement getCategoryNameField() {
		return categoryNameField;
	}

	public WebElement getCategoryDescriptionField() {
		return categoryDescriptionField;
	}

	public WebElement getCreateButton() {
		return createButton;
	}

	public List<WebElement> getCategoryList() {
		return categoryList;
	}

	public CategoryPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void createCategory(String categoryName,String categoryDescription, WebDriver driver)
	{
		
		categoryModule.click();
		
		categoryNameField.sendKeys(categoryName);
		categoryDescriptionField.sendKeys(categoryDescription);
		createButton.click();
		
		
		boolean flag=false;
		for(WebElement we: categoryList)
		{
			
			String text=we.getText();
		if(categoryName.equals(text))
		{
			System.out.println("Created category is present ie. --> "+text);
		flag=true;
			break;	
		}
		}
		    if(flag==false)
			System.out.println("Category Not created");

		
		}
	
	
	
	public void deleteCategory()
	{
		String msg = deletedMsg.getText();
		Assert.assertTrue(msg.contains("Category deleted !!"),"Not Deleted");
		Reporter.log(" Category Deleted",true);
	}
	

}
