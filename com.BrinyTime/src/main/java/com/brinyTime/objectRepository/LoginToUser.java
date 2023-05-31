package com.brinyTime.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginToUser {
	
	//Declaration
	@FindBy(xpath = "//div[@class='cnt-account']//li//i[@class='icon fa fa-sign-in']")
    private WebElement loginButton;
	
	@FindBy(name = "email")
	private WebElement usernameField;
	
	@FindBy(id = "exampleInputPassword1")
	private WebElement passwordField;
	
	@FindBy(xpath = "	//button[text()='Login']")
    private WebElement loginButton2;

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getUsernameField() {
		return usernameField;
	}

	public WebElement getPasswordField() {
		return passwordField;
	}

	public WebElement getLoginButton2() {
		return loginButton2;
	}

	public LoginToUser(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	
	public void loginToUser(String username,String password,WebDriver driver)
	{
		loginButton.click();
		String title = driver.getTitle();
		if (title.contains("Signi-in")) {
			System.out.println("signin page is displayed");
		} else
			System.out.println("sigin page is not displayed");

		
		usernameField.sendKeys(username);
		
		passwordField.sendKeys(password);
		
		loginButton2.click();
		
		
	}

	
	
	
	
	
	
	

}
