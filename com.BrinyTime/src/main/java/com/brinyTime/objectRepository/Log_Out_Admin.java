package com.brinyTime.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Log_Out_Admin {

	//Declaration
	@FindBy(xpath = "//a[@data-toggle=\"dropdown\"]")
	private WebElement logoutTab;
	
	@FindBy(xpath = "//a[text()=\"Logout\"]")
	private WebElement logoutButton;

	public WebElement getLogoutTab() {
		return logoutTab;
	}

	public WebElement getLogoutButton() {
		return logoutButton;
	}

	public Log_Out_Admin(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}
	
	public void logoutFromAdmin()
	{
		logoutTab.click();
		logoutButton.click();
		
	}
	
	
	
}
