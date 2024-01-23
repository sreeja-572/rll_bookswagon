package com.BooksWagon.Utilities;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
public class Itestlistener implements ITestListener {
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Case Started ");
		
	}

	@Override

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Case Passed");
	
	}

	@Override

	public void onTestFailure(ITestResult result) {
		System.out.println("Test Case Failed");
		
	}

	@Override

	public void onStart(ITestContext context) {
		System.out.println("TestNG started");
	}

	@Override

	public void onFinish(ITestContext context) {
		System.out.println("TestNG Finished");
	}


}
