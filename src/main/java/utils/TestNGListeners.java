package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;


public class TestNGListeners extends UtilKitSetUP implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
	test.log(Status.INFO, result.getMethod().getMethodName()+" is started....");
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.addScreenCaptureFromPath(UtilKitSetUP.getScreenShot());
		test.log(Status.PASS, result.getMethod().getMethodName()+" is success....");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.addScreenCaptureFromPath(UtilKitSetUP.getScreenShot());
		test.log(Status.FAIL, result.getMethod().getMethodName()+" is failed....");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName()+" is skipped....");
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
