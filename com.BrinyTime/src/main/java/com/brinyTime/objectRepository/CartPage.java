package com.brinyTime.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import brinyTimeGenericUtility.WebDriverUtility;

public class CartPage {
	
	//declaration
	@FindBy(xpath = "//div[@class='basket-item-count']")
	private WebElement basketCount;
	
	@FindBy(xpath = "//div[@class=\"top-bar animate-dropdown\"]//a[text()=\"My Cart\"]")
	private WebElement myCartTab;
	
	@FindBy(xpath = "//input[@type=\"checkbox\"]")
	private WebElement checkBox;
	
	@FindBy(xpath = "//input[@value=\"Update shopping cart\"]")
	private WebElement updateButton;
	
	@FindBy(xpath = "//div[@class='shopping-cart']//div[@class='table-responsive']")
	private WebElement verifyDeletedProduct;
	
	

	public WebElement getVerifyDeletedProduct() {
		return verifyDeletedProduct;
	}

	public WebElement getBasketCount() {
		return basketCount;
	}

	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	WebDriverUtility wu=new WebDriverUtility();
	
	public void verifyAddedProduct(WebDriver driver)
	{
		String cartUrl = driver.getCurrentUrl();
		if (cartUrl.contains("my-cart")) {
			System.out.println("cart page is displayed");
		} else
			System.out.println("cart page is not displayed");
		
		
		//verify product added or not
		String count=basketCount.getText();
		
		if (count == "0") {
			System.out.println("product is not added");
		} else
			System.out.println("product is added");

		}
	
	public void deleteProduct(WebDriver driver) throws Throwable 
	{
		myCartTab.click();
		checkBox.click();
		updateButton.click();
		
		wu.switchToAlertPopupAndAccept(driver);
		wu.switchToAlertPopupAndAccept(driver);
		Thread.sleep(5000);
		
		//verify deleted product
String result=verifyDeletedProduct.getText();
		System.out.println(result);
		if(result.contains("empty"))
		{
			System.out.println("Product Deleted");
		}
		else
			System.out.println("product not deleted");
		
		
		
	}
	
	

}
