package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest_A3 {

	@DataProvider
	public Object data2()
	{
		Object [][] arr= new Object[4][5];
		
		arr[0][0]="Bangalore";
		arr[0][1]="Mangalore";
		arr[0][2]=1200;
		arr[0][3]="Bus";
		arr[0][4]="Flight";



		
		arr[1][0]="Qspider";
		arr[1][1]="TestYantra";
		arr[1][2]=200;
		arr[1][3]="Auto";
		arr[1][4]="Rapido";


		

		arr[2][0]="TestYantra";
		arr[2][1]="IBM";
		arr[2][2]= 30000;
		arr[2][3]="Cab";
		arr[2][4]="Bus";


		
		arr[3][0]="IBM";
		arr[3][1]="Google";
		arr[3][2]= 300000;
		arr[3][3]="Flight";
		arr[3][4]="Bus";




		
		return arr;

		}
	
	@Test(dataProvider ="data2" )
	public void getData(String src,String dst,int price,String tarnsposrt,String transport2)
	{
		System.out.println("from--"+src+" To--"+dst+" price--"+price+"  Transport--"+tarnsposrt+"  Transport 2--- "+transport2);
		
		
	}

	
	
}
