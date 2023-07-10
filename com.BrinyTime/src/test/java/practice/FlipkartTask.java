package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FlipkartTask {
	@Test
public void m1()
{
	
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.flipkart.com/");
	
	driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']")).sendKeys("samsung s 20");
	
	driver.findElement(By.xpath("value=\"samsung s 20\"")).click();
	
	
}
}
