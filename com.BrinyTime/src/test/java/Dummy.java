import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dummy {

	public static void main(String[] args) {

		
		WebDriver driver=new ChromeDriver();
		//WebDriver driver=new EdgeDriver();

		driver.get("https://www.google.com");
	}

}
