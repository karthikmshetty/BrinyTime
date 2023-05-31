package com.brinyTime.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import brinyTimeGenericUtility.WebDriverUtility;

public class HomePage {
	
	//declaration
	@FindBy(xpath = "//a[text()='Welcome -Anuj Kumar']")
    private WebElement homepageLink;
	
	//click on electronics major tab
	@FindBy(xpath = "//a[text()=' Electronics']")
    private WebElement electronicsTab;
	
	//click on mobile
	@FindBy(xpath = "//a[contains(.,'Mobiles')]")
    private WebElement mobileTab;
	
	//click on product
	@FindBy(xpath = "//a[contains(.,'Lenovo Vibe K5 Note (Gold, 32 GB)  ')]")
    private WebElement clickProduct;
	
	//click on add to cart
	@FindBy(xpath = "//a[contains(.,' ADD TO CART')]")
    private WebElement clickAddToCart;

	public WebElement getHomepageLink() {
		return homepageLink;
	}

	public WebElement getElectronicsTab() {
		return electronicsTab;
	}

	public WebElement getMobileTab() {
		return mobileTab;
	}

	public WebElement getClickProduct() {
		return clickProduct;
	}

	public WebElement getClickAddToCart() {
		return clickAddToCart;
	}

	public HomePage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
	
	
	WebDriverUtility wu=new WebDriverUtility();
			
	public void addToCart(WebDriver driver)
	{
		
		String homePageLink=homepageLink.getText();
		
		if (homePageLink.contains("Welcome")) {
			System.out.println("home page is displayed ");
		} else
			System.out.println("home page is not displayed");

		electronicsTab.click();
		
		wu.waitTillElementToBeVisible(driver, mobileTab);
		mobileTab.click();
		
		wu.waitTillElementToBeVisible(driver, clickProduct);

		clickProduct.click();
		
		clickAddToCart.click();
		
		//handle alert popup
		wu.switchToAlertPopupAndAccept(driver);
		
		
		
		
		
	}
	
	
	
	
	
}
