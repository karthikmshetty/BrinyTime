package brinyTimeGenericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v111.browser.Browser;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.brinyTime.objectRepository.Log_Out_Admin;
import com.brinyTime.objectRepository.LoginToAdminPage;

public class BaseClass {
	
	 public ExcelUtility eu=new ExcelUtility();
	public FileUtility fu=new FileUtility();
	public WebDriverUtility wu=new WebDriverUtility();
	public JavaUtility ju=new JavaUtility();
	
	
	public WebDriver driver;
	public static WebDriver sdriver; // for listner

	
	//Launch Browser
	
	//@Parameters("browser")
	@BeforeClass(groups={"smokeTest","regTest"})
	public void beforeClass_Config() throws Throwable
	{
		String BROWSER=fu.getPropertyKeyValue("browser");
		
		//launch the browser
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			System.out.println("----Chrome Browser Launched----");
		}
		if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		
		wu.maximizeWindow(driver);		
	}
	
	//Login to Application
	@BeforeMethod(groups={"smokeTest","regTest"})
	public void beforeMethod_Config() throws Throwable
	{
	String 	URL=fu.getPropertyKeyValue("url");
	String USERNAME=fu.getPropertyKeyValue("username");
	String PASSWORD=fu.getPropertyKeyValue("password");	
		
       sdriver=driver;  //for Listner
	   driver.get(URL);
	   wu.waitTillPageGetLoad(driver);
		
		LoginToAdminPage loginToAdminPage = new LoginToAdminPage(driver);
		
		loginToAdminPage.loginToAdmin(USERNAME, PASSWORD);
		
		System.out.println("----Logged In Successfully----");
		
	}
	
	//log out from application
	@AfterMethod(groups={"smokeTest","regTest"})
	public void afterMethod_Config() throws Throwable
	{
		Log_Out_Admin logoutAdmin=new Log_Out_Admin(driver);

		logoutAdmin.logoutFromAdmin();
		
		System.out.println("----Logged Out Successfully----");
	}
	
	@AfterClass(groups={"smokeTest","regTest"})
	public void afterClass_Config() throws Throwable
	{
		
		driver.quit();
		System.out.println("----Browser Closed Successfully----");

	}

}
