package practice;

import org.testng.annotations.Test;

public class DataProviderTest_B1 {

	@Test(dataProviderClass = DataProviderTest_A1.class,dataProvider = "data")// for class No quotes, only for methods
	public void getData(String src,String dst,int price)
	{
		
		System.out.println("From --- "+src+" To--- "+dst+"Price--- "+price);
	}
}
