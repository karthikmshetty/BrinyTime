package brinyTimeGenericUtility;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
}
	
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	public void waitTillPageGetLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IPathConstant.implicitWaitDuration));
		
	}
	
	public void waitTillElementToBeClickable(WebDriver driver, WebElement element)
	{
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(IPathConstant.implicitWaitDuration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	public void waitTillElementToBeVisible(WebDriver driver, WebElement element)
	{
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(IPathConstant.implicitWaitDuration));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * this method wait until alert to present in UI
	 *  
	 */
	public void waitForAlertPopup(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(IPathConstant.implicitWaitDuration));
        wait.until(ExpectedConditions.alertIsPresent());
		
	}
	
	public void waitForATitle(WebDriver driver, String title)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(IPathConstant.implicitWaitDuration));
        wait.until(ExpectedConditions.titleContains(title));
		
	}
	public void waitForAUrl(WebDriver driver, String url)
	   {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(IPathConstant.implicitWaitDuration));
        wait.until(ExpectedConditions.urlContains(url));
		}
	
	public void ignoreNosuchElementExc(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(IPathConstant.implicitWaitDuration));
        wait.ignoring(NoSuchElementException.class);
	}
	
	
	public void selectInDropdown(WebElement element, int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	
	public void selectInDropdown(WebElement element, String value)
	{
		Select select=new Select(element);
		select.selectByValue(value);
	}
	
	
	public void selectInDropdown(String value,WebElement element)
	{
		Select select=new Select(element);
		select.selectByVisibleText(value);
	}

	public void getAllOptionFromDropdown(WebElement element)
	{
		Select select=new Select(element);
		List<WebElement> options = select.getOptions();
		
		for(WebElement option: options)
		{
			String text=option.getText();
			System.out.println(text);
			}
	}
		
		public void mouseOverOnElement(WebDriver driver,WebElement element)
		{
			Actions actions=new Actions(driver);
			actions.moveToElement(element).perform();
		}
		
		public void rightClickOnElement(WebDriver driver,WebElement element)
		{
			Actions actions=new Actions(driver);
			actions.contextClick().perform();
		}
		
		public void doubleClickOnElement(WebDriver driver,WebElement element)
		{
			Actions actions=new Actions(driver);
			actions.doubleClick().perform();
		}
		public void switchToFrame(WebDriver driver,int index)
		{
			driver.switchTo().frame(index);
			}
		
		public void switchToFrame(WebDriver driver,String id)
		{
			driver.switchTo().frame(id);
			}

		public void switchToFrame(WebDriver driver,WebElement element)
		{
			driver.switchTo().frame(element);
			}
		/**
		 * To switch back from frame to window
		 * @param driver
		 */
		public void switchFromFrame(WebDriver driver)
		{
			driver.switchTo().defaultContent();
			}
		
public void switchToAlertPopupAndAccept(WebDriver driver)
{
	Alert al=driver.switchTo().alert();
	al.accept();

//	if(al.getText().trim().equalsIgnoreCase(text.trim()))
//	{
//		System.out.println("Alert is Present ");
//		al.accept();
//	}
//	else
//		System.out.println(" Alert is not present ");
}

public void switchToAlertPopupAndDismiss(WebDriver driver,String text)
{
	Alert al=driver.switchTo().alert();
	if(al.getText().trim().equalsIgnoreCase(text.trim()))
	{
		System.out.println("Alert is Present ");
		al.dismiss();
	}
	else
		System.out.println(" Alert is not present ");
}


public void fileUplaod(WebElement element, String path)
{
	element.sendKeys(path);
}

public void customWait(int duration,WebElement element,long pollingTime)
{
int count=0;
while(count<duration)  //consider duration 10
{
try {
	element.click();
	break;
	
}
	catch(Exception e)
{try
{
	Thread.sleep(pollingTime);  //exg giving polling time 1second or 1000 mili second
}
catch(Exception e1)
{
	e1.printStackTrace();
	}
		}
count++;
}
}


public String takeScreenShot(WebDriver driver, String screenShotNmae) throws IOException
{
	
TakesScreenshot takeSCreenShot=(TakesScreenshot)driver;
File src=takeSCreenShot.getScreenshotAs(OutputType.FILE);
LocalDateTime localDateTime=LocalDateTime.now();
String dateTime=localDateTime.toString().replace(" ","_").replace(":","-");
File dst=new File("./ScreenShot/"+screenShotNmae+""+dateTime+".png"); //last forward slash bcz last we are appending with .png 
FileUtils.copyFile(src, dst);

return screenShotNmae;
}

public void switchWindowByTtile(WebDriver driver,String title)
{
	Set<String> set = driver.getWindowHandles();
	for(String wdw:set)
	{
		driver.switchTo().window(wdw);
		String text=driver.getTitle();
		if(text.contains(title))
		{
			break;
		}
	} }

public void switchWindowByurl(WebDriver driver,String url)
{
	Set<String> set = driver.getWindowHandles();
	for(String wdw:set)
	{
		driver.switchTo().window(wdw);
		String text=driver.getCurrentUrl();
		if(text.contains(url))
		{
			break;
		}
	} }



	
	
	
}


