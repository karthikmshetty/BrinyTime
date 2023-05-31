package com.brinyTime.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutUserPage {

	//declaration
	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logoutButton;

	public WebElement getLogoutButton() {
		return logoutButton;
	}

	public LogoutUserPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void logoutUser(WebDriver driver)
	{
		
		logoutButton.click();
		
		String logoutPage = driver.getCurrentUrl();
		if (logoutPage.contains("index.php")) {
			System.out.println("Successfully logged out");
		} else {
			System.out.println("notable to lo out");
		}
	}
	
	

}
