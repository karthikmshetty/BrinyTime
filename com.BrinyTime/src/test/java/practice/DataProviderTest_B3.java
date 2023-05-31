package practice;

import org.testng.annotations.Test;

public class DataProviderTest_B3 {
	
	@Test(dataProviderClass = DataProviderTest_A3.class,dataProvider = "data2")
	public void getData(String src,String dst,int price,String tarnsposrt,String transport2)
	{
		System.out.println("from--"+src+" To--"+dst+" price--"+price+"  Transport--"+tarnsposrt+"  Transport 2--- "+transport2);
		
		
	}

}
