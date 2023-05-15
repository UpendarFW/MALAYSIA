package GenericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ListnersImplimentation implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodname=result.getMethod().getMethodName();
		System.out.println(methodname+"---->  EXECUTION STARTED ");
		
		test=report.createTest(methodname);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname=result.getMethod().getMethodName();
		System.out.println(methodname+"---->  TEST PASSED");
		
		test.log(Status.PASS,methodname+"---->  TEST PASSED");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname=result.getMethod().getMethodName();
		System.out.println(methodname+"---->  TEST FAILED ");
		
		test.log(Status.FAIL,methodname+"---->"+"FAILED");
		
		webDriver_Utility wu=new webDriver_Utility();
		Java_Utility ju=new Java_Utility();
		String date=ju.getDatein_Format();
		
		try {
			String path=wu.takeScreenShot(BaseClass_Utility.sDriver,methodname+"-"+date);
			
			test.addScreenCaptureFromPath(path);
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname=result.getMethod().getMethodName();
		System.out.println(methodname+"---->   SKIPPED ");
		
		test.log(Status.SKIP,methodname+"---->   SKIPPED ");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
			}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("SUITE EXECUTION STARTED");
		
		
		ExtentSparkReporter htmlreport=new ExtentSparkReporter(".\\ExtentReports\\Report-"+new Java_Utility().getDatein_Format()+".html");
		
		htmlreport.config().setDocumentTitle("V TIGER EXTENT REPORTS DOCUMENT");
		htmlreport.config().setReportName("V TIGER REPORTS PASS AND FAIL STATUS");
		
		
		report=new ExtentReports();
		report.attachReporter(htmlreport);
		
		report.setSystemInfo("BASE URL", "http://localhost:8888");
		report.setSystemInfo("Reported By", " Upendar Bathula");
		report.setSystemInfo("Designation", " Test Automation Engineer");
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("SUITE EXECUTION END");
		report.flush();
	}

}
