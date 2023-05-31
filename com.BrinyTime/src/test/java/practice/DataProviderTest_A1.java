package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest_A1 {
	@DataProvider
	public Object data()
	{
		Object [][] arr= new Object[3][3];
		
		arr[0][0]="Bangalore";
		arr[0][1]="Mangalore";
		arr[0][2]=1200;

		
		arr[1][0]="Qspider";
		arr[1][1]="TestYantra";
		arr[1][2]=200;
		

		arr[2][0]="TestYantra";
		arr[2][1]="IBM";
		arr[2][2]= 30000;

		
		return arr;

		}
	
	@Test(dataProvider ="data" )
	public void getData(String src,String dst,int price)
	{
		System.out.println("from--"+src+" To--"+dst+" price--"+price);
		
		
	}

}
