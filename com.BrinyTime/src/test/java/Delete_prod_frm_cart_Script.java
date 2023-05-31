import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.brinyTime.objectRepository.CartPage;
import com.brinyTime.objectRepository.HomePage;
import com.brinyTime.objectRepository.LoginToUser;
import com.brinyTime.objectRepository.LogoutUserPage;

import brinyTimeGenericUtility.ExcelUtility;
import brinyTimeGenericUtility.FileUtility;
import brinyTimeGenericUtility.WebDriverUtility;

public class Delete_prod_frm_cart_Script {

	public static void main(String[] args) throws Throwable {

		
		WebDriver driver=null;

		// to use genericutility we have to create the object
		WebDriverUtility webutils = new WebDriverUtility();
		FileUtility fileutils = new FileUtility();
		ExcelUtility excelUtilty = new ExcelUtility();

		// to fetch the data from property file
		String URL = fileutils.getPropertyKeyValue("url2");
		String browser = fileutils.getPropertyKeyValue("browser2");
		String username = fileutils.getPropertyKeyValue("username2");
		String password = fileutils.getPropertyKeyValue("password2");
		String carturl = fileutils.getPropertyKeyValue("carturl");
		String productcategorytitle = fileutils.getPropertyKeyValue("productcategorytitle");
		String Shopping_Portal_url = fileutils.getPropertyKeyValue("Shopping_Portal_url");

		// which browser to be used
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			//driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}

		webutils.maximizeWindow(driver);
		webutils.waitTillPageGetLoad(driver);

		// trigger the url
		driver.get(URL);
		LoginToUser loginToUser = new LoginToUser(driver);
		HomePage homepage = new HomePage(driver);
		CartPage cartPage = new CartPage(driver);
		LogoutUserPage logoutUserPage = new LogoutUserPage(driver);
		
		
		//To login the application and verify sign in page
		
		loginToUser.loginToUser(username, password, driver);
		
		

		//To add product
		homepage.addToCart(driver);
		
		//verify in cart
		cartPage.verifyAddedProduct(driver);
		
		//verify and delete the product
		cartPage.deleteProduct(driver);
		
		

		
		
		//logout
		logoutUserPage.logoutUser(driver);

		
		
	}

}
