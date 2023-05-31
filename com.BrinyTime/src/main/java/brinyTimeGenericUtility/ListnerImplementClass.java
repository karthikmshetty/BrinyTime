package brinyTimeGenericUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerImplementClass implements ITestListener {

	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
	}

	
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		System.out.println("Test Script Got Fail");
		WebDriverUtility wdu =  new WebDriverUtility();
		try {
			wdu.takeScreenShot(BaseClass.sdriver, testName);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		TakesScreenshot screen=(TakesScreenshot)BaseClass.sdriver;
//		File src = screen.getScreenshotAs(OutputType.FILE);
//		LocalDateTime date=LocalDateTime.now();
//		String cDate = date.toString().replace(" ","_").replace(":","-");
//		try {
//			FileUtils.copyFile(src,new File(".\\ScreenShot\\"+testName+""+cDate+".png"));
//		} catch (IOException e) {
//			e.printStackTrace();
		}
	
	

	
	public void onTestSkipped(ITestResult result) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onStart(ITestContext context) {
	}

	public void onFinish(ITestContext context) {
	}

	
	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return super.equals(arg0);
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	

}
