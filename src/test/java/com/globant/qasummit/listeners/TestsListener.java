package com.globant.qasummit.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestsListener implements ITestListener {

    public void onTestStart(ITestResult result) {
        System.out.println("Test STARTED "+result.getMethod().getMethodName() );
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Test PASSED "+result.getMethod().getMethodName() );
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Test FAILED "+result.getMethod().getMethodName() );
    }

    public void onStart(ITestContext context) {
        System.out.println("ON START "+context.getSuite().getName() );
    }

    public void onFinish(ITestContext context) {
        System.out.println("ON FINISH "+context.getSuite().getName() );
    }
}
