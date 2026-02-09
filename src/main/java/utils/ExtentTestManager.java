package utils;

import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {
	
	
	private static ThreadLocal<ExtentTest> extenttest=new ThreadLocal<>();
	
	public static ExtentTest getTest() {
		return extenttest.get();		
	}
	
	public static void setTest(ExtentTest test) {
		extenttest.set(test);		
	}
	
	public static void unload() {
		extenttest.remove();
	}
	
	
	

}
