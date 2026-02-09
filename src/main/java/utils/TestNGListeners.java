package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;


public class TestNGListeners extends UtilKitSetUP implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
	ExtentTestManager.getTest().log(Status.INFO, result.getMethod().getMethodName()+" is started....");
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentTestManager.getTest().addScreenCaptureFromPath(UtilKitSetUP.getScreenShot());
		ExtentTestManager.getTest().log(Status.PASS, result.getMethod().getMethodName()+" is success....");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentTestManager.getTest().addScreenCaptureFromPath(UtilKitSetUP.getScreenShot());
		ExtentTestManager.getTest().log(Status.FAIL, result.getMethod().getMethodName()+" is failed....");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentTestManager.getTest().log(Status.SKIP, result.getMethod().getMethodName()+" is skipped....");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
	
	}

	@Override
	public void onFinish(ITestContext context) {
	
	}
	
	
	
	

}
