package practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AnnotationTest {

	@Test(priority = 3)
	public void create()
	{
		System.out.println("--create Method--");
	}
	@Test(dependsOnMethods = "delete",priority = 1)
	public void update()
	{
		System.out.println("--update method--");
	}
	@Test
	public void delete()
	{
		System.out.println("--Delete Method--");
	}
	
}