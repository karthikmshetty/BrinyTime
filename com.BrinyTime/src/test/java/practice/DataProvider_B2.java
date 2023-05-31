package practice;

import org.testng.annotations.Test;

public class DataProvider_B2 {

	@Test(dataProviderClass = DataProviderTest_A2.class,dataProvider = "data1")
	public void getData(String src,String dst,int price,String tarnsposrt)
	{
		System.out.println("from--"+src+" To--"+dst+" price--"+price+"  Transport--"+tarnsposrt);
		
		
	}
}
