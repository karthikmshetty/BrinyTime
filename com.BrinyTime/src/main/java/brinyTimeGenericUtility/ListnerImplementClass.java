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
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementClass implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	
	
	//just creating empty report
		public void onStart(ITestContext context) 
		{
			//To create one empty report structer
			ExtentSparkReporter htmlreport=new ExtentSparkReporter("./extentReport/report.html");
		//To set the Title for report
		htmlreport.config().setDocumentTitle("Kusnap online");
		// set the theme
		htmlreport.config().setTheme(Theme.DARK);
		//
		htmlreport.config().setReportName("kusnap");
		// all the above for physical representation
		
		
		 report = new ExtentReports();
		report.attachReporter(htmlreport); // we created blank report now attaching with extent report.
		
		
		//like jira we are setting all the information
		report.setSystemInfo("Base-Browser","chrome");
		report.setSystemInfo("OS","Windows");
		report.setSystemInfo("Base-Url","https://localhost:8080");
		report.setSystemInfo("reporterName","Karthik");
		
		}

	
	public void onTestStart(ITestResult result) 
	{
		//execution starts from here

		String methodName = result.getMethod().getMethodName();
		test=report.createTest(methodName);
		Reporter.log(methodName+"---TestScript execution starts");
	
	}

	public void onTestSuccess(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
test.log(Status.PASS, methodName+"--Passed");
	}
 
	
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		
		test.log(Status.FAIL, methodName+"--Failed");

		
		
		WebDriverUtility wdu =  new WebDriverUtility();
		
		try {
			wdu.takeScreenShot(BaseClass.sdriver, methodName);
		} catch (IOException e1) {

			e1.printStackTrace();
		}
	}
	
	

	
	public void onTestSkipped(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();

		test.log(Status.PASS, methodName+"--Skipped");
		
		
		test.log(Status.SKIP, result.getThrowable());//To throw the exception in report bcz if the test case fails there will be exception	
		
	}

	
	
	public void onFinish(ITestContext context) {
		
		//clean the old report
		report.flush();
		
	}


}
