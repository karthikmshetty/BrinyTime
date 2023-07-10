import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PrakashSir {
	
	@Test
		
	public void m1() throws InterruptedException, AWTException
	{
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://mictests.com/");
		
		driver.findElement(By.xpath("//a[text()='Test Webcam']")).click();
		Thread.sleep(3000);
		Set<String> set = driver.getWindowHandles();
		
		for(String wind:set)
		{
		
	     driver.switchTo().window(wind);
	     String url=driver.getTitle();
	     if(url.contains("webcamtests"))
	    	 break;
	     
		}
		
		driver.findElement(By.xpath("//button[text()='Test my cam']")).click();
		Thread.sleep(2000);
		
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		System.out.println("popup handled handled ");
		
	}

	
}
