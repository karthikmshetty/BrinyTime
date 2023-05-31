package com.brinyTime.objectRepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginToAdminPage {
	//declaration
	@FindBy(id="inputEmail") 
	private WebElement username;
	
	@FindBy(id="inputPassword")
	private WebElement password;
	
	@FindBy(xpath = "//button[text()=\"Login\"]")
	private WebElement button;
	public LoginToAdminPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		}
	public WebElement getUsername() {
		return username;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getButton() {
		return button;
	}
	
	public void loginToAdmin(String USERNAME,String PASSWORD)
	{
	username.sendKeys(USERNAME);
		password.sendKeys(PASSWORD);
		button.click();
	}

/*	//map 
	public void loginToAdmin(HashMap<String,String> login,WebDriver driver)
	{
		for(Entry<String, String> set:login.entrySet())
		{
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}
		
		driver.findElement(By.xpath("//button[text()=\"Login\"]")).click();
		
	}
	*/
	
	
}
