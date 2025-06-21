package com.qa.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;
import com.qa.base.TestBase;
import com.qa.util.ScreenshotUtil;

public class TestListener extends TestBase implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        WebDriver driver = TestBase.getDriver();  // thread safe
        ScreenshotUtil.takeScreenshot(driver, methodName);
        System.out.println(" Screenshot taken for failed test: " + methodName);
    }
}

